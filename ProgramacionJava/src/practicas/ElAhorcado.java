package practicas;

import java.util.Scanner;

public class ElAhorcado {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine();
		System.out.print("Letra a mantener: ");
		String letra = teclado.nextLine();
		
		String fraseAhorcado = "";
		for(int i=0; i<frase.length(); i++)
			if(frase.charAt(i) == letra.charAt(0) || frase.charAt(i) == ' ' )
				fraseAhorcado += frase.charAt(i);
			else
				fraseAhorcado += "*";
		System.out.println("Resultado: " + fraseAhorcado);
		
		// Hasta aquí la primera parte del ejercicio
		
		int contadorIntentos = 0;
		boolean fraseCompleta = false;
		while(fraseCompleta == false) {
			int contadorLetra = 0;
			String fraseTemporal = "";
			System.out.print("Introduce una letra: ");
			letra = teclado.nextLine();
			contadorIntentos++;
			for(int i=0; i<frase.length(); i++)
				if(frase.charAt(i) == letra.charAt(0)) {
					contadorLetra++;
					fraseTemporal += letra.charAt(0);
				}
				else
					fraseTemporal += fraseAhorcado.charAt(i);
			System.out.println("La letra " + letra + " aparece en " + contadorLetra + " ocasiones");
			System.out.println("Resultado: " + fraseTemporal);
			fraseAhorcado = fraseTemporal;
			if(fraseAhorcado.equals(frase))
				fraseCompleta = true;
		}
		teclado.close();
		System.out.println("Haz ganado. Has necesitado " + contadorIntentos + " intentos para completar la frase");
	}
}
