package pooFutbol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Competicion {
	
	private String nombre;
	private HashSet<Equipo> listaEquipos = new HashSet<>();
	
	public Competicion(String nombre) {
		this.nombre = nombre;
	}
	
	public void anyadeEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}
	
	public void anyadeEquipos(HashSet<Equipo> equipos) {
		listaEquipos.addAll(equipos);
	}
	
	public void verClasificacion() {
		// cabecera de la clasificacion
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yy");
		String fechaDeHoy = fecha.format(formato);
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" Competición: " + this.nombre + " - Clasificación a día " + fechaDeHoy);
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-25s | %3s | %2s | %2s | %2s | %2s | %3s | %3s\n", " EQUIPO", "Pts", 
				"PJ", "PG", "PE", "PP", "GF", "GC" );
		System.out.println("-----------------------------------------------------------------");
		// ordenar la lista de equipos
		
		// mostrar cada equipo de la lista
		for(Equipo e:listaEquipos) {
			int PJ = e.getPG() + e.getPP() + e.getPE();
			System.out.printf("%-25s | %3d | %2d | %2d | %2d | %2d | %3d | %3d\n", e.getNombre(),
					e.getPuntos(), PJ, e.getPG(), e.getPE(), e.getPP(), e.getGF(), e.getGC() );
		}
	}
	
}
