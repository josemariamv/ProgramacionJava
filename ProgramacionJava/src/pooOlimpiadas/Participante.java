package pooOlimpiadas;

public class Participante {

	private String nombre;
	private String nacionalidad;
	
	public Participante(String nombre, String nacionalidad) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		}
	
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
