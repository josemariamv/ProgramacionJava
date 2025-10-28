package primerTrimestre;

import java.util.Scanner;

public class CondicionalSwitch{
	public static void main(String[] args) {
				
		Scanner teclado = new Scanner(System.in);
		System.out.print("Escribe un número del 2 al 4: ");
		int numero = teclado.nextInt();
		/*
		 * La instrucción switch permite hacer una elección múltiple evaluando el valor de una variable que se pone entre paréntesis
		 * Pondremos una instrucción case por cada posible valor que queremos comprobar. En el siguiente ejemplo  se evalua si el valor
		 * de la variable numero es igual a 2, a 3 o a 4. En cualquier otro caso la instrucción no hace nada
		 * Una vez que se encuentra una correspondencia (numero = 3, por ejemplo) y se entra en el bloque de instrucciones de ese case
		 * se ejecutan todas las instrucciones hasta encontrar un break o  salir del switch
		 */
		switch(numero) {
		  case 2:
		    System.out.println("Es un patito");
		    break;
		  case 3:
		    System.out.println("Es una serpiente");
		    break;
		  case 4:
		    System.out.println("Es una silla");
		    /* Este últomo break sobra porque ya termina la instrucción, pero así queda mas uniforme */
		    break;
		}
		
		/* También funciona con letras, con cadenas, etc. */
		System.out.print("Escribe P para jugar, C para configurar o X para salir: ");
		String opcion = teclado.nextLine();
		switch(opcion) {
		  case "P":
		    System.out.println("Vamos a jugar");
		    break;
		  case "C":
		    System.out.println("Entramos en la configuración");
		    break;
		  case "X":
		    System.out.println("Saliendo del juego. Hasta la próxima");
		    break;
		}
		
		/*
		 * Si queremos que un bloque se ejecute si no se cumple ninguna condición de case añadimos 
		 * un bloque con la sentencia default. Este bloque debe de ir siempre al final
		 */
		System.out.print("Escribe P para jugar, C para configurar o X para salir: ");
		opcion = teclado.nextLine();
		switch(opcion) {
		  case "P":
		    System.out.println("Vamos a jugar");
		    break;
		  case "C":
		    System.out.println("Entramos en la configuración");
		    break;
		  case "X":
		    System.out.println("Saliendo del juego. Hasta la próxima");
		    break;
		 default:
			 System.out.println("Opción no válida");
		}
		
		/*
		 * Si queremos que varias opciones ejecuten el mismo bloque podemos hacer algo así.
		 * En este caso el primer bloque se ejecuta tanto con P como con p. Podemos incluir de esta forma tantos 
		 * case como necesitemos
		 */
		System.out.print("Escribe P para jugar, C para configurar o X para salir: ");
		opcion = teclado.nextLine();
		switch(opcion) {
		  case "P":
		  case "p":
		    System.out.println("Vamos a jugar");
		    break;
		  case "C":
		  case "c":
		    System.out.println("Entramos en la configuración");
		    break;
		  case "X":
		  case "x":
		    System.out.println("Saliendo del juego. Hasta la próxima");
		    break;
		 default:
			 System.out.println("Opción no válida");
		}
		
		/*
		 * O también podemos hacer esto que queda mas claro:
		 */
		System.out.print("Escribe P para jugar, C para configurar o X para salir: ");
		opcion = teclado.nextLine();
		switch(opcion) {
		  case "P", "p", "J", "j":
		    System.out.println("Vamos a jugar");
		    break;
		  case "C", "c":
		    System.out.println("Entramos en la configuración");
		    break;
		  case "X", "x", "S", "s":
		    System.out.println("Saliendo del juego. Hasta la próxima");
		    break;
		 default:
			 System.out.println("Opción no válida");
		}
		
		/*
		 * Un switch siempre puede sustituirse por un bloque de if-else anidados. Pero
		 * cuando tenemos muchas opciones a evaluar un switch puede ser mas claro
		 */
		
		teclado.close();
	}
}