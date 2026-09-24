package ejemplos;

import java.util.Scanner;

public class Condicionales {

	public static void main(String[] args) {
		// ordenar tres números de menor a mayor
		int a = 121;
		int b = 2;
		int c = 21;
		int menor, mayor, enmedio;
		
		if(a<b && a<c) {
			menor = a;
			if(b<c) {
				enmedio = b;
				mayor = c;
			}
			else {
				enmedio = c;
				mayor = b;
			}
		}
		else if(b<a && b<c) {
			menor = b;
			if(a<c) {
				enmedio = a;
				mayor = c;
			}
			else {
				enmedio = c;
				mayor = a;
			}
		}
		else {
			menor = c;
			if(a<b) {
				enmedio = a;
				mayor = b;
			}
			else {
				enmedio = b;
				mayor = a;
			}
		}
		System.out.println(menor);
		System.out.println(enmedio);
		System.out.println(mayor);	
		
		// Convertir entre unidades de temperatura y un pequeño menú
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce la temperatura: ");
		double temperatura = teclado.nextDouble();
		System.out.println("1 - Convertir de Celsius a Farenheit");
		System.out.println("2 - Convertir de Farenheit a Celcius");
		System.out.print("Introduce tu elección: ");
		int opcion = teclado.nextInt();
		teclado.close();
		double resultado;
		if(opcion == 1) {
			resultado = (temperatura*9/5)+32;
			System.out.println(temperatura+"ºC = " + resultado + "ºF");
		}else {
			resultado = (temperatura-32)*5/9;
			System.out.println(temperatura+"ºF = " + resultado + "ºC");
		}
		
		// calcular el IMC y dar un diagnóstico en función del mismo
		teclado = new Scanner(System.in);
		System.out.print("Altura (en metros): ");
		double altura = teclado.nextDouble();
		System.out.print("Peso (en kgs): ");
		double peso = teclado.nextDouble();
		teclado.close();
		double imc = peso/(altura * altura);
		System.out.println("IMC: " + imc);
		
		if(imc<=18.5)
			System.out.println("Tu peso es bajo para tu altura");
		else if(imc <=25)
			System.out.println("Tu peso es normal");
		else if(imc <=30)
			System.out.println("Tienes algo de sobrepeso");
		else
			System.out.println("Tienes un problema de obesidad");
	}

}
