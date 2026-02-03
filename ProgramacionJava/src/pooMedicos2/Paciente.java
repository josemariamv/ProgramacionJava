package pooMedicos2;

import java.util.HashMap;

public class Paciente extends Persona{
	
	private HashMap<String, Medico> listaCitas = new HashMap<>();
	
	public Paciente(String nombre) {
		super(nombre);
	}
	
	public void pideCita(Especialidad especialidad) { 
		// miramos en el diccionario asociado al paciente si ya tiene una cita de esa especialidad
		// es fácil, porque guardamos la cita en un diccionario donde la clave es la especialidad
		if(this.listaCitas.containsKey(especialidad.getNombre())) {
			Medico medico = listaCitas.get(especialidad.getNombre());
			System.out.println("\nEste paciente ya tiene una cita para la especialidad " 
					+ especialidad.getNombre() + " con " + medico.getNombre());
		}
		// si no tiene cita para esa especialidad consultamos si hay médicos para esa especialidad
		// si no hay, no podemos darle cita
		else if (especialidad.numMedicos() == 0)
			System.out.println("\nNo hay médicos de la especialidad " + especialidad.getNombre());
		else{
			// si hay médicos en la especialidad, vamos a ver a quién le asignamos la cita según las normas que hemos dado
			// eso lo calculamos con el método getMedico. Ver detalles allí
			Medico medico = especialidad.getMedico();
			medico.incrementaContadorCitas();
			// y añadimos la cita al diccionario del paciente
			listaCitas.put(especialidad.getNombre(), medico);
			System.out.println("Cita asignada para la especialidad de " + especialidad.getNombre() 
					+ " con " + medico.getNombre());
		}
	}
	
}
