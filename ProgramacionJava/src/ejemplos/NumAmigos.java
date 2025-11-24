package ejemplos;

public class NumAmigos {
	public static void main(String[] args) {
		if (esPerfecto(8128) == true)
			System.out.println("Es perfecto");
		else
			System.out.println("No es perfecto");
	}

	public static boolean esPerfecto(int n1) {
		boolean perfecto = false;
		int suma1 = devuelveSumaDivPropios(n1);
		if (suma1 == n1)
			perfecto = true;
		return perfecto;
	}
	
	public static boolean esAbundante(int n1) {
		boolean abundante = false;
		int suma1 = devuelveSumaDivPropios(n1);
		if (suma1 > n1)
			abundante = true;
		return abundante;
	}
	
	public static boolean esDefectivo(int n1) {
		boolean defectivo = false;
		int suma1 = devuelveSumaDivPropios(n1);
		if (suma1 < n1)
			defectivo = true;
		return defectivo;
	}

	public static boolean sonAmigos(int n1, int n2) {
		boolean amigos = false;
		int suma1 = devuelveSumaDivPropios(n1);
		int suma2 = devuelveSumaDivPropios(n2);
		if (suma1 == n2 && suma2 == n1)
			amigos = true;
		return amigos;
	}

	public static int devuelveSumaDivPropios(int num) {
		int suma = 1;
		int raiz = (int) Math.sqrt(num) + 1;
		for (int i = 2; i < raiz; i++)
			if (num % i == 0) {
				suma += i;
				suma += (num / i);
			}
		return suma;
	}
}
