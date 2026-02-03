package pooMedicos2;

import java.util.ArrayList;
import java.util.Collections;

public class Especialidad {

	private String nombre;
	private ArrayList<Medico> listaMedicos = new ArrayList<>();

	public Especialidad(String nombre) {
		this.nombre = nombre;
	}

	public void nuevoMedico(Medico medico) {
		this.listaMedicos.add(medico);
	}

	public void listarMedicos() {
		System.out.println("\nMédicos de la especialidad: " + this.nombre);
		if (this.listaMedicos.size() == 0)
			System.out.println("No hay ningún médico de esta especialidad");
		else
			for (Medico medico : this.listaMedicos)
				System.out.println(medico.getNombre() + "(" + medico.getContadorCitas() + ")");
	}
	
	public int numMedicos() {
		return this.listaMedicos.size();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Medico getMedico() {
		Medico medico = null;
		// Si solo hay un médico en la especialidad, le damos al paciente cita con el
		if(this.listaMedicos.size() == 1)
			medico = listaMedicos.get(0);
		// Si hay mas de uno procedemos como sigue:
		else {
			// 1 - Buscamos cual es el menor número de citas de un médico. Puede haber varios médicos que empaten. Eso lo resolvemos en el paso 2
			int menor = Integer.MAX_VALUE;
			for(Medico m:listaMedicos)
				if(m.getContadorCitas()< menor)
					menor = m.getContadorCitas();
			// 2 - Encontamos cuantos médicos tienen ese número de citas. Tiene que haber uno mínimo. Los metemos todos en un ArrayList
			ArrayList<Medico> medicosConMenosCitas = new ArrayList<>();
			for(Medico m:listaMedicos)
				if(m.getContadorCitas() == menor)
					medicosConMenosCitas.add(m);
			// 3 - Para elegir con cual damos la cita mezclamos el array de forma aleatoria y elegimos el primero.
			// Esto debería de funcionar tanto si hay uno solo como si hay varios
			Collections.shuffle(medicosConMenosCitas);
			medico = medicosConMenosCitas.get(0);
		}
		return medico;
	}
}
