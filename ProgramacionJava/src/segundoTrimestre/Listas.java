package segundoTrimestre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Listas {
	/*
	 * Las colecciones de Java más útiles y utilizadas se encuentran dentro del Java
	 * Collections Framework (JCF). Se clasifican principalmente por las interfaces
	 * que implementan, siendo las más comunes: List, Set, y Map Serían las
	 * equivalentes a Listas, Conjuntos y Diccionarios de Python Cada una de las
	 * tres tiene múltiples implementaciones. Veremos las mas populares
	 */
	public static void main(String[] args) {
		/*
		 * ArrayList es como un array normal pero dinámico. No me hace falta definir el
		 * tamaño que tendrá en su creación. Aumenta de tamaño fácilmente cada vez que
		 * añado elementos
		 */
		ArrayList<String> textos = new ArrayList<>();
		ArrayList<Integer> numeros = new ArrayList<>();
		ArrayList<Double> notas = new ArrayList<>(List.of(1.5, 3.33, 7.5));

		// Las listas son similares a los ArrayList pero son inmutables (como las tuplas
		// de python)
		// No vamos a verlas mas allá de saber como se crea una. Así:
		List<Double> tupla = List.of(1.5, 2.5, 3.5);

		// add añade un elemento al final
		numeros.add(75);
		numeros.add(175);
		numeros.add(75);
		numeros.add(15);

		textos.add("Hola mundo cruel");
		textos.add("Adios, me despido de la vida");

		notas.add(6.5);

		// esto no puede hacerse. Ya hemos dicho que son inmutables!
		// tupla.add(3.3)

		// o en la posición indicada
		textos.add(1, "Intermedio para publicidad");
		numeros.add(0, 15);

		// teniendo cuidado de no pasarnos"
		// textos.add(5,"La otra vida...");

		System.out.println(textos);
		System.out.println(numeros);
		System.out.println(notas);
		System.out.println(tupla);

		// size devuelve el número de elementos
		System.out.println("Tamaño del ArrayList: " + textos.size());

		// Devuelve el elemento que esta en la posición '2' del ArrayList
		System.out.println(textos.get(2));

		// Si me paso casca
		// System.out.println(textos.get(3));

		// Comprueba se existe el elemento ('Elemento') que se le pasa como parametro
		if (numeros.contains(175))
			System.out.println("El elemento está en el arraylist");

		// Devuelve la posición de la primera ocurrencia ('Elemento') en el ArrayList
		System.out.println(numeros.indexOf(75));

		// Devuelve la posición de la última ocurrencia ('Elemento') en el ArrayList
		System.out.println(numeros.lastIndexOf(75));

		// Borra el elemento de la posición '1' del ArrayList
		numeros.remove(1);
		System.out.println(numeros);

		// Casca si la posición 10 no existe
		// numeros.remove(10);

		// Borra la primera ocurrencia del elemento que se le pasa como parametro.
		notas.remove(3.33);
		// En el caso de un arraylist de enteros hay que ponerle el cast si no intentará
		// borrar el elemento en la posición 15
		numeros.remove((Integer) 15);
		System.out.println(notas);
		System.out.println(numeros);

		// en este caso devuelve false si el elemento no existe
		if (textos.remove("Hola") == false)
			System.out.println("No puedo borrar un elemento que no existe");

		// Borra todos los elementos de ArrayList
		numeros.clear();

		// Devuelve True si el ArrayList esta vacio. Sino Devuelve False
		if (numeros.isEmpty())
			System.out.println("El arraylist está vacío");

		// Copiar un ArrayList
		ArrayList textos2 = (ArrayList) textos.clone();
		System.out.println(textos);
		System.out.println(textos2);

		// Para recorrer un ArrayList de forma clásica:
		for(int i=0; i<textos.size();i++)
			System.out.println(textos.get(i));
		
		// O así:
		for(String txt:textos)
			System.out.println(txt);
		
		// También podemos usar un Iterator
		Iterator<String> iterador = textos.iterator();
		
		// hasNext devuelve false cuando ya no haya mas elementos en el ArrayList
		while (iterador.hasNext()) {
			// next nos devuelve un elemento del ArrayList secuencialmente, empezando por el
			// primero
			String elemento = iterador.next();
			System.out.println(elemento);
		}
		
		// Los iterators son la única forma segura de elminiar un elemento de una colección
		// dentro del bucle, pero para hacerlo usamos el método remove del iterator y no el de la colección
		// iterador.remove() 
		// La linea anterior borra el elemento actual que esté recorriendo el iterator

		// Por supuesto que podemos usar ArrayList e Iterators con nuestros propios
		// objetos. ¿Lo intentamos en el problema de la lista de Tareas?
		
		// Convertir un array en un ArrayList	
		String[] frutas = {"Manzana", "Pera", "Platano"};
		ArrayList<String> otrasFrutas = new ArrayList<>(Arrays.asList(frutas));
		
		System.out.println(otrasFrutas);
		
		// Un array de enteros no es tan sencillo ya que no coinciden los tipos Int-Integer
		// Lo mas fácil es hacerlo con un bucle y haciendo adds
		// Este método es sencillo y funciona con cualquier tipo de dato (con el anterior también)
		int[] arrayNumeros = {1,23,5,7,9};
		ArrayList<Integer> listaNumeros = new ArrayList<>();
		for(int n:arrayNumeros)
			listaNumeros.add(n);
		System.out.println(listaNumeros);
		
		// Convertir ArrayList en Array
		ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Pepe", "Juan", "Eva", "Ana"));
		String[] nombresArray = nombres.toArray(new String[0]);
		for (String n: nombresArray)
			System.out.print(n + " - ");
		
		System.out.println("---");

		// Uno de enteros ahora
		ArrayList<Integer> masNumeros = new ArrayList<>(List.of(5, 7, 14, 56, 8));
		int masNumeros2[] = new int[masNumeros.size()];
		
		int j=0;
		for(int n:masNumeros) {
			masNumeros2[j] = n;
			j++;
		}
		for (int n: masNumeros2)
			System.out.print(n + " - ");

	}
}
