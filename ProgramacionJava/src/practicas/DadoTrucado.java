package practicas;

import java.util.Scanner;

public class DadoTrucado {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime cuantos dados vas a tirar: ");
		int dados = teclado.nextInt();
		teclado.close();

		boolean todosIguales = false;
		int tiradas = 0;
		int resultados[] = new int[dados];
		int frecuencias[] = new int[7];

		do {
			tiradas++;
			for (int i = 0; i < dados; i++) {
				//int dado = (int) (Math.random() * 6) + 1;
				// duplicamos la posibilidad de que salga un 6
				int dado = (int) (Math.random() * 7) + 1;
				if(dado == 6)
					dado = 7;
				frecuencias[dado]++;
				resultados[i] = dado;
				if (i == dados - 1)
					System.out.println(dado);
				else
					System.out.print(dado + " - ");
			}
			todosIguales = true;
			for (int j = 1; j < dados; j++) {
				if (resultados[0] != resultados[j])
					todosIguales = false;
			}
		} while (todosIguales == false);
		System.out.println("Has necesitado " + tiradas + " tiradas para que salgan todos iguales");
		for (int k = 1; k <= 6; k++)
			System.out.printf("El número %d ha salido el %.2f %% de las veces\n", k,
					(double) (100 * frecuencias[k]) / (dados * tiradas));
	}

}
