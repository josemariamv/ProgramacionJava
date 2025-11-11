package primerTrimestre;

import java.util.Scanner;

public class Excepciones2 {

	// Podemos crear nuestras propias excepciones con throws
	// En el nombre de la función (main en este caso) incluimos esto:
	public static void main(String[] args) throws Exception {
		// ya veremos que podemos hacerlo en cualquier otra función
		// cuando aprendamos a crearlas
		Scanner teclado = new Scanner(System.in);
		System.out.print("Escribe una línea. No puede estar vacía: ");
		String texto = teclado.nextLine();
		teclado.close();
		
		if(texto.equals(""))
			// cuando queramos hacer saltar la excepción 
			// escribimos algo así:
			throw new Exception("La cadena no puede estar vacía");
		else
			System.out.println("Cadena correcta");

		// También podemos hacer saltar una excepcíon concreta
		// en cualquier momento, pero cuidado con usar esto
		// de forma confusa
		throw new ArithmeticException("No se puede dividir por cero");
		
		// Mas adelante aprenderemos retomaremos este tema
		// y aprenderemos a crear nuestras propias excepciones
	}

}
