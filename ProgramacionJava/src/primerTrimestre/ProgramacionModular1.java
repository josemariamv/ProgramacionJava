package primerTrimestre;

/* 
 * Dividir un programa en funciones nos ayuda a que la lógica del programa sea mas sencilla, 
 * a que el código pueda reutilizarse mas fácilmente, a no repetir código de forma innecesaria
 * y a que el mantenimiento sea mas fácil
 * A continuación tenemos un ejemplo usando un programa que comprueba si los números
 * que aparecen en una lista son primos o no.
 */

public class ProgramacionModular1 {

	public static void main(String[] args) {

		int[] numeros = { 7, 3, 6, 9, 17, 33, 53 };
		for (int n : numeros) {
			// la invocación a una función hay que hacerla de acuerdo a la forma en la que la hemos definido
			// en este caso nuestra función recibe un entero como argumento y devuelve un booleano
			if(esPrimo2(n) == true)
				System.out.println("El número " + n + " es primo");
			else
				System.out.println("El número " + n + " no es primo");
		}
	}

	// Esta es la definición de la función. Aquí indicamos, además de su nombre, el argumento o argumentos que recibe
	// y el valor que devuelve (o si no devuelve nada poniendo un void)
	public static boolean esPrimo2(int n) {
		boolean esPrimo = true;
		int raiz = (int) Math.sqrt(n) + 1;
		if (n % 2 != 0 || n == 2) {
			for (int i = 3; i < raiz && esPrimo == true; i += 2)
				if (n % i == 0)
					esPrimo = false;
		} else
			esPrimo = false;
		// La palabra reservada return antecede al valor que la función devuelve
		// Es el punto de salida. Una función deber de tener un solo return y, salvo excepciones,
		// ser la última instrucción de la función
		return esPrimo;
	}
}
