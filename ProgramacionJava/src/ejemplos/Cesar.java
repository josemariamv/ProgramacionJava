package boletin7;

import java.util.Arrays;
import java.util.Scanner;

public class Cesar {
	public static void main(String[] args) {
		int clave = 1534;
		String alfa = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		String[] alfabeto = alfa.split("");
		String[] alfabetoCifrado = new String[alfabeto.length];
		if(clave > alfabeto.length)
			clave = clave % alfabeto.length;
		
		for(int i=0; i < alfabeto.length - clave; i++)
			alfabetoCifrado[i+clave] = alfabeto[i];
		int j=0;
		for(int i = alfabeto.length-clave; i< alfabeto.length; i++) {
			alfabetoCifrado[j] = alfabeto[i];
			j++;
		}
		/*
		for(int i=0; i<alfabeto.length; i++)
			System.out.print(alfabeto[i]);
		System.out.println();
		for(int i=0; i<alfabetoCifrado.length; i++)
			System.out.print(alfabetoCifrado[i]);
		System.out.println();
		*/
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el mensaje a enviar: ");
		String mensaje = teclado.nextLine();
		teclado.close();
		mensaje = mensaje.toUpperCase();
		mensaje = mensaje.replace(" ","");
		//System.out.println(mensaje);
		String mensajeCifrado="";
		for(int i=0; i<mensaje.length(); i++) {
			for(int k=0; k<alfabeto.length; k++)
				if(mensaje.charAt(i) == alfabeto[k].charAt(0))
				//if(String.valueOf(mensaje.charAt(i)) == alfabeto[k])
					mensajeCifrado += alfabetoCifrado[k];
		}
		System.out.println("Mensaje cifrado: " + mensajeCifrado);
		
		// Vamos a hacer el descifrado sin tener en cuenta mas que
		// tres variables de arriba para que sea real:
		// mensajeCifrado
		// clave
		// alfabeto
		
		// construcción del alfabeto para descifrar
		clave = alfabeto.length - clave;
		String[] alfabetoDescifrado = new String[alfabeto.length];
		for(int i=0; i < alfabeto.length - clave; i++)
			alfabetoDescifrado[i+clave] = alfabeto[i];
		j=0;
		for(int i = alfabeto.length-clave; i< alfabeto.length; i++) {
			alfabetoDescifrado[j] = alfabeto[i];
			j++;
		}
		
		// descifrado del mensaje
		String mensajeDescifrado="";
		for(int i=0; i<mensajeCifrado.length(); i++) {
			for(int k=0; k<alfabeto.length; k++)
				if(mensajeCifrado.charAt(i) == alfabeto[k].charAt(0))
				//if(String.valueOf(mensaje.charAt(i)) == alfabeto[k])
					mensajeDescifrado += alfabetoDescifrado[k];
		}
		System.out.println("Mensaje cifrado: " + mensajeDescifrado);
	}
}












