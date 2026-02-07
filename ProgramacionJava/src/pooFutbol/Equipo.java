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

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public int getPuntos() {
		return puntos;
	}

	public int getGolesAFavor() {
		return golesAFavor;
	}

	public int getGolesEnContra() {
		return golesEnContra;
	}
}
