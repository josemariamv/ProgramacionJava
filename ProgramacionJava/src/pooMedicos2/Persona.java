package pooMedicos2;

abstract public class Persona {
	protected String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
