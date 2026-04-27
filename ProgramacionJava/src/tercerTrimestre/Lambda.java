package tercerTrimestre;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda {
	// Una función lambda es una función anónima (sin nombre) que puede ser tratada
	// como un objeto

	public static void main(String[] args) {
		// Definimos dos funciones lambda a partir de la interface Operacion
		// ambas reciben dos int y devuelven otro
		// pero lo que hacen es diferente
		Operacion suma  = (a, b) -> a + b;
		Operacion resta = (a, b) -> a - b;

		// Invocamos las lambda que hemos creado así:
		System.out.println(suma.ejecutar(5, 3)); 
		System.out.println(resta.ejecutar(5, 3));
		
		// Java define un conjunto de interfaces funcionales genéricas para poder
		// usarlas como funciones lambda
		
		// Runnable se ejecuta sin recibir parámetros y sin devolver nada
		// su metodo es run
		Runnable hola = () -> System.out.println("Hola mundo");
		hola.run();
		
		// Consumer para mostrar mensajes con formato fijo
		// No devuelve nada. Su método es accept
		Consumer<String> verString = (s) -> System.out.println(">> " + s);
		verString.accept("Hola mundo!"); 
		
		Consumer<Integer> verInteger = (n) -> System.out.println("***" + n + "***");
		verInteger.accept(67); 
		
		// Supplier. Similar a Consumer
		// No recibe nada. Devuelve un valor
		// su método es get. 
		Supplier<String> saludo = () -> "Hola mundo";
		System.out.println(saludo.get());
		
		Supplier<Double> pi = () -> 3.14159;
		System.out.println(pi.get());
		
		// Existen otras muy populares pero no vamos a verlas: Predicate, Function, BiFunction, Comparator, etc.
	}
}
