package tercerTrimestre;

public class Lambda {
	// Una función lambda es una función anónima (sin nombre) que puede ser tratada
	// como un objeto
	// siempre que implemente una interfaz funcional.

	public static void main(String[] args) {

		// definición de lambda
		Runnable hola = () -> System.out.println("Hola Mundo");
		// uso
		Thread hilo = new Thread(hola);
		hilo.start();

	}

}
