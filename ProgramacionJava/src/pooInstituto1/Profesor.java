package pooInstituto1;

public class Profesor extends Persona{
	private Grupo tutorDe = null;
	private String departamento = null;
	
	public Profesor(String nombre, String apellidos, String departamento) {
		super(nombre, apellidos);
		if(!departamento.equalsIgnoreCase("Informática") && !departamento.equalsIgnoreCase("Inglés") && !departamento.equalsIgnoreCase("Empresa"))
			System.out.println("ERROR: Departamento no válido");
		else
			this.departamento = departamento.toUpperCase();
	}
	
	public void setTutoria(Grupo grupo) {
		this.tutorDe = grupo;
	}
	
}


