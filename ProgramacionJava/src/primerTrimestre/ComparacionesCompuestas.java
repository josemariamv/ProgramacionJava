package primerTrimestre;

// A continuación tienes varios ejemplos con evaluación de condiciones desde las mas simples
// a algunas con relativa complejidad, por si aún te resultan dificil de entender

public class ComparacionesCompuestas {

	public static void main(String[] args) {
		int n = 5;
		boolean encontrado = true;

		if (n == 5)
			System.out.println("n es igual a 5");

		if (n != 6)
			System.out.println("n no es igual a 6");
		
		if (encontrado)
			System.out.println("Lo he encontrado");
		
		if(!encontrado)
			System.out.println("Lo he encontrado");
		else
			System.out.println("No lo he encontrado");
		
		if (n > 1 && n < 10)
			System.out.println("n está entre 1 y 10");

		if (n < 2 || n == 5)
			System.out.println("n es menor a 2 o igual a 5");

		if(encontrado == true || n==5)
			System.out.println("Lo he encontrado o n es igual a 5");

		if(encontrado == true && n==5)
			System.out.println("Lo he encontrado y n es igual a 5");
		
		if ((n < 2 || n == 5) && encontrado)
			System.out.println("n es menor a 2 o igual a 5 y además lo he encontrado");
	}

}
