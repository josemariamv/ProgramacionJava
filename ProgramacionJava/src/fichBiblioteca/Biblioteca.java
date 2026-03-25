package fichBiblioteca;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Gestor de biblioteca con acceso aleatorio a ficheros
 */
class Biblioteca {
    private RandomAccessFile archivo;
    private int tamanoRegistro;
    private String nombreArchivo;
    
    public Biblioteca(String nombreArchivo) throws IOException {
        this.nombreArchivo = nombreArchivo;
        this.tamanoRegistro = Libro.getTamanoRegistro();
        
        // Abrir el archivo en modo lectura/escritura
        archivo = new RandomAccessFile(nombreArchivo, "rw");
        
        // Si el archivo está vacío, inicializar con un header
        if (archivo.length() == 0) {
            archivo.writeInt(0); // Escribir el contador de libros
        }
    }
    
    /**
     * Obtiene la posición del registro dado su ID
     * Fórmula: header (4 bytes) + (id-1) * tamaño_registro
     */
    private long getPosicionPorId(int id) {
        return 4 + (id - 1) * tamanoRegistro;
    }
    
    /**
     * Añade un nuevo libro al final del archivo
     */
    public void agregarLibro(Libro libro) throws IOException {
        // Leer el último ID usado
        archivo.seek(0);
        int ultimoId = archivo.readInt();
        
        // Asignar nuevo ID
        libro.setId(ultimoId + 1);
        
        // Mover al final del archivo
        archivo.seek(archivo.length());
        
        // Escribir el libro
        libro.escribir(archivo);
        
        // Actualizar el contador de IDs
        archivo.seek(0);
        archivo.writeInt(ultimoId + 1);
        
        System.out.println("✅ Libro añadido con ID: " + libro.getId());
    }
    
    /**
     * Busca y devuelve un libro por su ID (acceso aleatorio directo)
     */
    public Libro buscarLibro(int id) throws IOException {
        long posicion = getPosicionPorId(id);
        
        // Verificar que la posición existe
        if (posicion >= archivo.length()) {
            return null;
        }
        
        archivo.seek(posicion);
        return Libro.leer(archivo);
    }
    
    /**
     * Actualiza un libro existente (modificación directa)
     */
    public boolean actualizarLibro(int id, Libro libroActualizado) throws IOException {
        long posicion = getPosicionPorId(id);
        
        if (posicion >= archivo.length()) {
            return false;
        }
        
        // Mantener el mismo ID
        libroActualizado.setId(id);
        
        // Posicionarse y sobrescribir
        archivo.seek(posicion);
        libroActualizado.escribir(archivo);
        
        System.out.println("✅ Libro actualizado correctamente");
        return true;
    }
    
    /**
     * Presta un libro (actualiza solo el campo prestado)
     */
    public boolean prestarLibro(int id, String nombreUsuario) throws IOException {
        Libro libro = buscarLibro(id);
        
        if (libro == null) {
            System.out.println("❌ Libro no encontrado");
            return false;
        }
        
        if (libro.isPrestado()) {
            System.out.println("❌ El libro ya está prestado a: " + libro.getPrestadoA());
            return false;
        }
        
        // Actualizar campos
        libro.setPrestado(true);
        libro.setPrestadoA(nombreUsuario);
        
        // Guardar cambios
        return actualizarLibro(id, libro);
    }
    
    /**
     * Devuelve un libro
     */
    public boolean devolverLibro(int id) throws IOException {
        Libro libro = buscarLibro(id);
        
        if (libro == null) {
            System.out.println("❌ Libro no encontrado");
            return false;
        }
        
        if (!libro.isPrestado()) {
            System.out.println("❌ El libro no estaba prestado");
            return false;
        }
        
        // Actualizar campos
        libro.setPrestado(false);
        libro.setPrestadoA("");
        
        // Guardar cambios
        return actualizarLibro(id, libro);
    }
    
    /**
     * Elimina lógicamente un libro (marcar como eliminado)
     * En un sistema real, podríamos marcarlo como eliminado sin borrar físicamente
     */
    public boolean eliminarLibro(int id) throws IOException {
        Libro libro = buscarLibro(id);
        
        if (libro == null) {
            System.out.println("❌ Libro no encontrado");
            return false;
        }
        
        // Sobrescribir con datos vacíos (eliminación lógica)
        libro.setTitulo("--- ELIMINADO ---");
        libro.setAutor("--- ELIMINADO ---");
        libro.setPrestado(false);
        
        return actualizarLibro(id, libro);
    }
    
    /**
     * Lista todos los libros (recorrido secuencial)
     */
    public void listarTodosLosLibros() throws IOException {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("CATÁLOGO DE LIBROS");
        System.out.println("=".repeat(80));
        
        // Leer el contador
        archivo.seek(0);
        int totalLibros = archivo.readInt();
        
        if (totalLibros == 0) {
            System.out.println("📚 No hay libros en la biblioteca");
            return;
        }
        
        // Recorrer todos los registros
        for (int i = 1; i <= totalLibros; i++) {
            try {
                Libro libro = buscarLibro(i);
                if (libro != null && !libro.getTitulo().equals("--- ELIMINADO ---")) {
                    System.out.println(libro);
                }
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println("=".repeat(80));
    }
    
    /**
     * Cierra el archivo
     */
    public void cerrar() throws IOException {
        if (archivo != null) {
            archivo.close();
        }
    }
}
