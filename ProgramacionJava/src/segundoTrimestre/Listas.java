package segundoTrimestre;

import java.util.ArrayList;
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
		
		// Las listas  son similares a los ArrayList pero son inmutables (como las tuplas de python)
		List<Double> tupla = List.of(1.5, 2.5, 3.5);

		// add añade un elemento al final
		numeros.add(75);
		numeros.add(175);
		numeros.add(75);
		numeros.add(15);
		
		textos.add("Hola mundo cruel");
		textos.add("Adios, me despido de la vida");
		
		// esto no puede hacerse. Ya hemos dicho que son inmutables!
		// tupla.add(3.3)
		
		// o en la posición indicada
		textos.add(1, "Intermedio para publicidad");
		numeros.add(0,15);
		
		// teniendo cuidado de no pasarnos"
		// textos.add(5,"La otra vida...");

		System.out.println(textos);
		System.out.println(numeros);
		System.out.println(notas);
		System.out.println(tupla);

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
		System.out.println(textos.get(2));
		
		// Si me paso casca
		//System.out.println(textos.get(3));
		
		// Comprueba se existe el elemento ('Elemento') que se le pasa como parametro
		if(numeros.contains(175))
			System.out.println("El elemento está en el arraylist");
		
		// Devuelve la posición de la primera ocurrencia ('Elemento') en el ArrayList  
		System.out.println(numeros.indexOf(75));
		
		// Devuelve la posición de la última ocurrencia ('Elemento') en el ArrayList   
		System.out.println(numeros.lastIndexOf(75));
		
		// Borra el elemento de la posición '1' del ArrayList   
		numeros.remove(1);
		System.out.println(numeros);
		
		// Borra la primera ocurrencia del 'Elemento' que se le pasa como parametro.  
		numeros.remove((Integer)15);
		System.out.println(numeros);
		
		// Borra todos los elementos de ArrayList   
		numeros.clear();
		
		// Devuelve True si el ArrayList esta vacio. Sino Devuelve False   
		if(numeros.isEmpty())
			System.out.println("El arraylist está vacío");
		
		// Copiar un ArrayList 
		ArrayList textos2 = (ArrayList) textos.clone();
		System.out.println(textos);
		System.out.println(textos2);
				
	}
}
