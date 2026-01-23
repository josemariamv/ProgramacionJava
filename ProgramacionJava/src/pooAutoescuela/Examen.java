package pooAutoescuela;

import java.util.ArrayList;
import java.util.HashSet;

public class Examen {
	
	private HashSet<Pregunta> preguntasExamen = new HashSet<>();

	public Examen(int numPreguntas, ArrayList<Pregunta> listaPreguntas) {
		int max = listaPreguntas.size();
		while(preguntasExamen.size()!=numPreguntas) {
			int azar = (int)(Math.random()*max);
			preguntasExamen.add(listaPreguntas.get(azar));
		}
	}
	
	public void mostrarExamen() {
		System.out.println("Examen: ");
		for(Pregunta p:preguntasExamen)
			System.out.println(p.getTexto());
	}
	
	public void solucionExamen() {
		
	}
}
