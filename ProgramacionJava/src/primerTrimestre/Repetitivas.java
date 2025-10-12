package primerTrimestre;
import java.util.Random;

public class Repetitivas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Los bucles for y while (y su variante do-while) son las estructuras de
		 * control que usamos para estructuras repetitivas. Como regla general usaremos
		 * for cuando conocemos el número de repeticiones que tenemos que hacer mientras
		 * que usaremos while cuando no lo conocemos y dependemos de una causa externa.
		 * do-while se diferencia de while básicamente en que en do-while tenemos
		 * garantizada una ejecución del bloque de instrucciones mientras que en el
		 * while clásico podríamos no ejecutar ni una vez
		 */

		/*
		 * En el paréntesis del for hay tres zonas separadas por ;
		 * inicializacion;condición de salida;actualización La primera vez que llegamos
		 * al for se ejecutan la inicialización y se comprueba la condición de salida. A
		 * partir de la segunda la actualización y la condición de salida. El bloque del
		 * for está delimitado por llaves aunque si hay una única instrucción puede
		 * omitirse. En el ejemplo siguiente las llaves no son necesarias. El bloque de
		 * instruciones se ejecuta repetitivamente mientras que la condición de salida
		 * se evalúa como true
		 */
		for (int veces = 0; veces < 5; veces++) {
			System.out.println(veces);
		}

		/*
		 * Este bucle for hace lo mismo que el anterior for. Como vemos es peor opción
		 * puesto que sabemos el número de veces que se va a ejecutar y no es por tanto
		 * la estructura adecuada. En el paréntesis del while se pone la condición de
		 * salida El bloque de instrucciones del while se ejecuta mientras que la
		 * condición se evalúa como true. Aquí si queremos una inicialización y una
		 * actualización tenemos que crearla nosotros. La inicialización antes del while
		 * y la actualización dentro.
		 */
		int contador = 0;
		while (contador < 5) {
			System.out.println(contador);
			contador++;
		}

		/*
		 * El do-while es muy similar al while pero la condición de salida se evalúa
		 * después del bloque de instrucciones. Por tanto el bloque se ejecuta siempre
		 * al menos una vez. Fíjate bien que lleva un ; después del paréntesis con la
		 * condición de salida. Es el único caso que hemos visto así. Si no lo lleva
		 * dará un error.
		 */
		int repeticiones = 0;
		do {
			System.out.println(repeticiones);
			repeticiones++;
		} while (repeticiones < 5);

		/*
		 * Las variables en Java tienen un "ámbito de vida" que es el bloque donde se
		 * declaran. Fuera de ese ámbito no existen. Si declaro una variable dentro de
		 * un bloque esta no existe fuera de él. En el siguiente ejemplo la variable
		 * dado no existe fuera del while Si trato de usarla fuera da un error. Si la
		 * vuelvo a crear me dejará pero será una variable distinta. En el siguiente
		 * ejemplo la variable dado que se crea dentro del bloque del while no existe
		 * fuera de él. Se trata, de hecho, de una varaible nueva en cada ejecución de
		 * este bloque
		 */
		boolean terminado = false;
		while (terminado == false) {
			int dado = (int) (Math.random() * 6) + 1;
			if (dado == 6) {
				terminado = true;
				System.out.println("Un 6. Terminamos");
			} else {
				System.out.println("Ha salido un " + dado);
			}
		}
		// La siguiente instrucción da error porque la variable dado no existe fuera del
		// bloque del while
		// System.out.println(dado);

		/*
		 * En los bucles for las variables que se declaran en el paréntesis en la zona
		 * de inicialización es como si estuvieran dentro del bloque y tampoco existen
		 * fuera de él. Los paréntesis del while y el do-while se consideran fuera del
		 * bloque. Los paréntesis de la instrucción if también.
		 */

		/*
		 * Importante: si tenemos varios bloques de instrucciones anidados uno dentro de
		 * otro la vida de las variables se transmite hacía dentro pero no hacía fuera.
		 * Por eso la variable dado en el último ejemplo existe dentro de los bloques
		 * if-else pero no fuera del bloque while
		 */
	}

}
