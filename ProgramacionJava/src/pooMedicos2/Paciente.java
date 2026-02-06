package pooMedicos2;

import java.util.HashMap;

public class Paciente extends Persona{
	
	// AQUÍ HAY QUE CAMBIAR PARA INTRODUCIR LA CITA
	private HashMap<String, Cita> listaCitas = new HashMap<>();
	
	public Paciente(String nombre) {
		super(nombre);
	}
	
	public void pideCita(Especialidad especialidad) { 
		// miramos en el diccionario asociado al paciente si ya tiene una cita de esa especialidad
		// es fácil, porque guardamos la cita en un diccionario donde la clave es la especialidad
		if(this.listaCitas.containsKey(especialidad.getNombre())) {
			// AQUÍ HAY QUE CAMBIAR PARA INTRODUCIR LA CITA
			Cita cita = listaCitas.get(especialidad.getNombre());
			System.out.println("\nEste paciente ya tiene una cita para la especialidad " 
					+ especialidad.getNombre() + " con " + cita.getMedico().getNombre() + 
					" el día " + cita.getFechaCita());
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
			Cita cita = new Cita(medico);
			// y añadimos la cita al diccionario del paciente
			// AQUÍ HAY QUE CAMBIAR PARA INTRODUCIR LA CITA
			listaCitas.put(especialidad.getNombre(), cita);
			System.out.println("Cita asignada para la especialidad de " + especialidad.getNombre() 
					+ " con " + medico.getNombre());
		}
	}
	
	public void anulaCita(Especialidad especialidad) {
		if(this.listaCitas.containsKey(especialidad.getNombre())) {
			// tiene cita. puedo borrarla
			Cita cita = listaCitas.remove(especialidad.getNombre());
			cita.getMedico().decrementaContadorCitas();
			System.out.println("\nLa cita con el médico " + cita.getMedico().getNombre() 
					+ " del día " + cita.getFechaCita() + " ha sido eliminada.");
		}
		else {
			// no tiene cita. no puedo borrarla. lo informo
			System.out.println("\nNo tiene cita con ningún médico de la especialidad " 
					+ especialidad.getNombre());
		}
			
	}
	
}
