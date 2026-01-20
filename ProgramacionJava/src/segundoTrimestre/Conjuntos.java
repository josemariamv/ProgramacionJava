package segundoTrimestre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * HashSet es una colección que almacena elementos únicos (sin duplicados). Usa una tabla hash para acceso rápido
 * No mantiene el orden de inserción. 
 * Se usa para operaciones eficientes de búsqueda cuando no importa el orden, se busca rendimiento y no queremos duplicados 
 */

public class Conjuntos {
	public static void main(String[] args) {
		// Creamos un conjunto vacío y añadimos elementos
		HashSet<String> alumnos = new HashSet<>();
		alumnos.add("Alfonso Litario");
		alumnos.add("Esteban Dolero");
		alumnos.add("Héctor Nudo");
		alumnos.add("Penelope Ligro");
		alumnos.add("Estela Gartija");

		// O lo creo ya con elementos
		HashSet<String> profes = new HashSet<>(Arrays.asList("José María Morales", "Natalia Matarranz", "Yago Navarrete", "Eduardo Moreno"));

		// Podemos ver que no se guardan en el mismo orden que se añaden		
		System.out.println(alumnos);
		System.out.println(profes);
		
		// Añado elementos con add y los elimino con remove.
		// Aqui remove no puede ser nunca la posición porque no controlamos el orden!
		
		profes.remove("Yago Navarrete");
		profes.add("Félix Sotelo");
		System.out.println(profes);
		
		// Si trato de añadir un elemento repetido o borrar uno que no existe no pasa nada pero me devuelve false
		System.out.println(profes.add("Eduardo Moreno"));
		System.out.println(profes.remove("Héctor Estella"));

		// Con contains compruebo si un elemento está o no en el conjunto
		if(alumnos.contains("Héctor Nudo"))
			System.out.println("El alumno está en el conjunto");

		// Puedo ver el tamaño del conjunto con size
		System.out.println("En el conjunto hay " + alumnos.size() + " alumnos");
		
		// Para recorrer un conjunto puedo usar iteradores o la forma común ya conocida.
		for(String alumno:alumnos)
			System.out.println(alumno);
		
		// No hay orden, pero como tengo el tamaño puedo hacer esto también:
		int i=0;
		for(String p:profes) {
			if(i!= profes.size()-1)
				System.out.print(p + ", ");
			else
				System.out.println(p);
			i++;
		}
		
		// Si convierto un ArrayList en HashSet elimino los duplicados fácilmente
		ArrayList<Integer> numeros = new ArrayList<>(List.of(1,2,4,4,5,2,7,3,8,3,9,1,3,5));
		HashSet<Integer> numerosUnicos = new HashSet<>(numeros);
		System.out.println(numerosUnicos);
		// Y luego puedo volver a convertirlo en ArrayList ya sin duplicados si así lo quiero
		numeros = new ArrayList<>(numerosUnicos);
		System.out.println(numeros);
		
		// Para duplicar un conjunto: 
		HashSet<String> personas = new HashSet<>(alumnos);
		
		// Puedo hacer operaciones entre conjuntos:
		// Union:
		personas.addAll(profes);
		System.out.println(personas);
		
		// Interseccion:
		personas.retainAll(profes);
		System.out.println(personas);
		
		// Diferencia:
		personas.removeAll(profes);
		System.out.println(personas);
		
		// subconjunto. Devuelve true si un conjunto tiene todos los elementos del otro
		personas.add("Félix Sotelo");
		System.out.println(profes.containsAll(personas));
		
		// Pasar de array a HashSet
		String[] nombres = {"Pepe", "Juan", "Eva", "Ana"};
		HashSet<String> setNombres = new HashSet<>(Arrays.asList(nombres));
		System.out.println(setNombres);
		
		// Un array de enteros no es tan sencillo ya que no coinciden los tipos Int-Integer
		// Lo mas fácil es hacerlo con un bucle como en ArrayList
		// Este método funciona también con cualquier tipo
		int[] arrayNumeros = {1,23,5,7,5, 9};
		HashSet<Integer> listaNumeros = new HashSet<>();
		for(int n:arrayNumeros)
			listaNumeros.add(n);
		System.out.println(listaNumeros);
		
		// Pasar un HashSet a Array
		HashSet<String> frutasSet = new HashSet<>(Arrays.asList("Pera", "Manzana", "Fresa"));
		String[] frutasArray = frutasSet.toArray(new String[0]);
		for (String f: frutasArray)
			System.out.print(f + " - ");
		
		System.out.println("---");
		
		// De enteros tenemos el mismo problema de siempre con la conversion Integer-Int
		// Es mas fácil con un bucle
		int masNumeros[] = new int[listaNumeros.size()];
		int j=0;
		for(int n:listaNumeros) {
			masNumeros[j] = n;
			j++;
		}
		for (int n: masNumeros)
			System.out.print(n + " - ");	
	}
}
