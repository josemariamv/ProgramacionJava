package pooSeguridadSocial;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona implements Baja, Jubilacion, Accidente {
	private String nombre;
	private String apellidos;
	private int anyosCotizados = 0;
	private LocalDate fechaNacimiento;
	private LocalDate fechaBaja = null;
	private LocalDate fechaJubilacion = null;
	private LocalDate fechaFallecimiento = null;

	public Persona(String nom, String ape, LocalDate nacimiento, int anyos) {
		this.nombre = nom;
		this.apellidos = ape;
		this.fechaNacimiento = nacimiento;
		this.anyosCotizados = anyos;
	}

	public Persona(String nom, String ape, LocalDate nacimiento) {
		this.nombre = nom;
		this.apellidos = ape;
		this.fechaNacimiento = nacimiento;
	}

	@Override
	public String toString() {
		String linea1 = "Cotizante: " + this.apellidos + ", " + this.nombre + "\n";
		String linea2 = "";
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if(this.fechaFallecimiento !=null) {
			String fechaFormateada = this.fechaFallecimiento.format(formato);
			linea2 = "Estado: fallecido. Fecha de defunción: " + fechaFormateada + "\n";
		}
		else if(this.fechaJubilacion !=null) {
			String fechaFormateada = this.fechaJubilacion.format(formato);
			linea2 = "Estado: jubilado. Fecha de jubilación: " + fechaFormateada + "\n";
		}
		else  if(this.fechaBaja !=null) {
			String fechaFormateada = this.fechaBaja.format(formato);
			linea2 = "Estado: de Baja. Fecha de Baja: " + fechaFormateada + "\n";
		}else
			linea2 = "Estado: en Activo\n";
			
		return linea1 + linea2;
	}
}
