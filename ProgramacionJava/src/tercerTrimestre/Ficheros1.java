package tercerTrimestre;

/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
*/
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ficheros1 {
	public static void main(String[] args) {
		lectura1();
		lectura2();
		lectura3();
		lectura4();
		lectura5();
	}

	public static void lectura1() {
		try {
			FileReader fichero = new FileReader("/mnt/temp/quijote.txt");
			BufferedReader lector = new BufferedReader(fichero);

			String linea;
			
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			// también podríamos usar un do while
			/*
			do{
				linea = lector.readline();
				if(linea!=null)
					System.out.println(linea);
			}while(linea!=null);
			*/
			lector.close();
			// } catch (IOException e) {
			// } catch (IOException e) {
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
	
	public static void lectura2() {
		try (BufferedReader lector = new BufferedReader(new FileReader("/mnt/temp/quijote.txt"))) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
			// e.printStackTrace();
		}
	}

	public static void lectura3() {
		try {
			File fichero = new File("/mnt/temp/quijote.txt");
			Scanner scanner = new Scanner(fichero);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				System.out.println(linea);
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	public static void lectura4() {
		Path ruta = Path.of("/home/josemaria/quijote.txt");
		try {
			// List<String> lineas = Files.readAllLines(ruta);
			ArrayList<String> lineas = (ArrayList)Files.readAllLines(ruta);

			// Leemos todo el contenido como una lista de líneas
			for (String linea : lineas) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	public static void lectura5() {
		Path ruta = Path.of("/home/josemaria/quijote.txt");
		try {
			// leemos todo el contenido de una vez
			String contenido = Files.readString(ruta);
			System.out.print(contenido);
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
}
