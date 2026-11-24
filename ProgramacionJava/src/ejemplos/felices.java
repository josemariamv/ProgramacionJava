package ejemplos;

import java.util.Scanner;

// ejercicio de los números felices
public class felices {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Escribe un entero y te diré si es feliz: ");
		String numero = teclado.nextLine();
		teclado.close();
		int pasos = 0;
		int suma = 0;
		String temporal = numero;
		// con expresiones regulares ya podemos hacer
		// facilmente la validación de la entrada
		if (numero.matches("[1-9][0-9]*")) {
			// aquí iría el bucle que me resuelve el problema
			do {
				suma = 0;
				for (int i = 0; i < temporal.length(); i++) {
					// otra forma de convertir un char a entero
					int cifra = Integer.valueOf(temporal.charAt(i)) - 48;
					cifra *= cifra;
					suma += cifra;
				}
				temporal = String.valueOf(suma);
				pasos++;
			} while (suma != 1 && suma != 4);

			if (suma == 1)
				System.out.println("El número " + numero + " es feliz en " + pasos + " pasos");
			else
				System.out.println("El número " + numero + " no es feliz");
		} else
			System.out.println(numero + " no es un número entero");
	}
}
