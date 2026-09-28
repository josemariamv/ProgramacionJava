package ejemplos;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Azar {
	public static void main(String[] args) {
		// El problema del dado en el juego de rol ahora con random
		int dado = (int)((Math.random()*6)+1);
		System.out.print("Has sacado un " + dado);
		if(dado <= 2)
			System.out.println(". Has fallado el golpe");
		else if(dado <= 4)
			System.out.println(". Has causado una herida leve");
		else if(dado == 5)
			System.out.println(". Has causado una herida grave");
		else
			System.out.println(". Has causado un daño crítico!");
		
		// genera un pin de 4 dígitos. Primer método
		// Cuando aprendamos a manejar bucles y arrays lo haremos mejor
		int pin1 = (int)(Math.random()*10);
		int pin2 = (int)(Math.random()*10);
		int pin3 = (int)(Math.random()*10);
		int pin4 = (int)(Math.random()*10);
		System.out.println("Pin: " + pin1 + pin2 + pin3 + pin4);
		
		// Otro método. Igualmente, cuando aprendamos a manejar mejor los String lo haremos mejor
		final int INICIO = 0;
		final int FIN = 9999;
		int pin = ThreadLocalRandom.current().nextInt(INICIO, FIN + 1);
		if(pin < 10)
			System.out.println("Pin: 000" + pin);
		else if(pin < 100)
			System.out.println("Pin: 00" + pin);
		else if(pin < 1000)
			System.out.println("Pin: 0" + pin);
		else
			System.out.println("Pin: " + pin);
		
		// Preguntamos el número de alumnos de la clase y sacamos a uno a la pizarra
		Scanner teclado = new Scanner(System.in);
		System.out.print("¿Cuántos alumnos/as tienes en la clase? ");
		int alumnos = teclado.nextInt();
		teclado.close();
		
		Random azar = new Random();
		int aLaPizarra = azar.nextInt(alumnos) + 1;
		System.out.println("Le toca salir a la pizarra al alumno/a: " + aLaPizarra);
	}
	

}
