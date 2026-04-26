package pooSeguridadSocial;

import java.time.LocalDate;
import java.time.Period;
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
	
	@Override
	public void consultaJubilacion() {
		LocalDate hoy = LocalDate.now();
		Period edad = Period.between(this.fechaNacimiento, hoy);
		System.out.printf("%s, %s tiene %d años, %d meses y %d días\n", this.apellidos, this.nombre, edad.getYears(), edad.getMonths(), edad.getDays());
		System.out.printf("Ha cotizado durante %d años.  ", this.anyosCotizados);
		if(this.anyosCotizados >= Jubilacion.ANYOS_MINIMOS_COTIZADOS_100)
			System.out.println("Lo suficiente para percibir el 100% de su pensión de jubilación");
		else if(this.anyosCotizados >= Jubilacion.ANYOS_MINIMOS_COTIZADOS_100)
			System.out.println("Lo suficiente para percibir el 50% de su pensión de jubilación");
		else
			System.out.println("No ha cotizado lo suficiente para percibir una pensión de jubilación");
		if(edad.getYears() >= Jubilacion.EDAD_MINIMA_JUBILACION)
			System.out.println("Ha alcanzado la edad para jubilarse sin ninguna penalización");
		else
			System.out.printf("Le faltan %d años para poder jubilarse sin penalización\n", Jubilacion.EDAD_MINIMA_JUBILACION - edad.getYears());
		
	}
	
}
