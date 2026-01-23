package pooAutoescuela;

import java.util.ArrayList;

public class Pregunta {
	
	private static ArrayList<Pregunta> preguntas = new ArrayList<>();
	private String texto;
	private String correcta;
	private String falsa1;
	private String falsa2;
	
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
}
