package pooOlimpiadas;

public abstract class Deporte {
	protected String nombre;
	
	public Deporte(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
