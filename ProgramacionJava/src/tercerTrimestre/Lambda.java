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
		Operacion suma  = (a, b) ->{
			int x = a + b;
			return x;
		};
		Operacion resta = (a, b) -> a - b;
		Operacion mayor = (a, b) -> {
			int m = a;
			if(b>a)
				m = b;
			return m;
		};
		
		Pvp articulo  = (nombre, precio, iva) -> {
			double pvp = (double)Math.round((precio + (precio * iva / 100))*100)/100;
			String texto = "PVP " + nombre + ": " + String.valueOf(pvp) + "€";
			return texto;
		};

		// Invocamos las lambda que hemos creado así:
		System.out.println(suma.ejecutar(5, 3)); 
		System.out.println(resta.ejecutar(5, 3));
		System.out.println(mayor.ejecutar(5, 13));
		
		System.out.println(articulo.calcularPvp("Bollycao", 1.35, 21));
		
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
