package ejemplos;

import java.util.Arrays;
import java.util.Scanner;

public class Cesar {
	public static void main(String[] args) {
		int clave = 1534;
		String alfa = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		// construimos un array a partir del string anterior
		String[] alfabeto = alfa.split("");
		String[] alfabetoCifrado = new String[alfabeto.length];
		// si la clave es mas grande que el alfabeto la transformamos
		if(clave > alfabeto.length)
			clave = clave % alfabeto.length;
		// construimos el alfabeto de cifrado
		for(int i=0; i < alfabeto.length - clave; i++)
			alfabetoCifrado[i+clave] = alfabeto[i];
		int j=0;
		for(int i = alfabeto.length-clave; i< alfabeto.length; i++) {
			alfabetoCifrado[j] = alfabeto[i];
			j++;
		}
		/*
		// mostramos por consola los dos alfabetos para comprobar que están ok
		for(int i=0; i<alfabeto.length; i++)
			System.out.print(alfabeto[i]);
		System.out.println();
		for(int i=0; i<alfabetoCifrado.length; i++)
			System.out.print(alfabetoCifrado[i]);
		System.out.println();
		*/
		// pedimos el mensaje a cifrar
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el mensaje a enviar. No uses acentos : ");
		String mensaje = teclado.nextLine();
		teclado.close();
		// lo convertimos a mayúsculas y eliminamos los espacios
		mensaje = mensaje.toUpperCase();
		mensaje = mensaje.replace(" ","");
		// Y ahora ciframos el mensaje
		String mensajeCifrado="";
		for(int i=0; i<mensaje.length(); i++) {
			for(int k=0; k<alfabeto.length; k++)
				// Dos métodos diferentes de comparar un char con un string
				// convirtiendo uno u otro 
				if(mensaje.charAt(i) == alfabeto[k].charAt(0))
				//if(String.valueOf(mensaje.charAt(i)) == alfabeto[k])
					mensajeCifrado += alfabetoCifrado[k];
		}
		// mostramos el resultado
		System.out.println("Mensaje cifrado: " + mensajeCifrado);
		
		// Vamos a hacer el descifrado sin tener en cuenta mas que
		// tres variables de arriba para que sea real:
		// mensajeCifrado
		// clave
		// alfabeto
		// Básicamente tomamos dos de las piezas de arriba y las retocamos un poco
		
		// construcción del alfabeto para descifrar
		// la clave que usaremos será la longitud menos la clave de cifrado
		// eso sería equivalente a hacer un desplazamiento negativo de -clave
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












