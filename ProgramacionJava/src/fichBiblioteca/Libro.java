package fichBiblioteca;

import java.io.*;

/**
 * Clase que representa un libro en la biblioteca
 * Implementa Serializable para poder guardar objetos
 */
class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String titulo;
    private String autor;
    private int anyoPublicacion;
    private boolean prestado;
    private String prestadoA;
    
    // Tamaño fijo para campos de texto (para acceso aleatorio)
    public static final int TAMANO_TITULO = 50;
    public static final int TAMANO_AUTOR = 40;
    public static final int TAMANO_PRESTADO_A = 30;
    
    public Libro(int id, String titulo, String autor, int anyoPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anyoPublicacion = anyoPublicacion;
        this.prestado = false;
        this.prestadoA = "";
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public int getAnyoPublicacion() { return anyoPublicacion; }
    public void setAnyoPublicacion(int anyoPublicacion) { this.anyoPublicacion = anyoPublicacion; }
    
    public boolean isPrestado() { return prestado; }
    public void setPrestado(boolean prestado) { this.prestado = prestado; }
    
    public String getPrestadoA() { return prestadoA; }
    public void setPrestadoA(String prestadoA) { this.prestadoA = prestadoA; }
    
    // Calcular el tamaño total del registro en bytes
    public static int getTamanoRegistro() {
        return 4 + // id (int)
                TAMANO_TITULO * 2 + // titulo (String en UTF-16)
                TAMANO_AUTOR * 2 + // autor (UTF-16)
                4 + // anyoPublicacion (int)
                1 + // prestado (boolean)
                TAMANO_PRESTADO_A * 2; // prestadoA (UTF-16)
    }
    
    /**
     * Escribe el libro en el RandomAccessFile en la posición actual
     */
    public void escribir(RandomAccessFile raf) throws IOException {
        raf.writeInt(id);
        escribirStringFijo(raf, titulo, TAMANO_TITULO);
        escribirStringFijo(raf, autor, TAMANO_AUTOR);
        raf.writeInt(anyoPublicacion);
        raf.writeBoolean(prestado);
        escribirStringFijo(raf, prestadoA, TAMANO_PRESTADO_A);
    }
    
    /**
     * Lee un libro desde la posición actual del RandomAccessFile
     */
    public static Libro leer(RandomAccessFile raf) throws IOException {
        int id = raf.readInt();
        String titulo = leerStringFijo(raf, TAMANO_TITULO);
        String autor = leerStringFijo(raf, TAMANO_AUTOR);
        int anyoPublicacion = raf.readInt();
        boolean prestado = raf.readBoolean();
        String prestadoA = leerStringFijo(raf, TAMANO_PRESTADO_A);
        
        Libro libro = new Libro(id, titulo, autor, anyoPublicacion);
        libro.setPrestado(prestado);
        libro.setPrestadoA(prestadoA);
        return libro;
    }
    
    /**
     * Escribe un String con tamaño fijo (rellena con espacios o trunca)
     */
    private static void escribirStringFijo(RandomAccessFile raf, String str, int tamanio) 
            throws IOException {
        if (str == null) str = "";
        if (str.length() > tamanio) {
            str = str.substring(0, tamanio);
        }
        
        // Escribimos como char array (UTF-16)
        char[] chars = new char[tamanio];
        for (int i = 0; i < tamanio; i++) {
            chars[i] = i < str.length() ? str.charAt(i) : ' ';
        }
        
        for (char c : chars) {
            raf.writeChar(c);
        }
    }
    
    /**
     * Lee un String de tamaño fijo
     */
    private static String leerStringFijo(RandomAccessFile raf, int tamanio) 
            throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanio; i++) {
            char c = raf.readChar();
            sb.append(c);
        }
        return sb.toString().trim();
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s (%d) | %s", 
            id, titulo, autor, anyoPublicacion, 
            prestado ? "PRESTADO a " + prestadoA : "DISPONIBLE");
    }
}