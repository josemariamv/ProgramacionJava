package pooAutoescuela;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Examen {
		private HashSet<Pregunta> preguntasExamen = new HashSet<>();

	public Examen(int numPreguntas, ArrayList<Pregunta> listaPreguntas) {
		// Habría que comprobar que el número de preguntas no es superior a la lista de preguntas
		// si lo fuese se queda colgado
		int max = listaPreguntas.size();
		while(preguntasExamen.size()!=numPreguntas) {
			int azar = (int)(Math.random()*max);
			preguntasExamen.add(listaPreguntas.get(azar));
		}
	}
	
	public void mostrarExamen() {
		for(Pregunta p:preguntasExamen) {
			System.out.println(p.getTexto());
			String[] respuestas = p.getRespuestas();
			for(String r: respuestas)
				System.out.println(r);
		System.out.println("");
		}
		
	}
	
	public void solucionExamen() {
		System.out.println("\nSOLUCIÓN:");
		for(Pregunta p:preguntasExamen) {
			System.out.print(p.getSolucion());
		}
	}
	
	public void corregirExamen() {
		// Se podría mejorar la evaluación (tener en cuenta mayúsculas, minúsculas...)
		// tambien evitar excepciones si el usuario no escribe correctamente lo que se le pide
		int fallos = 0;
		int i=1;
		for(Pregunta p:this.preguntasExamen) {
			System.out.print("Respuesta a la pregunta " + i + ": ");
			Scanner teclado = new Scanner(System.in);
			String respuesta = teclado.nextLine();
			if(respuesta.charAt(0) != p.getSolucion().charAt(0))
				fallos++;
			i++;
		}
		System.out.println("Número de fallos: " + fallos);
		
	}
}
