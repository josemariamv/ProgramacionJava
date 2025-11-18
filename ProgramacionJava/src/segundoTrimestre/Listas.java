package segundoTrimestre;

import java.util.ArrayList;
import java.util.Iterator;

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
		ArrayList<String> textos = new ArrayList<String>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		// add añade un elemento al final
		numeros.add(75);
		numeros.add(175);
		textos.add("Hola mundo cruel");
		textos.add("Adios, me despido de la vida");
		// o en la posición indicada
		textos.add(1, "Intermedio para publicidad");
		// teniendo cuidado de no pasarnos"
		// textos.add(5,"La otra vida...");

		System.out.println(textos);
		System.out.println(numeros);

		// Para recorrer un ArrayList necesitamos usar un Iterator
		Iterator<String> iterador = textos.iterator();
		// hasNext devuelve false cuando ya no haya mas elementos en el ArrayList
		while (iterador.hasNext()) {
			// next nos devuelve un elemento del ArrayList secuencialmente, empezando por el primero
			String elemento = iterador.next();
			System.out.println(elemento);
		}
		// size devuelve el número de elementos
		System.out.println("Tamaño del ArrayList: " + textos.size());
	}
}
