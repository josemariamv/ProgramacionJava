
public class OperadoresAritmeticos {
	public static void main(String[] args) {
		// El operador de asignación es el signo = y se usa tanto en
		// inicialización de variables como al actualizar el contenido de
		// las mismas
		int edad = 56;

		// Los operadores aritméticos son:
		edad = 56 + 1; // suma
		edad = 56 - 1; // resta
		edad = 26 * 2; // producto
		edad = 112 / 2; // división
		// El operador % nos devuelve el resto de la división entera
		int resto = 101 / 2; // resto valdrá 1

		// Los operadores de autoincremento y autodecremento
		// son ++ y -- respectivamente
		int x = 5;
		x++; // Después de esto x vale 6
		x--; // Y ahora vuelve a vale 5

		// Cuidado con estos operadores:
		int prueba = 3;
		// Aquí se muestra 4 y prueba pasa a valer 4
		System.out.println(++prueba);

		int prueba2 = 3;
		// Aquí se muestra 3 pero prueba2 pasa a valer 4
		System.out.println(prueba2++);

		// La prioridad en las operaciones complejas es como en mates,
		// pero por seguridad y comodidad se pueden usar paréntesis.
		// Y pueden combinarse valores y variables
		// en cualquier orden que nos convenga

		int resultado = ((x + prueba) / prueba2) * edad;

		// La asignación es siempre lo último en realizarse. Y siempre
		// asignamos hacía la izquierda
		// Por eso podemos hacer operaciones como esta:

		// primero se suma 1 al valor de edad y luego se actualiza
		// el valor de edad
		edad = edad - 1;

		// Las operaciones como la anterior en las que se involucra
		// la misma variable a derecha y a izquierda del signo igual pueden
		// simplificarse así:

		edad += 1; // Es igual que edad = edad + 1

		// Existen los operadores -=, *=, /= y %=
		// que hacen lo mismo con estas otras operaciones

		// El operador + está "sobrecargado" y se puede usar con textos
		// El resultado es que las concatena
		String texto = "Hola" + " " + "mundo";
		System.out.println(texto); // Mostrará Hola mundo

		// Podemos combinar Textos y números para dar una salida compuesta
		System.out.println("Mi edad es " + edad + " años");
	}
}
