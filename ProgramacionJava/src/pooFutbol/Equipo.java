package pooFutbol;

import java.util.HashSet;

public class Equipo {

	private String nombre;
	private int puntos = 0;
	private int partidosGanados = 0;
	private int partidosPerdidos = 0;
	private int partidosEmpatados = 0;
	private int golesAFavor = 0;
	private int golesEnContra = 0;
	private Entrenador entrenador;
	private HashSet<Jugador> alineacion = new HashSet<>();

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
		return nombre;
	}

	public int getPG() {
		return partidosGanados;
	}

	public int getPP() {
		return partidosPerdidos;
	}
	
	public int getPE() {
		return partidosEmpatados;
	}

	public int getPuntos() {
		return puntos;
	}

	public int getGF() {
		return golesAFavor;
	}

	public int getGC() {
		return golesEnContra;
	}
}
