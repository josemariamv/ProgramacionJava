package ejemplos;

import java.util.Scanner;

public class HistogramaVocales {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Escribe un texto: ");
		String texto = teclado.nextLine().toLowerCase();

		String vocales = "aeiou";
		int[] contadores = new int[vocales.length()];

		// 1. Contar cada vocal (las acentuadas cuentan como su vocal)
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);

			switch (c) {
			case 'a':
			case 'á':
				contadores[0]++;
				break;
			case 'e':
			case 'é':
				contadores[1]++;
				break;
			case 'i':
			case 'í':
				contadores[2]++;
				break;
			case 'o':
			case 'ó':
				contadores[3]++;
				break;
			case 'u':
			case 'ú':
			case 'ü':
				contadores[4]++;
				break;
			}
		}

		// 2. Dibujar el histograma: un bucle para las vocales y otro para la barra
		System.out.println("\nHistograma de vocales del texto anterior: ");
		for (int i = 0; i < vocales.length(); i++) {
			System.out.printf("%c: ", vocales.charAt(i));

			for (int j = 0; j < contadores[i]; j++) {
				System.out.print("*");
			}

			System.out.println(" (" + contadores[i] + ")");
		}
	}
}
