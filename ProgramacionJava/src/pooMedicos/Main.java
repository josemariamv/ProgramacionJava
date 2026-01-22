package pooMedicos;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Centro vicalvaro = new Centro("Villablanca", "CM-2233");
		Centro moratalaz = new Centro("El Torito", "CM-3456");
		
		Medico m1 = new Medico("Inés", "Perado", "dentista", "123456", vicalvaro);
		Medico m2 = new Medico("Ricardo", "Borriquero", "traumatologo", "789012", vicalvaro);
		Medico m3 = new Medico("Pepe", "Potamo", "obstetricia", "555666", moratalaz);
		
		Paciente p1 = new Paciente("José María", "Morales", "22333444X", 655112233, vicalvaro);
		Paciente p2 = new Paciente("Víctor", "Durán", "44555666H", 912233444, moratalaz);
		
		p2.cambiaCentro(vicalvaro);
		
		new Consulta(p1,m1,LocalDate.now(),"Le duele la cabeza", "Que tome Paracetamol");
		new Consulta(p1,m2,LocalDate.now(),"Le duele la tripa", "Un día a dieta blanda");
		new Consulta(p1,m1,LocalDate.now(),"Estreñido", "Que tome fibra");
		new Consulta(p2,m1,LocalDate.now(),"Se rompe un brazo", "Se deriva al hospital");
		
		p1.listaConsultas();
	}

}


