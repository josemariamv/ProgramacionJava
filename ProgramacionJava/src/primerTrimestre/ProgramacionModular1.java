package primerTrimestre;

public class ProgramacionModular1 {

	public static void main(String[] args) {

		int[] numeros = { 7, 3, 6, 9, 17, 33, 53 };
		for (int n : numeros) {
			//esPrimo(n);
			if(esPrimo2(n) == true)
				System.out.println("El número " + n + " es primo");
			else
				System.out.println("El número " + n + " no es primo");
		}
	}

	public static void esPrimo(int n) {
		boolean esPrimo = true;
		int raiz = (int) Math.sqrt(n) + 1;
		if (n % 2 != 0) {
			for (int i = 3; i < raiz && esPrimo == true; i += 2)
				if (n % i == 0)
					esPrimo = false;
		} else
			esPrimo = false;
		if(esPrimo == true)
			System.out.println("El número " + n + " es primo");
		else
			System.out.println("El número " + n + " no es primo");
	}
	
	public static boolean esPrimo2(int n) {
		boolean esPrimo = true;
		int raiz = (int) Math.sqrt(n) + 1;
		if (n % 2 != 0) {
			for (int i = 3; i < raiz && esPrimo == true; i += 2)
				if (n % i == 0)
					esPrimo = false;
		} else
			esPrimo = false;
		
		return esPrimo;
	}
}
