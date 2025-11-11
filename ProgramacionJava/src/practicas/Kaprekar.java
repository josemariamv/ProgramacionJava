package practicas;

import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número de cuatro cifras que no tenga todas sus cifras iguales: ");
		int entrada = 0;
		final int kaprekar = 6174;
		try {
			entrada = teclado.nextInt();
		} catch (Exception e) {
			System.out.println("No has introducido un número entero");
		} finally {
			teclado.close();
		}
		if (entrada != 0) {
			String numTxt = Integer.toString(entrada);
			if (numTxt.length() != 4)
				System.out.println("Tu número no tiene exactamente cuatro cifras");
			else {
				boolean hayDiferencias = false;
				for (int i = 1; i < 4; i++)
					if (numTxt.charAt(0) != numTxt.charAt(i))
						hayDiferencias = true;
				if (hayDiferencias == false)
					System.out.println(
							"No puedo obtener la constante de kaprekar si las cuatro cifras del número son iguales");
				else if (entrada == kaprekar)
					System.out.println("El número que has introducido ya es la constante de kaprekar");
				else {
					System.out.println("Pasos para obtener la constante de kaprekar a partir del número " + entrada);
					int contador = 0;
					while (entrada != kaprekar) {
						String ascendente = "";
						String descendente = "";
						contador++;
						int vector[] = new int[4];
						for (int i = 0; i < 4; i++)
							// vector[i] = Integer.parseInt(Character.toString(numTxt.charAt(i)));
							// vector[i] = numTxt.charAt(i) - '0';
							vector[i] = numTxt.charAt(i) - 48;
						// vector[i] = Character.getNumericValue(numTxt.charAt(i));
						Arrays.sort(vector);
						for (int i = 0; i < 4; i++) {
							ascendente = ascendente + vector[i];
							descendente = vector[i] + descendente;
						}
						int numDescendente = Integer.parseInt(descendente);
						int numAscendente = Integer.parseInt(ascendente);
						entrada = numDescendente - numAscendente;
						numTxt = Integer.toString(entrada);
						// Si el número resultante tiene menos de cuatro cifras
						for (int i = numTxt.length(); i < 4; i++)
							numTxt = "0" + numTxt;
						System.out.println(descendente + " - " + ascendente + " = " + entrada);
					}
					System.out.println("Constante de kaprekar obtenida con " + contador + " operaciones");
				}
			}
		}
	}
}
