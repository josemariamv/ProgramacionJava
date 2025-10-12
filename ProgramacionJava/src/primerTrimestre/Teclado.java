package primerTrimestre;
import java.util.Scanner;
import java.util.Locale;

public class Teclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Lectura desde el teclado */

		// Necesitamos crear un objeto de la clase Teclado:
		// Esta es la sintaxis para crear un objeto (lector) de la clase Teclado
		// El constructor es una función especial que se llama igual que la clase
		Scanner lector = new Scanner(System.in);

		// Recuerda siempre poner en pantalla un mensaje diciendo que quieres leer
		System.out.println("Nombre:");
		// el método nextLine lee una cadena de texto hasta que pulsas intro y mete su
		// valor en una variable
		// los métodos son funciones que solo se pueden usar con objetos de una clase
		// la sintaxis es la que ves aquí abajo: nombre del objeto (lector) seguido de
		// un punto
		// y a continuación el nombre del método (nextLine en este caso)
		String nombre = lector.nextLine();
		System.out.println("Hola, " + nombre);

		// Las lecturas quedan mucho mejor si usamos print en lugar de println y así
		// leemos en la misma línea que el mensaje
		System.out.print("Edad: ");
		// nextInt lee un entero. Si lo que escribes no se puede convertir a entero da
		// un error
		int edad = lector.nextInt();
		System.out.println("Tu edad es: " + edad + " años");

		System.out.print("Cuanto cobras al mes. Usa una coma como signo decimal: ");
		// nextDouble lee un número con decimales. Igual que antes, si no puede
		// convertir a número lo que escribimos da un error
		// Si tenemos nuestro sistema en castellano usamos una coma como símbolo decimal
		// y no un punto
		// si usas un simbolo decima diferente del de tu configuración regional dará
		// error
		double sueldo = lector.nextDouble();
		System.out.println("Tu sueldo anual es de: " + sueldo * 12);

		// Podemos crear un scanner de teclado con la configuración regional que
		// necesitemos.
		lector.useLocale(Locale.ENGLISH);
		System.out.print("Cuanto cobras al mes. Usa un punto como signo decimal: ");
		sueldo = lector.nextDouble();
		System.out.println("Tu sueldo anual es de: " + sueldo * 12);

		// No olvides cerrar el scanner cuando termines de usarlo
		lector.close();
	}

}
