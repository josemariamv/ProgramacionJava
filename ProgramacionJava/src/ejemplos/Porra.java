package ejemplos;

import java.io.RandomAccessFile;

public class Porra {

	static final int NUM_BOLETOS = 100;
	static final int TAMANYO_NOMBRE = 30;
	static final int TAMANYO_REGISTRO = TAMANYO_NOMBRE * 2;

	// EL método utilizado es muy similar al que hemos visto en clase
	// de hecho, puedes observar que muchos de los métodos son corta-pegas con
	// ligeras modificaciones

	public static void main(String[] args) {
		String fichero = "porra.dat";
		try {
			crearFichero(fichero);
			apuestaPorNumero(5, "Pepe Morón", fichero);
			apuestaPorNumero(4, "Rocío López", fichero);
			apuestaPorNumero(10, "Javier Ruíz", fichero);
			apuestaPorNumero(1, "Antonio Barbas", fichero);
			apuestaPorNumero(9, "Andrea", fichero);
			apuestaPorNumero(4, "Paquita", fichero);
			apuestaPorNumero(3, "Jordan", fichero);
			apuestaPorNumero(6, "Andrés", fichero);
			apuestaPorNumero(8, "Sara", fichero);
			apuestaPorNumero(2, "Martín", fichero);
			apuestaPorNumero(7, "Lucía", fichero);
			listarParticipantes(fichero);
			// Dos estrategias a la hora de hacer el sorteo
			// La 1, si no están apostados todos los números no se hace
			hacerSorteo1(fichero);
			// La 2, si sale un número por el que no ha apostado nadie se repite el sorteo
			hacerSorteo2(fichero);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void crearFichero(String fichero) throws Exception {
		// Creamos el fichero con tantas entradas vacías como indique NUM_BOLETOS
		// Usamos * para indicar que ese número aún no tiene ninguna apuesta
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			for (int i = 0; i < NUM_BOLETOS; i++) {
				escribirNombre(raf, "*");
			}
			System.out.println("Archivo creado con " + NUM_BOLETOS + " posibles boletos");
		}
	}

	private static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
		// Crea un array de caractere del tamaño fijo
		// Es exactamente el mismo método del ejercicio de clase
		char[] chars = new char[TAMANYO_NOMBRE];
		// Llenar con espacios o con el nombre
		for (int i = 0; i < TAMANYO_NOMBRE; i++)
			if (i < nombre.length())
				chars[i] = nombre.charAt(i);
			else
				chars[i] = ' '; // Rellenar con espacios
		// Escribir cada caracter como char (2 bytes cada uno)
		for (char c : chars)
			raf.writeChar(c);
	}

	public static void apuestaPorNumero(int numero, String nombre, String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			if (numero > NUM_BOLETOS)
				System.out.println("El mayor número por el que es posible apostar es el " + NUM_BOLETOS);
			else {
				// Al igual que hacíamos en clase, buscamos el registro indicado y leemos
				long offset = (numero - 1) * TAMANYO_REGISTRO;
				raf.seek(offset);
				String nombreEnFichero = leerNombre(raf);
				// Ahora, si hay un asterisco es que nadie ha apostado: retrocedemos y escribimos el nombre
				if (nombreEnFichero.charAt(0) == '*') {
					raf.seek(offset);
					escribirNombre(raf, nombre);
					System.out.println("Apuesta de " + nombre + " al número " + numero + " registrada correctamente");
				} else
					System.out.println(nombreEnFichero + " ya ha apostado por el número " + numero
							+ ". Elige otro número " + nombre);
			}
		}
	}

	private static String leerNombre(RandomAccessFile raf) throws Exception {
		String nombre = "";
		// Exactamente el mismo método del ejercicio de clase
		for (int i = 0; i < TAMANYO_NOMBRE; i++) {
			char c = raf.readChar();
			nombre = nombre + c;
		}
		return nombre.trim();
	}

	public static void listarParticipantes(String fichero) throws Exception {
		System.out.println("LISTA DE PARTICIPANTES EN LA PORRA:");
		int contador = 0;
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			// Recorremos el fichero completamente pero solo listamos las entradas donde no hay asterisco
			for (int i = 0; i < NUM_BOLETOS; i++) {
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) != '*') {
					System.out.printf("Número: %d: - Participante: %s\n", i + 1, nombre);
					contador++;
				}
			}
		}
		// Usamos un contador para distinguir los casos especiales: que nadie haya apostado o que el sorteo esté completo
		// En caso contrario indicamos cuantas apuestas faltan. Podríamos ampliarlo diciendo los números por los que no ha apostado 
		// nadie aún ¿te animas a hacerlo?
		if (contador == 0)
			System.out.println("Aún no ha participado nadie en la porra! Anímate!");
		else if (contador == NUM_BOLETOS)
			System.out.println("La porra está completa. Es hora de realizar el sorteo!");
		else
			System.out.printf("Faltan %d números por los que apostar para poder realizar el sorteo\n",
					NUM_BOLETOS - contador);
	}

	public static void hacerSorteo1(String fichero) throws Exception {
		int contador = 0;
		// Primer método. Tenemos que ver antes que estén todos los números.
		// Lo hacemos con un contador como en el método anterior
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			for (int i = 0; i < NUM_BOLETOS; i++) {
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) != '*')
					contador++;
			}
			// Si no están todas las apuestas no hacemos el sorteo
			if (contador != NUM_BOLETOS)
				System.out.printf(
						"El sorteo no puede realizarse aún. Hay %d números por los que nadie ha apostado aún\n",
						NUM_BOLETOS - contador);
			else {
				// En caso contrario, elegimos un número al azar y vemos quien ha ganado
				int numGanador = (int) (Math.random() * NUM_BOLETOS) + 1;
				long offset = (numGanador - 1) * TAMANYO_REGISTRO;
				raf.seek(offset);
				String ganador = leerNombre(raf);
				System.out.printf("El ganador es el número %d y la persona afortunada es %s!\n", numGanador, ganador);
			}
		}
	}

	public static void hacerSorteo2(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			String ganador = null;
			int numGanador = 0;
			// En este caso, vamos a elegir números aleatorios hasta que encontremos un ganador
			// La condición de salida es que el registro elegido al azar tenga un apostador válido (no sea *)
			do {
				numGanador = (int) (Math.random() * NUM_BOLETOS) + 1;
				long offset = (numGanador - 1) * TAMANYO_REGISTRO;
				raf.seek(offset);
				ganador = leerNombre(raf);
			}while(ganador.equals("*"));
			System.out.printf("El ganador es el número %d y la persona afortunada es %s!\n", numGanador, ganador);
		}
	}
}
