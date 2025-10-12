import java.util.Random;

public class Azar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Generación de números aleatorios */

		// Genera un número aleatorio entre el 0 y el 1.
		// En realidad el 1 no está incluido. El máximo que genera es el
		// 0,99999999999999999 con la máxima precisión que puede
		double azar = Math.random();
		System.out.println("Número aleatorio entre 0 y 1: " + azar);

		// Para generar un número aleatorio entre el 1 y el 6, por ejemplo, hacemos
		// esto:
		int dado = (int) (Math.random() * 6) + 1;
		System.out.println("Tirada de dado de 6 caras: " + dado);

		// De forma genérica, para generar un número aleatorio entre dos extremos
		// ambos incluidos, lo hacemos así:
		int inicio = 2;
		int fin = 4;
		int aleatorio = (int) (Math.random() * (fin - inicio + 1) + inicio);
		System.out.println("Número aleatorio entre " + inicio + " y " + fin + ": " + aleatorio);

		// Existe otro método usando la clase Random
		Random rand = new Random();
		inicio = 1;
		fin = 6;
		dado = rand.nextInt(fin - inicio + 1) + 1;
		System.out.println("Tirada de dado de 6 caras: " + dado);
		// Pero si te das cuenta no ganas mucho (aún tienes que hacer la misma operación
		// que antes
		// Y encima necesitas un import y crear un objeto nuevo
	}

}
