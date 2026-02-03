package pooMedicos2;

public class Main {
	public static void main(String[] args) {
		Especialidad especialidad1 = new Especialidad("Traumatología");
		Especialidad especialidad2 = new Especialidad("Urología");
		Especialidad especialidad3 = new Especialidad("Dermatología");
		Especialidad especialidad4 = new Especialidad("Oftalmología");

		Medico medico1 = new Medico(especialidad1, "Jorge Pérez");
		Medico medico2 = new Medico(especialidad1, "Ana López");
		Medico medico3 = new Medico(especialidad3, "Elena García");
		
		Paciente paciente1 = new Paciente("Antonio Costa");
		Paciente paciente2 = new Paciente("Inés Rodrigo");
		Paciente paciente3 = new Paciente("Andrés Robles");

		paciente1.pideCita(especialidad3); // HECHO! le da cita con el único médico de esa especialidad
		paciente1.pideCita(especialidad1); // HECHO! le da cita con uno de los dos médicos, al azar, de esa especialidad
		paciente2.pideCita(especialidad2); // HECHO! le dice que no hay médicos que atiendan esa especialidad
		paciente2.pideCita(especialidad1); // HECHO! le da cita con el médico de esa especialidad que tiene menos trabajo
		paciente1.pideCita(especialidad3); // HECHO! le dice que ya tiene cita con un médico de esa especialidad
		paciente2.pideCita(especialidad3); // HECHO! le dice que ya tiene cita con un médico de esa especialidad
		paciente3.pideCita(especialidad1);
		
		especialidad1.listarMedicos();
		especialidad2.listarMedicos();
		especialidad3.listarMedicos();
	}
}