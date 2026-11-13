package ejemplos;

import java.util.Arrays;
import java.util.Scanner;

public class Boletin7 {
	public static void main(String[] args) {
		// ejercicio 1. La primitiva
		/*
		int[] primitiva = new int[6];
		int i=0;
		while( i<6) {
			boolean repetido = false;
			int n = ((int)(Math.random()*49)+1);
			for(int j=0; j<6; j++)
				if(primitiva[j] == n)
					repetido = true;
			if(repetido == false) {
				primitiva[i] = n;
				i++;
			}
		}
		Arrays.sort(primitiva);
		String texto = Arrays.toString(primitiva);
		texto = texto.replace("[", "");
		texto = texto.replace("]", "");
		System.out.println(texto);
		*/
		// ejercicio 3 - contar palabras
		/*
		Scanner teclado= new Scanner(System.in);
		System.out.print("Escribe un texto: ");
		String texto = teclado.nextLine();
		teclado.close();
		String[] palabras = texto.split(" ");
		int contador = 0;
		for(int i=0; i<palabras.length;i++)
			if(palabras[i] != "")
				contador++;
		System.out.println("Tu texto tiene " + contador + " palabras");
		*/
		// ejercicio 5. contar repeticiones
		int[] contadores = new int[51];
		int mayor = 0;
		int menor = 100;
		for(int i=0; i<100; i++) {
			int n = ((int)(Math.random()*50)+1);
			contadores[n]++;
			if(n> mayor)
				mayor = n;
			if(n< menor)
				menor = n;
		}
		System.out.println("El mayor es " + mayor + " y el menor es " + menor);
		int[] copia = Arrays.copyOf(contadores, contadores.length);
		Arrays.sort(copia);
		System.out.println("El mayor número de repeticiones es de " + copia[copia.length-1]);
		System.out.println("Corresponde al número o números: ");
		for(int i=1; i<contadores.length; i++)
			if(contadores[i] == copia[copia.length-1])
				System.out.println(i);
	}
}












