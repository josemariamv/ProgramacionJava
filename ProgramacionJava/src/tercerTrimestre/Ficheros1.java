package tercerTrimestre;
/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
*/
import java.io.*;
import java.util.Scanner;

public class Ficheros1 {
	public static void main(String[] args) {
		lectura1();
		lectura2();
		lectura3();
	}

	public static void lectura1() {
		try {
			FileReader fichero = new FileReader("/mnt/temp/quijote.txt");
			BufferedReader lector = new BufferedReader(fichero);

			String linea;
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		//} catch (IOException e) {
		//} catch (IOException e) {
		}catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	public static void lectura2() {
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

	public static void lectura3() {
		try (BufferedReader lector = new BufferedReader(new FileReader("/mnt/temp/quijote.txt"))) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			// con este método no hace falta cerrar el recurso. Se cierra solo cuando deja de usarse.
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
			// e.printStackTrace();
		}
	}
}
