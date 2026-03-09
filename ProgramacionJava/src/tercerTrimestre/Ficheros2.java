package tercerTrimestre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ficheros2 {

	public static void main(String[] args) {
		escritura1();
		escritura1bis();
		escritura2();
		escritura3();
		escritura4();
		escritura5();
	}

	public static void escritura1() {
		try {
			// si el fichero no existe se crea. Si existe se borra su contenido antes de
			// escribir
			FileWriter escritor = new FileWriter("/mnt/temp/java.txt");
			escritor.write("Hola, mundo con FileWriter!\n");
			escritor.write("Escribiendo una segunda línea.");
			System.out.println("Archivo escrito correctamente.");
			escritor.close();
		} catch (Exception e) {
			System.err.println("Error al escribir el archivo: " + e.getMessage());
		}
		try {
			// el segundo parámetro, true, indica que se añade al final (append) si el
			// fichero ya existe
			// si el fichero no existe se crea
			FileWriter escritor = new FileWriter("/mnt/temp/java.txt", true);
			escritor.write("\nEsta línea se añade al final.");
		} catch (Exception e) {
			System.err.println("Error al añadir al archivo: " + e.getMessage());
		}
	}

	public static void escritura1bis() {
		// Idem al anterior pero usamos try-with-resources para que el fichero se cierre
		// automáticamente
		try (FileWriter escritor = new FileWriter("/mnt/temp/java.txt")) {
			escritor.write("Hola, mundo con FileWriter!\n");
			escritor.write("Escribiendo una segunda línea.");
			// Podríamos escribir caracteres sueltos o arrays de char.
			System.out.println("Archivo escrito correctamente.");
		} catch (Exception e) {
			System.err.println("Error al escribir el archivo: " + e.getMessage());
		}

		try (FileWriter escritor = new FileWriter("/mnt/temp/java.txt", true)) {
			escritor.write("\nEsta línea se añade al final.");
		} catch (Exception e) {
			System.err.println("Error al añadir al archivo: " + e.getMessage());
		}
	}

	public static void escritura2() {
		// BufferedWriter es mas eficiente. sobre todo para grandes datos
		// Usa un buffer intermedio. Por lo mismo es mas crítico no olvidar cerrar el
		// fichero
		// Podemos usar la estrategia de try-with-resource para no olvidarlo
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter("/mnt/temp/java.txt"))) {
			// BufferedWriter escritor = new BufferedWriter(new
			// FileWriter("/mnt/temp/java.txt");
			escritor.write("Primera línea con Buffer.");
			// Escribe el salto de línea. Es mas portable porque si en el sistema en el que
			// se ejecuta se usa otro caracter diferente al \n lo tiene en cuenta
			escritor.newLine();
			escritor.write("Segunda línea. Es más eficiente.");
			escritor.newLine();
			// escritor.close();
			System.out.println("Archivo escrito eficientemente.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		// también podemos añadir
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter("/mnt/temp/java.txt", true))) {
			escritor.write("Última línea.");
			System.out.println("Añadido.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void escritura3() {
		// Usamos try-with-resources para no tener que cerrar el fichero manualmente
		// Especificamos el juego de caracteres que vamos a usar (opcional)
		try (PrintWriter escritor = new PrintWriter("/mnt/temp/java.txt", StandardCharsets.UTF_8)) {
			escritor.println("Línea 1: Hola con PrintWriter.");
			escritor.print("Línea 2: Esto no tiene salto de línea. ");
			escritor.println("Pero esto sí lo añade.");

			// Formateo de datos
			String nombre = "Ana";
			int edad = 30;
			double altura = 1.7589;
			escritor.printf("Usuario: %s, Edad: %d, Altura: %.2f m", nombre, edad, altura);
			escritor.println(); // Salto de línea adicional

			System.out.println("Archivo escrito con formato correctamente.");

			// Podemos comprobar si hubo errores que no generen excepción así:
			if (escritor.checkError()) {
				System.err.println("Ocurrió un error durante la escritura.");
			}

		} catch (Exception e) {
			System.err.println("Error al abrir/crear el archivo: " + e.getMessage());
		}
		// Para añadir con PrintWriter
		try (PrintWriter escritor = new PrintWriter(
                new FileWriter("/mnt/temp/java.txt", StandardCharsets.UTF_8, true))) {
            
            escritor.println("Esta línea se añade al final.");
            escritor.printf("Número de línea: %d%n", 42);
            
            System.out.println("Texto añadido correctamente con PrintWriter");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

	public static void escritura4() {
		Path rutaArchivo = Paths.get("/mnt/temp/java.txt");
		ArrayList<String> lineas = new ArrayList<>(List.of("Primera Linea", "Segunda línea", "Tercera línea"));

		try {
			// Escribe la lista, una línea por elemento
			Files.write(rutaArchivo, lineas, StandardCharsets.UTF_8);
			System.out.println("Lista escrita en archivo.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		// y para añadir
		ArrayList<String> nuevasLineas = new ArrayList<>(List.of("Cuarta línea", "Quinta línea"));
		try {
            Files.write(
            	rutaArchivo, 
                nuevasLineas, 
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,   
                StandardOpenOption.APPEND
            );
            
            System.out.println("Líneas añadidas correctamente");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

	public static void escritura5() {
		Path rutaArchivo = Paths.get("/mnt/temp/java.txt");
		String contenido = "Este es el contenido a escribir.\nSegunda línea.";
		try {
			// Sobrescribe por defecto
			Files.writeString(rutaArchivo, contenido, StandardCharsets.UTF_8);
			System.out.println("Archivo escrito con Files.writeString");

			// Añadir más contenido (append)
			String masContenido = "\nAñadiendo más texto.";
			Files.writeString(rutaArchivo, masContenido, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			System.out.println("Texto añadido.");

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
