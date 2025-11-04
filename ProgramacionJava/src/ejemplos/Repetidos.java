package ejemplos;

import java.util.Arrays;

public class Repetidos {
	
	public static void main(String[] args) {	
		int cantidad = 100;
		int tabla[] = new int[cantidad];
		for (int i = 0; i < cantidad; i++)
			tabla[i] = (int) (Math.random() * 50) + 1;
		// Calcular el mayor y el menor es fácil: solo hay que ordenar el array y coger el primer elemento y el último
		Arrays.sort(tabla);
		System.out.println("El menor es " + tabla[0] + " y el mayor " + tabla[cantidad - 1]);
		// Mostramos la tabla para poder hacer comprobaciones de que funciona. En la versión final quitaríamos estas dos líneas siguientes
		for (int n : tabla)
			System.out.print(n + ", ");
		
		// vamos a calcular cual es el que se repite mas veces
		// usaremos estas cuatro variables. Las dos primeras guardaran el mas repetido y las veces que aparece. 
		int numeroMasRepetido = 0;
		int repeticionesGanadoras = 0;
		int numero = 0;
		int repeticiones = 0;
		
		// recorremos la tabla de números
		for (int i = 0; i < cantidad - 1; i++) {
			// si detectamos una repetición en dos elementos contiguos, ya que están ordenados
			if (tabla[i] == tabla[i + 1]) {
				// mostramos un mensaje para ver lo que pasa. Luego eliminaríamos esta línea
				System.out.println("El elemento " + tabla[i] + " está repetido con su contiguo");
				// la variable número guardará el número repetido
				numero = tabla[i];
				// e incrementamos las repeticiones que hemos inicializado a 0 
				repeticiones++;
				}
			else {
				// si dos números continuos no están repetidos revisamos si las repeticiones acumuladas son mayores que 
				// la anterior que tenemos guardada
				if(repeticionesGanadoras < repeticiones) {
					// si lo son, guardamos el número y las repeticiones como las mayores
					repeticionesGanadoras = repeticiones;
					numeroMasRepetido = numero;
				}
			// y ponemos las repeticiones a 0
			repeticiones = 0;
			}
		}
		// tenemos que volver a repetir la comparación por si el número mas repetido es el último de la tabla
		if(repeticionesGanadoras < repeticiones) {
			repeticionesGanadoras = repeticiones;
			numeroMasRepetido = numero;
		}
		// Y presentamos el resultado.
		System.out.println("El número mas repetido es el " + numeroMasRepetido + " y aparece " + repeticionesGanadoras + " veces");
		// Esta solución tiene un problema: Si hubiera un empate se queda con el primer número mas repetido
		// Si quisieramos que se quedara con el último mas repetido haríamos la comparación de repeticionesGanadoras con <=
		// Si quisieramos que en caso de empate nos mostrara todos los números empatados tendríamos que complicarlo bastante mas y no merece la pena
		// Porque mas adelante veremos soluciones mas fáciles para este tipo de problemas
	}
}
