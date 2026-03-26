package ejemplos;

public class Porra {
	
	static final int NUM_BOLETOS = 10;
	static final int TAMANYO_NOMBRE = 30;
	static final int TAMANYO_REGISTRO = TAMANYO_NOMBRE*2;
	
	
	public static void main(String[] args) {
		String fichero = "porra.dat";
		crearFichero(fichero);
		apuestaPorNumero(5,"Pepe Morón", fichero);
		apuestaPorNumero(4,"Rocío López",fichero);
		apuestaPorNumero(10,"Javier Ruíz",fichero);
		apuestaPorNumero(1,"Antonio Barbas",fichero);
		apuestaPorNumero(4,"Paquita",fichero);
		listarParticipantes(fichero);
		String ganador = hacerSorteo(fichero);
		if(ganador!=null)
			System.out.println("El ganador o ganadora es: " + ganador);
	}
	
	public static void crearFichero(String fichero) {
		
	}
	
	public static void apuestaPorNumero(int numero, String nombre, String fichero) {
		
	}
	
	public static void listarParticipantes(String fichero) {
		
	}
	
	public static String hacerSorteo(String fichero) {
		String ganador = null;
		return ganador;
	}
}
