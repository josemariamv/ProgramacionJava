
public class Variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Los nombre de las variables (y todo en general en Java) son sensibles a
		 * mayúsculas y minúsculas. Edad no es lo mismo que edad o que EDAD
		 * 
		 * Los nombres de variables pueden contener letras o números pero solo pueden
		 * empezar por letras o los símbolos _ o $
		 * 
		 * Usaremos lowerCamelCase para los nombres de variables y UpperCamelCase para
		 * los nombres de las clases ver: https://es.wikipedia.org/wiki/Camel_case
		 */

		// números enteros
		int edad = 56;

		// números con decimales. Java prefiere double
		// pero a veces hay que usar float
		// Los double tienen una mayor precisión
		double sueldoMensual = 2400.55;
		float precio = (float) 44.5;

		// Caracteres. Siempre con comillas simples
		char caracter = 'X';

		// Cadenas de texto. Con comillas dobles
		String nombreCompleto = "José María Morales Vázquez";

		// variables booleanas. Sólo pueden valer true o false
		boolean encontrado = true;

		// Cuando usamos la palabra final delante de cualquier tipo
		// de variable se convierte en constante y no puede modificarse
		final int mesesAnno = 12;

		// Otros tipos de datos (con muy poco uso) son: byte, short y long
		byte octeto;
		short enteroCorto;
		long enteroLargo;

		// La asignación siempre se hace de derecha a izquierda
		// nunca al revés

		// Los siguientes ejemplos son válidos para cualquier
		// tipo de variable aunque se escenifiquen con enteros
		int contador; // Puedo definir una variable sin inicializar
		int meses = 12; // o inicializándola

		// También puedo definir varias variables en la misma línea
		// inicializándolas o no, siempre que sean del mismo tipo.
		// Se separan por comas
		int semanas = 4, dias = 7;
		int x, y = 3, z, n;

		// También puedo inicializar una variable
		// mediante una expresión aritmética
		int horasEnero = 31 * 24;

		// o a través de una función
		int resultado = Integer.parseInt("565");

		/*
		 * IMPORTANTE: Las variables siempre hay que declararlas antes de usarlas, el
		 * tipo elegido ha de ser el correcto y no pueden redeclararse ni modificar su
		 * tipo
		 */
	}

}
