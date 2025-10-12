package ejemplos;

public class Primos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Versión 1. A lo bestia */
		/*
		 * boolean esPrimo; int azar; do { azar = (int) (Math.random() * 400000000 + 1)
		 * + 100000000; esPrimo = true; System.out.println("Probando el número " +
		 * azar); for (int i = 2; i < azar; i++) if (azar % i == 0) esPrimo = false; }
		 * while (esPrimo == false); System.out.println("El número " + azar +
		 * " es primo");
		 */

		/* Versión 2. Con un poquito de cabeza */
		/*
		 * boolean esPrimo; int azar; do { azar = (int) (Math.random() * 400000000 + 1)
		 * + 100000000; esPrimo = true; System.out.println("Probando el número " +
		 * azar); if(azar%2 !=0) { for (int i = 3; i < azar; i+=2) if (azar % i == 0)
		 * esPrimo = false; } else esPrimo = false; } while (esPrimo == false);
		 * System.out.println("El número " + azar + " es primo");
		 */
		/* Version 3. Usando algorítmica */

		boolean esPrimo;
		int azar;
		do {
			azar = (int) (Math.random() * 400000000 + 1) + 100000000;
			int raiz = (int) Math.sqrt(azar) + 1;
			esPrimo = true;
			System.out.println("Probando el número " + azar);
			if (azar % 2 != 0) {
				for (int i = 3; i < raiz && esPrimo == true; i += 2)
					if (azar % i == 0)
						esPrimo = false;
			} else
				esPrimo = false;
		} while (esPrimo == false);
		System.out.println("El número " + azar + " es primo");
	}

}
