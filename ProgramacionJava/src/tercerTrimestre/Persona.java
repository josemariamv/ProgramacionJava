package tercerTrimestre;

import java.time.LocalDate;

public class Persona implements Fallecida, Jubilada, deBaja {
	
	private String nombre;
	private String apellidos;
	LocalDate fechaFallecimiento = null;
	LocalDate fechaBaja = null;
	LocalDate fechaJubilacion = null;
	
	public Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	@Override
	public void baja() {
		if(fechaJubilacion != null)
			System.out.println("No puedo darle/a de baja. Está jubilado/a");
		else if(fechaFallecimiento !=null)
			System.out.println("No puedo darle/a de baja. Ha fallecido");
		else if(fechaBaja !=null)
			System.out.println("Ya está de baja");
		else
			fechaBaja = LocalDate.now();
	}
	
	@Override
	public void alta() {
		if(fechaBaja == null)
			System.out.println("No puedo darle/a de alta. No está de baja");
		else
			fechaBaja = null;

	}
	
	@Override
	public void fallecida() {
		if(fechaFallecimiento!=null)
			System.out.println("Ya estaba muerto/a");
		else
			fechaFallecimiento = LocalDate.now();
	}
	
	@Override
	public void jubilada() {
		if(fechaFallecimiento !=null)
			System.out.println("No puede jubilarse. Está muerto/a");
		else {
			fechaJubilacion = LocalDate.now();
			fechaBaja = null;
		}
	}
}
