package ejemplos;

import java.util.concurrent.ThreadLocalRandom;

public class Boletin3 {
	public static void main(String[] args) {
		// Algunos ejercicios del boletín 3
		
		// La quiniela
		/*
		 * for (int i = 0; i < 14; i++) { 
		 * 	int partido = (int) (Math.random() * 3) + 1;
		 * 	if (partido == 3) 
		 * 		System.out.println("  X"); 
		 * 	else if (partido == 2)
		 * 		System.out.println("    2"); 
		 * 	else 
		 * 		System.out.println("1"); }
		 */
		
		// La quiniela con mas probabilidades de que salga un 1 y una X
		/*
		 * for (int i = 0; i < 14; i++) { 
		 * 	int partido = (int) (Math.random() * 7) + 1;
		 * 	if (partido == 5 || partido == 6) 
		 * 		System.out.println("  X"); 
		 * 	else if (partido == 7)
		 * 		System.out.println("    2"); 
		 * 	else 
		 * 		System.out.println("1"); }
		 */

		// Días restantes para el apocalipsis
		/*
		 * int apocalipsis = 0;
		 * int dias = 0;
		 * do{
		 * 	apocalipsis = (int) (Math.random() * 1000) + 1; 
		 * 	System.out.println(apocalipsis);
		 * 	dias++; 
		 * 	}while (apocalipsis != 666); 
		 *	System.out.println("Faltan " + dias + " días para el apocalipsis");
		 */

		// Divisores de un número
		/*
		 * Scanner teclado = new Scanner(System.in);
		 * System.out.print("Escribe un número y te diré los divisores que tiene: ");
		 * int numero = teclado.nextInt();
		 * for(int divisor = 1; divisor<=numero; divisor++) {
		 * 	if(numero%divisor == 0)
		 * 		System.out.println(divisor);
		 * }
		 */
		
		// Ver si un número es primo. Primera versión
		/*
		 * Scanner teclado = new Scanner(System.in);
		 * System.out.print("Escribe un número y te diré si es primo: ");
		 * int numero = teclado.nextInt();
		 * int contador = 0;
		 * for(int divisor = 1; divisor<=numero; divisor++) {
		 * 	if(numero%divisor == 0)
		 * 		contador++;
		 * 	}
		 * if(contador == 2)
		 * 	System.out.println(numero + " es primo"); 
		 * else
		 * 	System.out.println(numero + " no es primo");
		 */
		
		// Ver si un número es primo. Segunda versión
		/*
		 * Scanner teclado = new Scanner(System.in);
		 * System.out.print("Escribe un número y te diré si es primo: ");
		 * int numero = teclado.nextInt();
		 * int contador = 0;
		 * for(int divisor = 2; divisor<numero; divisor++) {
		 * 	if(numero%divisor == 0) 
		 * 		contador++; 
		 * 	}
		 * if(contador == 0 && numero!=1)
		 * 	System.out.println(numero + " es primo");
		 * else
		 * 	System.out.println(numero + " no es primo");
		 */
		
		// Ver si un número muy grande calculado aleatoriamente es primo.
		// Versión definitiva y optima para calcular si un número es primo
		/*
		 * int contador, numero;
		 * do {
		 * 	numero = ThreadLocalRandom.current().nextInt(100000000,200000000+1);
		 * 	contador = 0; 
		 * 	int raiz = (int)Math.sqrt(numero)+1;
		 * 	for(int divisor = 2; divisor<raiz && contador == 0; divisor++)
		 * 		if(numero%divisor == 0) 
		 * 			contador++; 
		 * 	}while(contador!=0);
		 * 	System.out.println("El número " + numero + " es primo");
		 */
		
		// Versión del anterior usando números aún mas grandes (long)
		int contador;
		long numero;
		do {
			numero = ThreadLocalRandom.current().nextLong(10000000000L,30000000000L+1);
			contador = 0;
			int raiz = (int) Math.sqrt(numero) + 1;
			for (long divisor = 2; divisor < raiz && contador == 0; divisor++)
				if (numero % divisor == 0)
					contador++;
			} while (contador != 0);
		System.out.println("El número " + numero + " es primo");
	}
}
