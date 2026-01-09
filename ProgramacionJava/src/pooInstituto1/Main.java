package pooInstituto1;

public class Main {

	public static void main(String[] args) {
		Profesor profe1 = new Profesor("José María", "Morales Vázquez", "Informática");
		Profesor profe2 = new Profesor("Pepa", "Cano", "Filosofía");
		
		Alumno alumno1 = new Alumno("Mario", "Carcalete", 17);
		Alumno alumno2 = new Alumno("Andrea", "Coronado", 24);
		Alumno alumno3 = new Alumno("Pepe", "Potamo", 43);
		
		Modulo programacion = new Modulo("Programación", 8, 1, false);
		Modulo fundamentos = new Modulo("Fundamentos de Programación", 2, 1, true);
		Modulo python = new Modulo("Programación en Python", 3, 2, true);
		
		Ciclo dam = new Ciclo("Desarrollo de Aplicaciones Multiplataforma", "SUPERIOR");
		dam.anyadeModulo(programacion);
		dam.anyadeModulo(fundamentos);
		dam.anyadeModulo(python);
		
		Grupo dam1 = new Grupo("DAM1", dam, 1, 4);
		dam1.anyadeTutor(profe1);
		dam1.anyadeAlumno(alumno1);
		dam1.anyadeAlumno(alumno2);
		dam1.anyadeAlumno(alumno3);
		
		dam1.verGrupo();
	}
}
