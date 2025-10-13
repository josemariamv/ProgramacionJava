package primerTrimestre;

public class CondicionalIf {

	public static void main(String[] args) {
		
		/*
		 * La estructura if condicional nos permite bifurcar
		 * lo que hace nuestro programa en función de una expresión
		 * condicional que ha de poder evaluarse como verdadero (true)
		 * o falso (false)
		 */
		
		boolean encontrado = true;
		if(encontrado == true) {
			System.out.println("Lo hemos encontrado");
		}
		
		// opcionalmente podemos poner un else que se ejecuta
		// si la condición se evalúa como falso

		encontrado = false;
		if(encontrado == true) {
			System.out.println("Lo hemos encontrado");
		}
		else {
			System.out.println("No hemos tenido suerte...");
		}
		
		/*
		 * Debajo del if (o del else, si aparece) tenemos un bloque
		 * de instrucciones delimitado por llaves. Si la condición se evalúa
		 * como true se ejecuta el bloque de instrucciones completo bajo el if
		 * Si se evalúa como false (y existe un else) se ejecuta el bloque de instrucciones
		 * bajo el else
		 * Si un bloque de instrucciones está formado por una única instrucción
		 * las llaves no son necesarias
		 */
		
		if(encontrado == false)
			System.out.println("Seguimos sin encontrarlo");
		
		/*
		 * Un if solo puede tener 0 o 1 else. 
		 * Un else no puede existir sin un if.
		 * Lo que si podemos es encadenar varios if-else uno detras de otro
		 * para evaluar condiciones múltiples
		 */

		int dado = 4;
		if(dado <=2 )
			System.out.println("Has fallado");
		else if(dado <=4)
			System.out.println("Has herido al monstruo");
		else
			System.out.println("Bravo! Lo has matado!");
	
	/*
	 * Un bloque if-else se condidera como una única instrucción.
	 * Por eso el primer else del ejemplo anterior no necesita llaves
	 */
	
	}
}
