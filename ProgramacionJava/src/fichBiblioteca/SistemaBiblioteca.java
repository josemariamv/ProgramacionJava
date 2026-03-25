package fichBiblioteca;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal con menú interactivo
 */
public class SistemaBiblioteca {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca;
    
    public static void main(String[] args) {
        try {
            biblioteca = new Biblioteca("biblioteca.dat");
            
            int opcion;
            do {
                mostrarMenu();
                opcion = leerEntero("Seleccione una opción: ");
                
                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        buscarLibro();
                        break;
                    case 3:
                        prestarLibro();
                        break;
                    case 4:
                        devolverLibro();
                        break;
                    case 5:
                        eliminarLibro();
                        break;
                    case 6:
                        biblioteca.listarTodosLosLibros();
                        break;
                    case 0:
                        System.out.println("👋 ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("❌ Opción no válida");
                }
                
                if (opcion != 0) {
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                }
                
            } while (opcion != 0);
            
            biblioteca.cerrar();
            
        } catch (IOException e) {
            System.err.println("Error con el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 SISTEMA DE GESTIÓN DE BIBLIOTECA");
        System.out.println("=".repeat(50));
        System.out.println("1. 📖 Agregar libro");
        System.out.println("2. 🔍 Buscar libro por ID");
        System.out.println("3. 🔄 Prestar libro");
        System.out.println("4. ↩️  Devolver libro");
        System.out.println("5. 🗑️  Eliminar libro");
        System.out.println("6. 📋 Listar todos los libros");
        System.out.println("0. 🚪 Salir");
        System.out.println("=".repeat(50));
    }
    
    private static void agregarLibro() throws IOException {
        System.out.println("\n--- NUEVO LIBRO ---");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        int anyo = leerEntero("Año de publicación: ");
        
        Libro libro = new Libro(0, titulo, autor, anyo);
        biblioteca.agregarLibro(libro);
    }
    
    private static void buscarLibro() throws IOException {
        int id = leerEntero("ID del libro a buscar: ");
        Libro libro = biblioteca.buscarLibro(id);
        
        if (libro != null) {
            System.out.println("\n📖 LIBRO ENCONTRADO:");
            System.out.println(libro);
        } else {
            System.out.println("❌ No existe ningún libro con ID: " + id);
        }
    }
    
    private static void prestarLibro() throws IOException {
        int id = leerEntero("ID del libro a prestar: ");
        
        System.out.print("Nombre del usuario: ");
        String usuario = scanner.nextLine();
        
        biblioteca.prestarLibro(id, usuario);
    }
    
    private static void devolverLibro() throws IOException {
        int id = leerEntero("ID del libro a devolver: ");
        biblioteca.devolverLibro(id);
    }
    
    private static void eliminarLibro() throws IOException {
        int id = leerEntero("ID del libro a eliminar: ");
        biblioteca.eliminarLibro(id);
    }
    
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Debe ingresar un número: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return numero;
    }
}
