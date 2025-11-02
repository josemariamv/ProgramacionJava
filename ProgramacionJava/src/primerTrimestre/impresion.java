package primerTrimestre;

public class impresion {

	public static void main(String[] args) {
		// Ya hemos visto print y println. La diferencia entre ambas
		// es que en una se salta de línea al final y en la otra no
		
		System.out.println("Esto va en una línea");
		System.out.println("Y esto en otra");
		
		System.out.print("Esto va en una línea");
		System.out.print("  y esto en la misma que la anterior");
		
		// Cuando queremos forzar un salto de línea en cualquier sitio
		// de la cadena que estamos imprimiendo ponemos \n
		
		System.out.println("\n\nResultados:\nBetis-Madrid: 1\nBarcelona: Atlético de Madrid: 2");
		
		// También hemos visto como dar en consola una salida en color rojo para indicar un error
		System.err.println("Esto es un error");
		System.err.print("Y esto también");
		
		// Existe una tercera instrucción que nos permite escribir con formato
		// y se llama printf
		
		int numero = 45;
		System.out.printf("%nEl número es %d\n", numero);
		double precio = 123.44;
		String codigo = "A23-Z";
		System.out.printf("El precio es %f y la referencia, %s%n", precio, codigo);
		String nombre="José María";
		System.out.printf("Tu nombre empieza por %c%n", nombre.charAt(0));
		
		// %d indica que vamos a meter un enter, %f un número con decimales y %s un String
		// Con %c indicamos un char
		// printf no salta de línea al final. Podemos indicar los saltos de línea con \n o con %n
		// Pero es mas recomendable hacerlo con %n
		
		// %S convierte la cadena a mayúsculas
		
		System.out.printf("Con mayúsculas: %S%n", nombre);
		
		// Podemos indicar el número de decimales que queremos. Redondea, no trunca
		double pi = 3.14159;
		System.out.printf("El valor de pi con tres decimales es %.3f%n", pi);
		
		// Tambien podemos indicar lo que va a ocupar el número y formatea alineando a la derecha
		System.out.printf("%5d%n%5d%n%5d%n", 325, 2, 1234);
		
		// O a la izquierda
		System.out.printf("%-5d €%n%-5d €%n%-5d €%n", 25, 2, 334);
		
		// Llenando con ceros a la izquierda
		System.out.printf("%05d%n%05d%n%05d%n", 325, 2, 1234);
		
		// uniendo lo anterior con decimales para que quede todo perfectamente alineado
		// fíjate que el primer número es el total que ocupa la cifra y la coma decimal cuenta como una
		// si no le indicas suficiente espacio como para mostrar el número completo no quedará bien
		System.out.printf("%7.2f%n%7.2f%n%7.2f%n", 325.3, 2.0, 1234.45);
		
		// Si indicamos un signo + nos muestra los números con signo tambień si son positivos
		System.out.printf("%+d y %+d%n", -3, 55);
		
		// Y si ponemos un paréntesis los números negativos aparecen entre paréntesis
		System.out.printf("%(d y %(d%n", -3, 55);
		
		// printf también se puede mostrar como error
		System.err.printf("El valor de pi con tres decimales es %.3f%n", pi);
	}

}
