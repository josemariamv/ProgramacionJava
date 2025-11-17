package practicas;

import java.util.Scanner;

public class Kaprekar3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String numTxt = "";
		final int kaprekar = 6174;
		int entrada = validarKaprekar();
		teclado.close();
		System.out.println("Pasos para obtener la constante de kaprekar a partir del número " + entrada);
		int contador = 0;
		while (entrada != kaprekar) {
			contador++;
			int numAscendente = kaprekarAscendente(entrada);
			int numDescendente = kaprekarDescendente(entrada);
			entrada = numDescendente - numAscendente;
			numTxt = Integer.toString(entrada);
			// Si el número resultante tiene menos de cuatro cifras
			for (int i = numTxt.length(); i < 4; i++)
				numTxt = "0" + numTxt;
			System.out.println(numDescendente + " - " + numAscendente + " = " + entrada);
		}
		System.out.println("Constante de kaprekar obtenida con " + contador + " operaciones");
	}
	
	public static int validarKaprekar() {
		int numero = 0;
		
		return numero;
				
	}
	
	public static int kaprekarAscendente(int n) {
		int ascendente = 0;
		
		return ascendente;
	}
	
	public static int kaprekarDescendente(int n) {
		int descendente = 0;
		
		return descendente;
	}
}

