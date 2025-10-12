
public class ConversionTipos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Conversión entre tipos de datos */

		String textoEntero = "33";
		String textoDecimales = "33.5";
		int entero = 44;
		double decimales = 44.6;

		// Convertimos de texto a entero
		int num1 = Integer.parseInt(textoEntero);
		System.out.println(num1 + 5);

		// Convertimos de texto a número con decimales
		double num2 = Double.parseDouble(textoDecimales);
		System.out.println(num2 * 1.34);

		// Convertimos de entero a texto
		String texto1 = String.valueOf(entero);
		System.out.println(texto1 + 5);

		// Convertimos de número con decimales a texto
		String texto2 = String.valueOf(decimales);
		System.out.println(texto2 + 123);

		// Convertir de entero a número con decimales es sencillo
		// Se puede castear
		System.out.println((double) entero + 1.5);
		// Pero no es necesario
		System.out.println(entero + 1.5);
		// Y si tenemos que almacenarlo en una variable se asigna directamente
		double num3 = entero;
		System.out.println(num3);
		System.out.println(num3 + 1.5);

		// De double a int si casteo se truncan los decimales
		// No se redondea
		System.out.println((int) decimales);
		System.out.println((int) decimales + 1.5);
		int num4 = (int) decimales;
		System.out.println(num4);

		// Si necesito redondear en la conversión de double a int
		// uso el método round
		System.out.println((Math.round(decimales)));
		System.out.println((Math.round(decimales) + 1.5));
		// Si voy a asignar el resultado a una variable entera (int)
		// hay que castear a entero porque Math.round devuelve un long (un entero largo)
		int num5 = (int) Math.round(decimales);
		System.out.println(num5);

		// Este método de redondeo a entero me proporciona también
		// la forma de redondear con cifras decimales
		final double pi = 3.14159;
		System.out.println("Valor redondeado: " + (double) Math.round(pi * 100) / 100);
		System.out.println("Valor redondeado: " + (double) Math.round(pi * 1000) / 1000);
		System.out.println("Valor redondeado: " + (double) Math.round(pi * 10000) / 10000);

		// Los métodos max y min me devuelven el mayor o el menor de dos números
		int mayor = Math.max(35, 67);
		System.out.println("El mayor es: " + mayor);
		int menor = Math.min(35, 67);
		System.out.println("El menor es: " + menor);

		// Funcionan también con números con decimales y no solo con enteros
		double menorConDecimales = Math.min(35.5, 67);
		System.out.println("El menor es: " + menorConDecimales);
	}

}
