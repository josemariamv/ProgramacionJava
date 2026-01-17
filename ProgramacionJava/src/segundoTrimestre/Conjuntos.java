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
		
	}
}
