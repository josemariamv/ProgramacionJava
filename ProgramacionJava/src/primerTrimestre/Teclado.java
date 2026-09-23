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
		
		// existen otros lectores: nextLong, nextFloat, nextShort, etc. Hay que usar el adecuado siempre
		// dependiendo de lo que queramos obtener y donde vayamos a guardarlo
		
		// La clase scanner tiene un pequeño problema cuando leemos números y a continuación frases. Míralo a continuación:
		
		lector = new Scanner(System.in);
				
		System.out.print("Escribe un número entero: ");
		int numero = lector.nextInt();
				
		System.out.println("Escribe ahora una frase: ");
		String texto = lector.nextLine();
		
		System.out.println(numero);
		System.out.println(texto);
				
		// Si ejecutas lo anterior verás que no te llega a pedir la frase. 
		// Aparece el mensaje en pantalla pero luego el programa termina
		// Eso es debido a que después de leer el número (ya sea entero o double) la tecla intro que pulsas
		// a continuación se queda en el buffer del teclado y es como si escribieras 
		//una frase sin nada
				
		// Para solucionarlo podemos hacer dos cosas
		// La primera, leer un texto inmediatamente después del número para "limpiar" el buffer:
				
		System.out.print("Escribe un número entero: ");
		numero = lector.nextInt();
		lector.nextLine(); // Esta lectura limpiará el buffer del teclado y lo dejará listo para leer el texto
		System.out.print("Escribe ahora una frase: ");
		texto = lector.nextLine();
				
		// Otra estrategia consiste en usar dos objetos diferentes: uno para leer los números
		// Y otro para leer los textos ya que el buffer no es compartido
		Scanner otroLector =  new Scanner(System.in);
				
		System.out.print("Escribe un número entero: ");
		numero = lector.nextInt();
				
		System.out.print("Escribe ahora una frase: ");
		texto = otroLector.nextLine();
				
		// Fíjate que el problema no ocurre cuando lees dos números seguidos:
		System.out.print("Escribe un número entero: ");
		numero = lector.nextInt();
		System.out.print("Escribe otro mas: ");
		numero = lector.nextInt();
				
		// Ni cuando lees dos textos seguidos:
		System.out.print("Escribe ahora una frase: ");
		texto = otroLector.nextLine();
		System.out.print("Escribe ahora otra frase: ");
		texto = otroLector.nextLine();
		
		
		// No olvides cerrar el scanner cuando termines de usarlo
		lector.close();
		otroLector.close();
	}

}
