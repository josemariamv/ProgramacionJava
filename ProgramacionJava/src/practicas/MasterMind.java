package practicas;

public class MasterMind {
	public static void main(String[] args) {
		int[] numeros = new int[4];
		generaNumeros(numeros);
		
		for(int num: numeros)
			System.out.print(num + " ");
	}
	
	public static void generaNumeros(int[] numeros) {
		boolean repetido;
		int azar;
		for (int i = 0; i < 4; i++) {
			do {
				repetido = false;
				azar = (int) (Math.random() * 6) + 1;
				for (int j = 0; j < 4 && repetido == false; j++)
					if (numeros[j] == azar)
						repetido = true;
			} while (repetido);
			numeros[i] = azar;
		}
	}
}
