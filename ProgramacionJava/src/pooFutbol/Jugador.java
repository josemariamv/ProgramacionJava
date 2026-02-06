package pooFutbol;

public class Jugador extends Persona{

	private Equipo equipo = null;
	private int dorsal = 0;
	
	public Jugador(String nombre, int dorsal, Equipo equipo) {
		super(nombre);
		this.equipo = equipo;
		this.dorsal = dorsal;
		
		this.equipo.anyadeJugador(this);
	}
	
	public Jugador(String nombre) {
		super(nombre);
	}
}
