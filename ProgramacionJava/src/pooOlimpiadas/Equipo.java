package pooOlimpiadas;

import java.util.HashSet;

public class Equipo {

	private String nacionalidad;
	private DeporteEquipo deporte;
	private HashSet<Participante> listaParticipantes = new HashSet<>();
	
	public Equipo(String nacionalidad, DeporteEquipo deporte) {
		this.nacionalidad = nacionalidad;
		this.deporte = deporte;
	}
	
	public void anyadeParticipante(Participante p) {
		if(p.getNacionalidad().equals(this.nacionalidad) == false)
			System.out.printf("El jugador %s no puede participar en el equipo de %s de %s porque "
					+ "su nacionalidad es %s\n",p.getNombre(), this.deporte.getNombre(), 
					this.nacionalidad, p.getNacionalidad());
		else
			listaParticipantes.add(p);
	}
}
