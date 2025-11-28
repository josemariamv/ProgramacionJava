package segundoTrimestre;

public class Persona {
	private String nombre;
	private String apellidos;
	private int edad = -1;
	
	public Persona(String nom, String ape) {
		this.nombre = nom;
		this.apellidos = ape;
	}
	
	public void mostrar() {
		System.out.println(apellidos + ", " + nombre);
	}

}
