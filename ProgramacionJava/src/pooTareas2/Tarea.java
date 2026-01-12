package pooTareas2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

public class Tarea {
	private String titulo;
	private String descripcion;
	private String color;
	private LocalDate fecha;
	private boolean completada = false;
	
	//private static Tarea[] lista = null; 
	private static ArrayList<Tarea> lista = new ArrayList<>();
	
	public Tarea(String tit, String desc, String col) {
		titulo = tit;
		descripcion = desc;
		color = col;
		fecha = LocalDate.now();
		lista.add(this);
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
		Iterator<Tarea> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Tarea t = iterador.next();
			t.mostrar();
		}
		//for(Tarea tarea: lista)
		//	tarea.mostrar();
	}
	
	public void eliminarTarea() {
		if(lista.remove(this) == false)
			System.out.println("No puedo eliminar la tarea. No existe");
	}
}