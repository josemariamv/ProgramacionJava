package pooOlimpiadas;

public class Main {

	public static void main(String[] args) {
		Participante j1 = new Participante("Boris", "Rusia");
		Participante j2 = new Participante("Svenlanj", "Noruega");
		Participante j3 = new Participante("Manolo", "España");
		Participante j4 = new Participante("Angél", "Filipinas");
		Participante j5 = new Participante("Richard", "Brasil");
		Participante j6 = new Participante("Mauro", "Perú");
		
		DeporteIndividual d1 = new DeporteIndividual("Snowboard");
		DeporteEquipo d2 = new DeporteEquipo("Curling");
		DeporteEquipo d3 = new DeporteEquipo("Hockey");
		
		Equipo e1 = new Equipo("Rusia", d2);
		Equipo e2 = new Equipo("España", d3);
		
		e1.anyadeParticipante(j1);
		e1.anyadeParticipante(j2); // este debería de fallar
		e2.anyadeParticipante(j3);
		
		d1.resultado(j1, 45.4);
		d1.resultado(j2, 32.14);
		d1.resultado(j3, 55.67);
		d1.resultado(j4,51.33);
		d1.resultado(j3, 57.67); // es mayor. sobreescribimos la anterior
		d1.resultado(j4,41.33); // es menor. nos quedamos con la anterior
		d1.resultado(j5, 51.33);
		d1.resultado(j6, 51.33);
		
		d1.obtenerPodium();

	}

}

