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
		/*
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
		*/
		// ejercicios 12 y 13: buscaminas
		//int tamanyo = 5;
		//int minas = 5;
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Tamaño del tablero: ");
		int tamanyo = teclado.nextInt();
		
		boolean correcto = false;
		int minas = 0;
		while(correcto == false) {
			System.out.print("Número de minas: ");
			minas = teclado.nextInt();
			if(minas>tamanyo*tamanyo)
				System.out.println("El número de minas no puede superar el número de posiciones del tablero");
			else
				correcto = true;
		}
		teclado.close();
		
		int [][] tablero = new int[tamanyo][tamanyo];
		
		int mina = 0;
		while(mina < minas) {
			int fila = (int)(Math.random()*tamanyo);
			int columna = (int)(Math.random()*tamanyo);
			if(tablero[fila][columna]!=1) {
				tablero[fila][columna] = 1;
				mina++;
			}
		}
		
		for(int i=0; i<tamanyo; i++) {
			for(int j=0; j <tamanyo; j++)
				System.out.print(" " + tablero[i][j] + " ");
			System.out.println();
		}
		*/
		// ejercicio 21. números narcisistas
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		String numero = teclado.nextLine();
		teclado.close();
		
		int longitud = numero.length();
		int suma = 0;
		for(int i=0; i<longitud; i++)
			suma+=(int)Math.pow(Integer.valueOf(numero.charAt(i)+""),longitud);
		if(suma == Integer.valueOf(numero))
			System.out.println("El número " + numero + " es narcisista");
		else
			System.out.println("El número " + numero + " no es narcisista");
		*/
		// ejercicio 9. LLenar un array y calcular unos datos
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Escribe el tamaño del array: ");
		int numero = teclado.nextInt();
		teclado.close();
		
		int[] vector = new int[numero];
		int maximo = 0;
		int minimo = 2000;
		double suma = 0;
		
		for(int i=0; i<numero;i++) {
			vector[i] = (int)(Math.random()*(1000-10+1)+10);
			suma+=vector[i];
			if(vector[i] > maximo)
				maximo = vector[i];
			if(vector[i] < minimo)
				minimo = vector[i];
		}
		System.out.println("El máximo es: " + maximo);
		System.out.println("El mínimo es: " + minimo);
		System.out.printf("La media aritmética es: %.2f", suma/numero);
		*/
		// ejercicio 6. contar el valor de las cifras de un número
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		String numero = teclado.nextLine();
		teclado.close();
		int[] contadores = new int[10];
		
		for(int i=0; i<numero.length();i++) {
			int n = Integer.valueOf(numero.charAt(i)+"");
			contadores[n]++;
		}
		System.out.println("Tú número tiene: ");
		for(int i=contadores.length-1; i>=0; i--)
			if(contadores[i]!=0)
				if(contadores[i]!=1)
					System.out.println(contadores[i] + " números " + i);
				else
					System.out.println(contadores[i] + " número " + i);
	}
}












