package pooTareas;

import java.time.LocalDate;
import java.util.Arrays;

public class Tarea {
	private String titulo;
	private String descripcion;
	private String color;
	private LocalDate fecha;
	private boolean completada = false;
	
	private static Tarea[] lista = null; 
	
	public Tarea(String tit, String desc, String col) {
		titulo = tit;
		descripcion = desc;
		color = col;
		fecha = LocalDate.now();
		if(lista == null) {
			// inicializo la lista con un elemento y copio en el la tarea
			lista = new Tarea[1];
			lista[0] = this;
		}
		else {
			// aumento en una posicion la lista y copio en el la tarea
			lista = Arrays.copyOf(lista, lista.length+1);
			lista[lista.length-1] = this;
		}
	}
	
	public void mostrar() {
		System.out.println(titulo + "(" + color + ")");
		System.out.println(descripcion);
		System.out.println("Fecha: " + fecha + " - Completada: " + completada);
		System.out.println("------------------------------------------------");
		
	}
	
	public void marcarComoCompletada() {
		completada = true;
	}
	
	public static void motrarTareasNoCompletadas() {
		for(Tarea tarea: lista)
			if(tarea.completada == false)
				tarea.mostrar();
		}
	
	public static void motrarTareas() {
		for(Tarea tarea: lista)
			tarea.mostrar();
	}
}
