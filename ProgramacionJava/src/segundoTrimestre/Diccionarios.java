package segundoTrimestre;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Ejemplo{
	private int dato1;
	private String dato2;
	
	public Ejemplo() {
		
	}
}

/*
 * HashMap es una estructura de datos que almacena información en pares de clave-valor. Similar a los diccionarios de Python
 * Ideal cuando necesitas buscar datos de forma instantánea usando un identificador único (la clave) en lugar de un índice numérico.
 */

public class Diccionarios {
	public static void main(String[] args) {
		// El primer elemento (String) es la clave y el segundo (Double) el valor
		// Lógicamente podemos poner lo que queramos en cada uno de ellos
		HashMap<String, Double> fruteria = new HashMap<>();
		
		// cargamos el diccionario
		fruteria.put("Manzanas Golden", 12.54);
		fruteria.put("Fresas", 25.30);
		fruteria.put("Peras de agua", 9.33);
		
		// Si uso put con una clave que ya existe no da error ni crea una nueva: sobreescribe el valor
		fruteria.put("Peras de agua", 10.25);
		
		// Podemos crear diccionarios con cualquier tipo de clave y de valor
		HashMap<Integer, String> personas = new HashMap<>();
		personas.put(655112233, "José María Morales");
		
		HashMap<String, String> personas2 = new HashMap<>();
		personas2.put("28888777X", "José María Morales");

		// O incluso con objetos
		HashMap<Integer, Ejemplo> objetos = new HashMap<>();
		Ejemplo ej1 = new Ejemplo();
		objetos.put(1, ej1);

		HashMap<Ejemplo, String> objetos2 = new HashMap<>();
		objetos2.put(ej1, "HOLA");
		
		// Podemos comprobar previamente si el elemento existe así:
		if(fruteria.containsKey("Fresas"))
			System.out.println("Ya tengo fresas");
		else
			fruteria.put("Fresas", 25.30);
		
		// accedemos a los elementos a través de su clave (el primer valor)
		System.out.printf("El precio de las Fresas es de %.2f€\n", fruteria.get("Fresas"));
		
		// Recorrer el diccionario es diferente al resto de las colecciones
		// Al igual que ocurría con HashSet tampoco se mantiene el orden de los elementos
		// Recorrido completo (claves y valores)
		for(Map.Entry<String, Double> producto : fruteria.entrySet())
			System.out.printf("Producto: %s: %.2f\n", producto.getKey(), producto.getValue());
		
		// Solo claves
		for (String producto : fruteria.keySet()) {
		    System.out.println("Producto: " + producto);
		}
		
		// Solo valores
		for (Double precio : fruteria.values()) {
			System.out.println("Precio: " + precio);
		}
		
		// Y otro método usando funciones lambda (que aún no hemos visto!)
		fruteria.forEach((fruta, precio) -> System.out.println(fruta + ": " + precio + "€"));

		// Y para usar un Iterator
        Iterator<Map.Entry<String, Double>> iterador = fruteria.entrySet().iterator();
        while (iterador.hasNext()) {
            Map.Entry<String, Double> producto = iterador.next();
			System.out.printf("Producto: %s: %.2f\n", producto.getKey(), producto.getValue());
        }
        
        // O así mas fácil, usando un Iterator solo con las claves (y obteniendo el valor)
        System.out.println("\nIterar solo las claves y obtener el valor:");
        Iterator<String> itClaves = fruteria.keySet().iterator();
        while (itClaves.hasNext()) {
            String producto = itClaves.next();
			System.out.printf("Producto: %s: %.2f\n", producto, fruteria.get(producto));
        }
		
		// Y para eliminar un elemento usamos remove
		fruteria.remove("Manzanas Golden");
		
		if(!fruteria.containsKey("Manzanas Golden"))
			System.out.println("No hay Manzanas Golden");
		
		// O podemos borrar de una vez todas las entradas que cumplen una condición en su valor
		fruteria.entrySet().removeIf(entrada -> entrada.getValue() < 15);
		
        System.out.println("\nDespués de borrar todas las que tienen precio menor a 15:");
		for(Map.Entry<String, Double> producto : fruteria.entrySet())
			System.out.printf("Producto: %s: %.2f\n", producto.getKey(), producto.getValue());
	}
}
