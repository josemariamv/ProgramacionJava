package ejemplos;

public class OrdenarTres {

	public static void main(String[] args) {
		// El problema de ordenar tres números usando max y min
		int a = 14;
		int b = 33;
		int c = 7;
		
		int mayor = Math.max(Math.max(a, b), c);
		int menor = Math.min(Math.min(a, b), c);
		
		// Aunque podríamos hacerlo mediante cuatro comparaciones de max y de min
		// usamos este truco para calcular el de enmedio:
		int enmedio = a + b + c -mayor - menor;
		
		System.out.println(menor + ", " + enmedio + ", " + mayor);
		
	}

}
