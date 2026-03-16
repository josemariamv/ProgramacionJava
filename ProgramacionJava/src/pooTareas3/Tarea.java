package pooTareas3;

import java.util.ArrayList;

public class Tarea {
	private String id;
	private String titulo;
	private int prioridad;
	private boolean completada;
	
	private static ArrayList<Tarea> listaTareas = new ArrayList<>();
	
	public Tarea(String id, String titulo, int prioridad, boolean completada) {
		this.id = id;
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.completada = completada;
		Tarea.listaTareas.add(this);
	}
	
	public static void leerFicheroTareas(String fichero) {
		
	}
}
