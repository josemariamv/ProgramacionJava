package pooSeguridadSocial;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate f1 = LocalDate.of(1968, 10, 8);
		LocalDate f2 = LocalDate.of(1975, 12, 1);
		
		Persona p1 = new Persona("José María", "Morales Vázquez", f1, 37);
		Persona p2 = new Persona("Pepe", "Potamo", f2);
		
		System.out.println(p1);
		p1.consultaJubilacion();
		
	}

}
