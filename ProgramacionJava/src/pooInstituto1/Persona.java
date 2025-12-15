package pooInstituto1;

abstract class Persona {
	protected String nombre;
	protected String apellidos;
	
	public Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public String getNombre() {
		return this.apellidos + ", " + this.nombre;
	}
}


