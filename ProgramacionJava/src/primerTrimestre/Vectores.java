package primerTrimestre;

import java.util.Arrays;

public class Vectores {

	public static void main(String[] args) {
		/*
		 * Un vector, en Java, es una lista de elementos homogeneos y ordenados
		 * La forma genérica de llamar a este tipo de estructuras es array 
		 * (o arreglos en español latino). Un vector no es mas que un array de
		 *  una única dimensión
		 */
		
		// Así definimos un vector vacio de 5 enteros
		int vector[] = new int[5];
		// Y así uno vacío de 10 cadenas de texto
		String lista[] = new String[10];
		
		// en ocasiones también podemos definirlo así, indicando el tipo de dato pero no su tamaño
		// pero mucho cuidado porque en este caso no hemos asignado espacio para guardar nada en el
		int[] vector2;
		
		// O así, asignando el contenido del vector e implicitamente su tamaño
		double[] notas = {7.5, 3.3, 6.0, 9.6, 7.2};
		
		// Podemos recuperar datos del vector o llenarlos usando esta sintaxis:
		vector[2] = 5;
		lista[0] = "Hola mundo";
		System.out.println(lista[0]);
		// La primera posición usa el índice 0, como en las cadenas de texto
		// Pero cuidado tratar de escribir o leer de una posición de un vector que no existe me dará error
		//vector[7] = 10;
		
		// si existe pero no hemos metido nada en esa posicion me devolverá 0 o null
		System.out.println(vector[0]);
		System.out.println(lista[1]);
		
		// Puedo crear un array de dos dimensiones de esta forma
		int[][] matriz = new int[2][3];
		
		// El primer índice serían las filas y el segundo las columnas. 
		// Lo anterior define una matriz de enteros de dos filas y tres columnas
		// Así asigno un dato en la primera posición de la segunda fila:
		matriz[1][0] = 5;
		
		// para crear una matriz e inicializarla al mismo tiempo:
		
		String[][] alumnos= {{"Ana", "Perez"}, {"Roberto", "López"}, {"Manuel", "Peláez"}};
		System.out.println(alumnos[1][1]); // Apellido del segundo alumno
		
		// podemos recorrer todas las posiciones de un vector así:
		for(int i=0; i<notas.length; i++)
			System.out.println(notas[i]);
		
		// pero existe un bucle for mas cómodo para recorrer arrays:
		for (double nota: notas)
			System.out.println(nota);
 
		// Los arrays no se pueden asignar normalmente como si fuesen una variable común por ejemplo si hacemos esto:
		String[] profesores = {"Natalia", "Víctor", "Eduardo", "Félix", "José María"};
		String[] otrosProfesores = profesores;
		
		// y ahora hago esto:
		profesores[3] = "Yago";
		
		// En el segundo array también he cambiado el valor porque realmente tengo dos variables que apuntan al mismo sitio
		for(String profe: otrosProfesores)
			System.out.print(profe + ", ");
		System.out.println("\n");
			
		// Si realmente quiero una copia independiente uso el método copyOf
		String[] masProfesores = Arrays.copyOf(profesores,5);
		profesores[3] = "Félix";
		// ahora el cambio no se ha realizado en masProfesores porque es una copia independiente y no una referencia
		for(String profe: masProfesores)
			System.out.print(profe + ", ");
		System.out.println("\n");
		
		// Puedo copiar solo algunos de los elementos del array (empezando por el principio)
		String[] losTresPrimerosProfesores = Arrays.copyOf(profesores,3);
		for(String profe: losTresPrimerosProfesores)
			System.out.print(profe + ", ");
		System.out.println("\n");
		
		// O ampliarlo para poder meter mas al final
		String[] muchosMasProfesores = Arrays.copyOf(profesores,7);
		muchosMasProfesores[5] = "Agustín";
		muchosMasProfesores[6] = "Fernando";
		for(String profe: muchosMasProfesores)
			System.out.print(profe + ", ");
		System.out.println("\n");
		
		// El metodo equals sirve para comparar si dos arrays son iguales
		if(masProfesores.equals(profesores) == true)
			System.out.println("Los dos arrays son iguales");
		else
			System.out.println("Los dos arrays no son iguales");
		
		// sort ordena un array de forma ascendente si son números o alfabéticamente si son string
		Arrays.sort(muchosMasProfesores);
		for(String profe: muchosMasProfesores)
			System.out.print(profe + ", ");
		System.out.println("\n");
		
		// binarySearch busca si un valor existe en el array, pero solo funciona si el array está ordenado
		// devuelve la posición donde se encuentra el elemento o un valor menor de 0 si no está
		System.out.println(Arrays.binarySearch(muchosMasProfesores, "Fernando"));
		if(Arrays.binarySearch(muchosMasProfesores, "Fernando") < 0)
			System.out.println("No está en la lista de profes");
		else
			System.out.println("Está en la lista de profes");
		
		// fill sirve para rellenar todas las posiciones de un array con el mismo valor
		int diasDelMes[] = new int[12];
		Arrays.fill(diasDelMes,31);
		for(int mes:diasDelMes)
			System.out.print(mes + ", ");
		System.out.println("\n");
		
		// toString convierte el contenido del array en una cadena de texto
		String texto = Arrays.toString(muchosMasProfesores);
		System.out.println(texto);
		texto = texto.replace("[", "");
		texto = texto.replace("]", "");
		System.out.println(texto);
		
		
	}
}
