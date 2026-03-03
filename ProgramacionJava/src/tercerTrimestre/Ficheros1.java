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
import java.util.Scanner;

public class Ficheros1 {
	public static void main(String[] args) {
		// el método 1 y 2 son similares, solo cambian algunas líneas para hacer la función mas compacta
		// En ambos y en el método 3 leemos el fichero linea a línea
		lectura1();
		lectura2();
		// usamos la clase Scanner que ya conocemos para leer del fichero
		lectura3();
		// Leemos el fichero de una vez y lo guardamos, línea a línea, en una lista
		lectura4();
		// Leemos el fichero de una vez y lo guardamos en un String.
		lectura5();
	}

	public static void lectura1() {
		// Tratar las excepciones es obligatorio cuando se trabaja con ficheros
		try {
			// necesitamos dos objetos. FileReader simboliza al ficharo. Recibe como argumento el nombre 
			// o la ruta al mismo
			FileReader fichero = new FileReader("/mnt/temp/quijote.txt");
			// BufferedReader nos lo podemos imaginar como un cursor que apunta al lugar donde vamos leyendo
			// Como si señaláramos en un libro con el dedo la siguiente línea que nos toca leer
			// inicialmente apunta al principio del fichero
			BufferedReader lector = new BufferedReader(fichero);
			String linea;
			// Usamos un bucle para leer del fichero. Como al menos tendremos que leer una vez
			// la estructura do-while parece la mas correcta. Luego veremos una alternativa
			do{
				// readline lee una linea completa del fichero o null cuando hayamos llegado al final
				// el último caracter, el salto de línea si existe, que simbolizamos con \n se suprime cuando se lee
				linea = lector.readLine();
				if(linea!=null)
					System.out.println(linea);
			// cuando leamos null es nuestra condición de salida: hemos leído el fichero completo
			}while(linea!=null);
			// No olvidemos cerrar al final para no consumir recursos innecesariamente
			lector.close();
		// Existen excepciones concretas (FileNotFound, IOException) para la mayoría de problemas que 
		// puede haber con un fichero. Si usamos una excepción genérica, podemos ver que ocurre
		// exactamente con el método getMessage
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
	
	public static void lectura2() {
		// Este método es similar al anterior, pero mas compacto
		try {
			// Creamos en la misma sentencia los dos objetos que necesitamos
			BufferedReader lector = new BufferedReader(new FileReader("/mnt/temp/quijote.txt"));
			String linea;
			// Leemos las líneas del fichero en la condición el while y salimos si lo que leemos es null
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	public static void lectura3() {
		try {
			// En este método vamos a usar la clase Scanner que ya conocemos de cuando leíamos del teclado
			// La clase File simboliza al fichero y scanner será nuestro cursor
			File fichero = new File("/mnt/temp/quijote.txt");
			Scanner scanner = new Scanner(fichero);
			// como condición de salida usamos hasNextLine que nos devuelve false cuando llegamos al final del fichero
			// y ya no hay mas líneas para leer y true mientras que esto no ocurra
			while (scanner.hasNextLine()) {
				// nextLine lee del fichero una línea completa, hasta que se encuentra un salto de línea
				// Al igual que en el caso anterior, también suprime los caracteres \n
				String linea = scanner.nextLine();
				System.out.println(linea);
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	public static void lectura4() {
		// En este método leeremos el fichero de una vez y lo guardaremos en un ArrayList donde cada elemento
		// es una línea del fichero. Necesitamos el objeto Path que simboliza la ruta al fichero
		// Path no necesitar ir dentro de la excepción
		Path ruta = Path.of("/home/josemaria/quijote.txt");
		ArrayList<String> lineas = null;
		try {
			// El método readAllLines lee el fichero completamente y luego lo cierra y almacena el contenido en un List
			// Como nosotros no hemos usado el objeto List (y el ArrayList que si conocemos es compatible y mas potente)
			// Usamos un cast
			lineas = (ArrayList<String>)Files.readAllLines(ruta);
			// No obstante, si quieres usar List sería así:
			// List<String> lineas = Files.readAllLines(ruta);
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		// Para procesar el contenido, trabajamos con el ArrayList
		// También ha suprimido por nosotros los saltos de línea finales de cada línea
		for (String linea : lineas) {
			System.out.println(linea);
		}
	}

	public static void lectura5() {
		// El último método lee todo el contenido del fichero como un único String
		Path ruta = Path.of("/home/josemaria/quijote.txt");
		String contenido = null;
		try {
			// leemos todo el contenido de una vez en un String
			// cuidado que aquí los saltos de línea siguen existiendo. Si nuestro fichero tuviera dos lineas así
			// uno
			// dos
			// contenido sería así: "uno\ndos"
			// El \n simboliza el salto de línea y ocupa un solo caracter y no dos
			contenido = Files.readString(ruta);
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		System.out.print(contenido);
	}
}
