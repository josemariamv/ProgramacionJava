package pooMedicos2;

import java.util.ArrayList;

public class Medico extends Persona{
	
	private Especialidad especialidad;
	private ArrayList<Paciente> listaEspera = new ArrayList<>();
	private  int contadorCitas = 0;
	
	public Medico(Especialidad especialidad, String nombre) {
		super(nombre);
		this.especialidad = especialidad;
		especialidad.nuevoMedico(this);
	}
	
	public int getContadorCitas() {
		return this.contadorCitas;
	}
	
	public void incrementaContadorCitas() {
		this.contadorCitas++;
	}
	
	public void decrementaContadorCitas() {
		this.contadorCitas--;
	}
	
}
