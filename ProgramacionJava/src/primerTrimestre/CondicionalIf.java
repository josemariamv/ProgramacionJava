package primerTrimestre;

public class CondicionalIf {

	public static void main(String[] args) {
		
		// Operadores relacionales y lógicos: <, >, >=, <=, ==, !=, !, |, &&
		// Una expresión con estos operadores devuelve un valor boolean
		int edad = 20;
		boolean mayorDeEdad = edad >= 18;
		System.out.println(mayorDeEdad);   // true
		
		// Predice la salida:
		System.out.println(5 > 3 && 2 > 4);
		System.out.println(5 > 3 || 2 > 4);
		System.out.println(!(5 > 3 || 2 > 4));
		System.out.println(!(7 == 7) || 3 != 4);
		System.out.println(10 % 2 == 0);
		System.out.println(edad >= 18 && edad < 65);
		
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
		
		// o lo que es lo mismo
		if(encontrado) {
			System.out.println("Lo hemos encontrado");
		}
		
		// Las llaves delimitan un bloque de instrucciones. Son obligatorias cuando hay dos o mas instrucciones
		// en el bloque. Cuando hay solo una se puede prescindir de ellas
		if(encontrado)
			System.out.println("Lo hemos encontrado");
		
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
		 * Recuerda que si un bloque de instrucciones está formado por una única instrucción
		 * las llaves no son necesarias
		 */
				
		/*
		 * Un if solo puede tener 0 o 1 else. 
		 * Un else no puede existir sin un if.
		 * Lo que si podemos es encadenar varios if-else uno detras de otro
		 * para evaluar condiciones múltiples
		 * tantas veces como queremos o necesitemos
		 */

		int dado = 4;
		if(dado <=2 )
			System.out.println("Has fallado");
		else if(dado <=4)
			System.out.println("Has herido al monstruo");
		else if (dado==5)
			System.out.println("Bravo! Le has acertado!");
		else
			System.out.println("Daño crítico!");
		
		// Errores típicos
		// No usar correctamente && y || o no usarlos para encadenar condiciones 10 < x < 20 no funciona aquí. Sería 10 < x && x < 20
		// poner punto y coma después del paréntesis de la condición. Nunca!
		// no poner paréntesis en la condición. Esto no es python!
		// omitir las llaves en un bloque cuando hay mas de una instrucción
		// usar = en lugar de == para comparar dos datos iguales
		// comparar doubles con == Recuerda la imprecisión de sus últimas cifras decimales. Si no son exactamente iguales no devuelve true
		// Tampoco se pueden comparar textos con == pero eso ya lo veremos mas adelante... 
	
	}
}
