package primerTrimestre;

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
		
		// Devuelve el elemento que esta en la posición '2' del ArrayList
		// nombreArrayList.get(2);
		
		// Comprueba se existe del elemento ('Elemento') que se le pasa como parametro
		//nombreArrayList.contains("Elemento");
		
		// Devuelve la posición de la primera ocurrencia ('Elemento') en el ArrayList  
		//nombreArrayList.indexOf("Elemento");
		
		// Devuelve la posición de la última ocurrencia ('Elemento') en el ArrayList   
		//nombreArrayList.lastIndexOf("Elemento");
		
		// Borra el elemento de la posición '5' del ArrayList   
		//nombreArrayList.remove(5);
		
		// Borra la primera ocurrencia del 'Elemento' que se le pasa como parametro.  
		//nombreArrayList.remove("Elemento");
		
		//Borra todos los elementos de ArrayList   
		// nombreArrayList.clear();
		
		// Devuelve True si el ArrayList esta vacio. Sino Devuelve False   
		// nombreArrayList.isEmpty();
		
		// Copiar un ArrayList 
		// ArrayList arrayListCopia = (ArrayList) nombreArrayList.clone();  
		
		// Pasa el ArrayList a un Array 
		//Object[] array = nombreArrayList.toArray();  
	}
}
