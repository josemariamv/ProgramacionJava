package pooMedicos;

public class Medico extends Persona{
	private String especialidad;
	private String codigo;
	
	
	public Medico(String nombre, String apellidos, String especialidad, String codigo, Centro centro) {
		super(nombre, apellidos, centro);
		this.especialidad = especialidad;
		this.codigo = codigo;
		this.centro.anyadeMedico(this);
	}
	
	public void cambiaCentro(Centro c){
		this.centro.eliminaMedico(this);
		this.centro = c;
		this.centro.anyadeMedico(this);
		}
	}
