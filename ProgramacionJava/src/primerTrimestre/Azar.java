package primerTrimestre;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Azar {

	public static void main(String[] args) {
		/* Generación de números aleatorios */
		
		/* Vamos a ver cuatro métodos, de mas simple a mas complejo */

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

		// Segundo método usando la clase Random
		// Precisa importarla antes
		Random rand = new Random();
		//o
		//Random rand = new Random(123456); 
		// El número que ponemos entre paréntesis es la semilla
		// Los números que genera un ordenador son, casi siempre, pseudoaleatorios
		// el verdadero azar es muy dificil. Los generadores de números aleatorios usan como base una semilla
		// Con la misma semilla, los números generados son siempre los mismos, por lo que no son realmente aleatorios.
		// Si no ponemos semilla se toma la hora actual en nanosegundos. El método anterior no permite fijar otra semilla
		System.out.println(rand.nextInt(2)); // genera un número entre 0 y 1
		inicio = 1;
		fin = 6;
		dado = rand.nextInt(fin - inicio + 1) + 1; // genera un número entre 1 y 6
		System.out.println("Tirada de dado de 6 caras: " + dado);
		// tenemos generación de long, double, float, etc.
		System.out.println(rand.nextBoolean()); // true o false
		// y podemos reiniciar la semila o poner otra cuando queramos
		rand.setSeed(3771243956678145L); // ponemos L cuando es un long igual que poníamos f para indicar que es un float
		dado = rand.nextInt(fin - inicio + 1) + 1;
		System.out.println("Tirada de dado de 6 caras: " + dado);
		
		// tercer método
		// queda mas clara la horquilla entre la que generará los números
		// también es mas eficiente cuando tenemos que generar muchos números aleatorios en entornos concurrentes
		// tampoco podemos inicializar la semilla.
		// aquí no creamos ningún objeto: llamamos directamente a la función que genera el número como en el primer caso
		dado = ThreadLocalRandom.current().nextInt(inicio, fin + 1);
        System.out.println("Número entre 1 y 6: " + dado);
        // también podemos generar diferentes tipos de datos
        System.out.println(ThreadLocalRandom.current().nextFloat(2,3));
        
        // el cuarto método es el único totalmente seguro para aplicaciones que requieran seguridad extrema
        SecureRandom secureRandom = new SecureRandom();
        // Podemos forzar una semilla (o no)
        // pero en este caso la semilla complementa a la que el genera de forma automática
        // por lo que los números generados con la misma semilla no son los mismos nunca
        secureRandom.setSeed(987654321L);
        // o
        secureRandom.setSeed(123456);

        // Generar un PIN de seguridad de 6 dígitos (entre 100000 y 999999)
        // el primero nunca puede ser un cero, pero bueno...
        // también genera diferentes tipos de datos y no solo double o int
        int tokenSeguro = secureRandom.nextInt(900000) + 100000;
        System.out.println("Token criptográficamente seguro: " + tokenSeguro);
        
        // también podemos generar diferentes tipos de datos:
        System.out.println(secureRandom.nextLong());
        

	}

}
