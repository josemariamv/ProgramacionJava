package ejemplos;

import java.util.Scanner;

public class Boletin5 {
	public static void main(String[] args) {
		// ejercicios 15 y 16
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un NIF o un NIE: ");
		String entrada = teclado.nextLine();
		if (entrada.length() != 9)
			System.out.println("No tiene 9 caracteres");
		else {
			char ultimoCaracter = entrada.toUpperCase().charAt(8);
			if ((int) ultimoCaracter < 65 || (int) ultimoCaracter > 90)
				System.out.println("El último caracter no es una letra");
			else {
				String subcadena = entrada.substring(1, 8);
				boolean correcto = true;
				for (int i = 0; i < subcadena.length(); i++) {
					int ascii = (int) subcadena.charAt(i);
					if (ascii < 48 || ascii > 57)
						correcto = false;
				}
				if (correcto == true) {
					char primerCaracter = entrada.toUpperCase().charAt(0);
					if ((int) primerCaracter >= 48 && (int) primerCaracter <= 57)
						System.out.println("Es un NIF");
					else if (primerCaracter == 'X' || primerCaracter == 'Y' || primerCaracter == 'Z')
						System.out.println("Es un NIE");
					else
						System.out.println("La entrada no es ni un NIF ni un NIE");
				} else
					System.out.println("La entrada no es ni un NIF ni un NIE");
			}
		}
	}
}
