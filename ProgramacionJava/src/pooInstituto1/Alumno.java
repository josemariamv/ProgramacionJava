package pooInstituto1;

public class Alumno extends Persona{
	private int edad;
	private boolean mayordeEdad = false;
	
	public Alumno(String nombre, String apellidos, int edad) {
		super(nombre, apellidos);
		if(this.edad>=18)
			mayordeEdad = true;
	}

}
