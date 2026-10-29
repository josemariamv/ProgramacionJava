package ejemplos;

import java.util.Scanner;

public class Boletin6 {
	public static void main(String[] args) {
		// ejercicio 1. factorial
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int n = teclado.nextInt();
		teclado.close();
		long resultado = n;
		for(int i=n-1; i>1;i--) {
			resultado = resultado * i;
		}
		System.out.println("El factorial de " + n + " es " + resultado);
		*/
		
		// ejercicio 2. fibonacci
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce cuantos números de la sucesión de fibonacci quieres: ");
		int n = teclado.nextInt();
		teclado.close();
		int f1 = 0;
		int f2 = 1;
		if(n==1)
			System.out.println(f1);
		else if (n==2)
			System.out.println(f1 + ", " + f2);
		else {
			System.out.print(f1 + ", " + f2);
			for(int contador = 3; contador <= n; contador++) {
				int nuevo = f1+f2;
				System.out.print(", " + nuevo);
				f1 = f2;
				f2 = nuevo;
			}
		}
		*/
		
		//ejercicio 3. fibonacci 2
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce hasta que valor de la sucesión de fibonacci quieres ver: ");
		int n = teclado.nextInt();
		teclado.close();
		int f1 = 0;
		int f2 = 1;
		if(n==0)
			System.out.println(f1);
		else if (n==1)
			System.out.println(f1 + ", " + f2 + ", 1");
		else {
			System.out.print(f1 + ", " + f2 + ", 1");
			f1 = 1;
			int nuevo = f1+f2;
			while(nuevo <= n) {
				System.out.print(", " + nuevo);
				f1 = f2;
				f2 = nuevo;
				nuevo = f1+f2;
			}
		}
		*/
		
		// ejercicio 4
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int n = teclado.nextInt();
		teclado.close();
		String numeroConvertido = String.valueOf(n);
		System.out.println("El número " + n + " tiene " + numeroConvertido.length() + " cifras");
		*/
		
		// ejercicio 5
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int n = teclado.nextInt();
		teclado.close();
		String numeroConvertido = String.valueOf(n);
		String cadenaInvertida="";
		for(int i=0; i<numeroConvertido.length();i++) {
			cadenaInvertida = numeroConvertido.charAt(i) + cadenaInvertida;
		}
		int numeroInvertido = Integer.parseInt(cadenaInvertida);
		if(n == numeroInvertido)
			System.out.println(n + " es capicúa");
		else
			System.out.println(n + " no es capicúa");
		*/
		
		//ejercicio 6
		/*
		int contador = 0;
		int numero = 2;
		while(contador <50){
			boolean esPrimo = true;
			int raiz = (int)Math.sqrt(numero)+1;
			for(int divisor = 2; divisor<raiz && esPrimo == true; divisor++) {
				if(numero%divisor == 0)
					esPrimo = false;
			}
			if(esPrimo == true) {
				System.out.println(numero + " - " + Math.sqrt(numero) + " - " + numero*numero + " - " + numero*numero*numero);
				contador++;
			}
			numero++;
		}
		*/
		
		// ejericio 7
		// se ha hecho un pequeño cambio sobre lo que dice el enunciado
		// y se pide el número por teclado a partir del cual se buscan los dos primeros primos gemelos
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número entero positivo y mayor que 1: ");
		int numero = teclado.nextInt();
		teclado.close();
		int original = numero;
		// si es par le sumamos 1 para que sea impar. El 2 no tiene gemelo y no hay ningún otro par que sea primo
		if(numero%2==0)
			numero++;
		int primoAnterior = -1;
		int primoPosterior = -1;
		boolean tengoGemelos = false;
		while (tengoGemelos == false) {
			boolean esPrimo = true;
			int raiz = (int) Math.sqrt(numero) + 1;
			for (int divisor = 2; divisor < raiz && esPrimo == true; divisor++) {
				if (numero % divisor == 0)
					esPrimo = false;
			}
			if (esPrimo == true) {
				if(numero-primoAnterior == 2) {
					tengoGemelos = true;
					primoPosterior = numero;
				}
				else
					primoAnterior = numero;
			}
			numero+=2;
		}
		System.out.println("Los dos primeros gemelos después de 1517 son " + primoAnterior + " y " + primoPosterior);
		*/
		// ejercicio 14
		Scanner teclado = new Scanner(System.in); 
		System.out.print("Introduce una hora: ");
		String hora=teclado.nextLine();
		teclado.close();
		if(hora.length()!=5)
			System.out.println("No es una hora válida");
		else if(hora.charAt(2)!=':')
			System.out.println("No es una hora válida");
		else {
			String numeros = hora.substring(0,2) + hora.substring(3,5);
			boolean correcto = true;
			for(int i=0; i<numeros.length(); i++) {
				int ascii = (int)numeros.charAt(i); 
				if(ascii <48 || ascii > 57)
					correcto = false;
			}
			if(correcto == true) {
				int h = Integer.parseInt(hora.substring(0,2));
				int m = Integer.parseInt(hora.substring(3,5));
				if(h > 23 || m > 60)
					System.out.println("No es una hora válida");
				else {
					String periodo = switch(h) {
						case 6, 7, 8, 9, 10, 11 -> "Mañana";
						case 12, 13, 14, 15, 16, 17, 18, 19 -> "Tarde";
						case 20, 21, 22, 23 -> "Noche";
						default -> "Madrugada";
					};
					System.out.println("Son las " + hora + " de la " + periodo);
				}
			}
			else
				System.out.println("No es una hora válida");
			}
	}
}
