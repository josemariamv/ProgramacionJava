package segundoTrimestre;

import java.util.ArrayList;
import java.util.Collections;

// A través de la clase Collections puedo mejorar el uso de los ArrayLists 
// y de otras colecciones
public class Listas2 {
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		// addAll me permite hacer una carga rápida de elementos
		Collections.addAll(numeros, 73, 30, 1, 22, 33, 15, 20, 34, 8, 22, 12, 40);
		System.out.println(numeros);
		
		// sort ordena de mayor a menor
		Collections.sort(numeros);
		System.out.println(numeros);
		
		// Sobre una lista ordenada es mucho mas rapido buscar con binarySearch
		// OJO: si la lista no está ordenada no funcionará
		// Sólo tiene sentido con listas enooooormes. En otras no notaremos la mejora
		int posicion = Collections.binarySearch(numeros, 34);
		if(posicion >= 0)
			System.out.println("El elemento está en la posicion: " + posicion);
		else
			System.out.println("El elemento no está en la lista");
		
		// reverse invierte el orden de la lista (después de un sort ordena de mayor a menor)
		Collections.reverse(numeros);
		System.out.println(numeros);
		
		// shuffle mezcla aleatoriamente los elementos
		Collections.shuffle(numeros);
		System.out.println(numeros);
		
		// por último, max y min encuentran el mayor y el menor
		int maximo = Collections.max(numeros);
        int minimo = Collections.min(numeros);
        System.out.printf("Mayor: %d - Menor: %d\n", maximo, minimo);
        
        int veces = Collections.frequency(numeros, 22);
        System.out.println("El número 22 aparece " + veces + " veces");
		
        
        // Estos ejemplos sirven con listas con otros tipos de elementos... pero habría que estudiar con objetos como funciona en cada caso!
        ArrayList<String> alumnos = new ArrayList<>();
		Collections.addAll(alumnos, "Eva", "Pepe", "Andrés", "Aurora");
		Collections.shuffle(alumnos);
		System.out.println(alumnos);
		System.out.println(Collections.max(alumnos));
		System.out.println(Collections.min(alumnos));
		Collections.reverse(alumnos);
		System.out.println(alumnos);
		Collections.sort(alumnos);
		System.out.println(alumnos);
	}
	
}
