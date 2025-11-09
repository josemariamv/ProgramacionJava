package primerTrimestre;

public class Excepciones {

	public static void main(String[] args) {
		/* La captura de excepciones nos permite controlar situaciones imprevisibles 
		 * en nuestro programa que ocurren en tiempo de ejecución y evitar que nuestro
		 * programa "se rompa" y concluya antes de tiempo 
		 */
		
		/* La captura de excepciones en java consta de un bloque obligatorio 
		 * (try) y dos opcionales (catch y finally) de los cuales al menos
		 * debería de aparece uno de ambos
		 */
		int divisor = (int)(Math.random()*3);
		try {
			// Dentro del bloque try ponemos aquellas instrucciones susceptibles de
			// provocar una excepción. En el momento en que ocurre una excepción se
			// interrumpe la ejecución del resto de instrucciones del bloque try y
			// se salta al bloque catch
			int resultado = (int)(10/divisor);
			System.out.println(resultado);
			
		} catch (Exception e){
			// Dentro del bloque catch ponemos lo que queremos que se ejecute en el
			// caso de que ocurra una excepción en el bloque try. Si en el bloque try
			// no ocurre ninguna excepción el bloque catch no se ejecuta
			System.out.println("Ha ocurrido una excepción");
			// si queremos "recuperar" el error original de la excepción 
			// podemos hacerlo así:
			System.out.println(e.getMessage());	
		}
		// Una vez gestionado el bloque try/catc la ejecución continua su
		// curso haya o no haya ocurrido un error
		System.out.println("Nuestro programa continúa normalmente");
		
		
		divisor = (int)(Math.random()*3);
		try {
			int resultado = (int)(10/divisor);
			System.out.println(resultado);
		} catch (ArithmeticException e){
			// podemos poner mas de un bloque catch poniendo la excepción
			// concreta que se produce. Sólo se ejecutara uno de los 
			// bloques catch y si ninguno coincide con la excepción
			// al final se ejecuta el genérico (Exception e) que siempre
			// debe de ser el último
			System.out.println("Excepción aritmética");	
		} catch (Exception e) {
			// En este caso como no existe otra causa de excepción
			// esta no se ejecutará nunca
			System.out.println("Otra excepción no contemplada");
		} finally {
			// Esto se ejecuta haya o no haya excepción
			System.out.println("Esto se ejecuta en todos los casos");
		}
		
		divisor = (int)(Math.random()*3);
		try {
			int resultado = (int)(10/divisor);
			System.out.println(resultado);
		} finally {
			// En este caso se ejecuta lo que pongamos aquí
			// pero la excepción salta y el programa se interrumpe
			if(divisor == 0)
				System.out.println("No se puede dividir por cero");
		}
	}

}
