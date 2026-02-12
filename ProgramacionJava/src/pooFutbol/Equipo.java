package pooFutbol;

import java.util.HashSet;

public class Equipo {
	
	private String nombre;
	private Entrenador entrenador;
	private HashSet<Jugador> alineacion = new HashSet<>();
	private int partidosGanados = 0;
	private int partidosEmpatados = 0;
	private int partidosPerdidos = 0;
	private int golesAFavor = 0;
	private int golesEnContra = 0;
	private int puntos = 0;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	public void anyadeJugador(Jugador jugador) {
		this.alineacion.add(jugador);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public int getPG() {
		return this.partidosGanados;
	}
	
	public int getPE() {
		return this.partidosEmpatados;
	}
	
	public int getPP() {
		return this.partidosPerdidos;
	}
	
	public int getGF() {
		return this.golesAFavor;
	}
	
	public int getGC() {
		return this.golesEnContra;
	}
	
	public void ganaPartido() {
		this.partidosGanados++;
		this.puntos+=3;
	}
	
	public void pierdePartido() {
		this.partidosPerdidos++;
	}
	
	public void empataPartido() {
		this.partidosEmpatados++;
		this.puntos++;
	}
	
	public void cambiaGoles(int aFavor, int enContra) {
		this.golesAFavor+=aFavor;
		this.golesEnContra+=enContra;
	}
}
