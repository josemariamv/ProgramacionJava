package pooAutoescuela;

import java.util.ArrayList;
import java.util.HashSet;

public class Pregunta {	
	private static ArrayList<Pregunta> preguntas = new ArrayList<>();
	private String texto;
	private String correcta;
	private String falsa1;
	private String falsa2;
	private String solucion;
	
	public Pregunta(String texto, String correcta, String falsa1, String falsa2) {
		this.texto = texto;
		this.correcta = correcta;
		this.falsa1 = falsa1;
		this.falsa2 = falsa2;
		Pregunta.preguntas.add(this);
	}
		
	public static ArrayList<Pregunta> getListaPreguntas(){
		return Pregunta.preguntas;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public String[] getRespuestas() {
		String[] respuestas = new String[3];
		
		HashSet<Integer> posiciones = new HashSet<>();
		ArrayList<Integer> posiciones2 = new ArrayList<>();
		while (posiciones.size()!=3) {
			int azar = (int)(Math.random()*3);
			if(posiciones.add(azar) == true)
				posiciones2.add(azar);
			}
		//System.out.println(posiciones2);
		int i = 0;
		String[] letras = {"A) ", "B) ", "C) "};
		for(int n:posiciones2) {
			switch(n) {
			case 0:
				respuestas[i] = letras[i] + this.correcta;
				this.solucion = letras[i];
				break;
			case 1:
				respuestas[i] = letras[i] +  this.falsa1;
				break;
			case 2:
				respuestas[i] = letras[i] +  this.falsa2;
				break;
			}
			i++;
		}
		return respuestas;
	}
	
	public String getSolucion() {
		return this.solucion;
	}
}
