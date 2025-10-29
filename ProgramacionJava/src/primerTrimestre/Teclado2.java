package primerTrimestre;

import java.util.Scanner;

public class Teclado2 {

	public static void main(String[] args) {
		// La clase scanner tiene un pequeño problema cuando leemos números y a continuación frases. Míralo a continuación:
		
		Scanner lector = new Scanner(System.in);
		
		System.out.print("Escribe un número entero: ");
		int numero = lector.nextInt();
		
		System.out.println("Escribe ahora una frase: ");
		String texto = lector.nextLine();
		
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

		lector.close();
		otroLector.close();
		
	}

}
