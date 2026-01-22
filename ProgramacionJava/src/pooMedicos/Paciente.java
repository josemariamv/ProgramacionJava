package pooMedicos;

public class Paciente extends Persona{
	private long telefono;
	private String dni;
	
	public Paciente(String nombre, String apellidos, String dni, long telefono, Centro centro) {
		super(nombre, apellidos, centro);
		this.telefono = telefono;
		this.dni = dni;
		this.centro.anyadePaciente(this);
	}
	
	public void cambiaCentro(Centro c){
		this.centro.eliminaPaciente(this);
		this.centro = c;
		this.centro.anyadePaciente(this);
		}
}
