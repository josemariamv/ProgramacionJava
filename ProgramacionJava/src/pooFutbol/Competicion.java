package pooFutbol;

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
		
	}
	
}
