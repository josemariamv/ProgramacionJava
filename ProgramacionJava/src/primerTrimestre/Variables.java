package primerTrimestre;

public class Variables {

	public static void main(String[] args) {
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
		long enteroLargo = 1456788876;
		
		// Si me paso del rango que puedo almacenar en la inicialización me dará un error
		// int mePaso= 4444444444;

		// números con decimales. Java prefiere double
		// pero a veces hay que usar float
		// Los double tienen una mayor precisión
		double sueldoMensual = 2400.55;
		// Cuando usamos un float tenemos que usar un cast o terminar el número con la letra f
		// Esto es debido a que Java considera por defecto que nu número decimal siempre es un double
		float precio = (float) 44.5;
		float otroPrecio = 44.5f;
		// Los decimales, se separan con un punto (sistema anglosajón)
		// Si usas la coma te dará un error

		// Caracteres. Siempre con comillas simples
		char caracter = 'X';

		// Cadenas de texto. Con comillas dobles
		String nombreCompleto = "José María Morales Vázquez";

		// variables booleanas. Sólo pueden valer true o false
		boolean encontrado = true;

		// Cuando usamos la palabra final delante de cualquier tipo
		// de variable se convierte en constante
		// Una constante, como su nombre indica, no puede modificarse
		final int mesesAnno = 12;

		// Otros tipos de datos (con muy poco uso) son: byte y short
		byte octeto;
		short enteroCorto;

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
		double resultado = Math.sqrt(565);

		/*
		 * IMPORTANTE: Las variables siempre hay que declararlas antes de usarlas, el
		 * tipo elegido ha de ser el correcto y no pueden redeclararse ni modificar su
		 * tipo
		 */
		
		// Si tratamos de usar una variable que no ha sido inicializada nos dará un error:
		int sueldo;
		// int sueldoExtra = sueldo * 2;
		// System.out.println(sueldo);
		
		// A continuación tienes una tabla con los tipos de variables, su rango aproximado y lo que ocupan:
		/*
		 * 		variable	espacio que ocupa	rango válido
		 * 		==========	==================	==================
		 * 		byte		1 byte				-128 y 127
		 * 		short		2 bytes				-32768 y 32767
		 * 		int			4 bytes				-2147483648 y 2147483647 
		 * 		long		8 bytes				aproximadamente entre -9 y 9 trillones
		 * 		float		4 bytes				valores con 7 dígitos decimales correctos
		 * 		double		8 bytes				valores con 15 dígitos decimales correctos
		 * 		char		2 bytes				cualquier caracter
		 * 		String		variable			Cada caracter común ocupan 1byte. Los caracteres complejos ocupan 2 bytes. El string ocupa lo que el total de los caracteres que la componen 
		 */
		
		// Si tienes dudas puedes decirle a Java que te muestre cuales son estos rangos
		// Por ejemplo:
		System.out.println(Integer.MIN_VALUE); // Muestra el mínimo de un int
		System.out.println(Integer.MAX_VALUE); // Muestra el máximo de un int
		System.out.println(Double.MAX_VALUE);  // Muestra el máximo de un double
		
	}

}
