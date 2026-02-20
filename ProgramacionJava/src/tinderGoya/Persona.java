package tinderGoya;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

abstract public class Persona {
	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected int edadMinima=18;
	protected int edadMaxima= 200;
	protected int queBusco; // 0 - no me importa, 1 - hombres, 2 - mujeres
	
	public Persona(String nombre, String nacimiento, int busco) {
		this.nombre = nombre;
		this.queBusco = busco;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.fechaNacimiento = 	LocalDate.parse(nacimiento, formato);
	}

	public Persona(String nombre, String nacimiento, int busco, int minimo, int maximo) {
		this(nombre, nacimiento, busco);
		if(minimo > 18)
			this.edadMinima = minimo;
		this.edadMaxima = maximo;
	}
	
	public int getEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		return periodo.getYears();
	}
	
	public void mostrarDatos() {
		System.out.printf("Nombre: %s. Edad: %d\n", this.nombre, this.getEdad());
		
		if(this instanceof Hombre)
			System.out.printf("Soy un hombre que busco ");
		else if (this instanceof Mujer)
			System.out.printf("Soy una mujer que busco ");
		else
			System.out.printf("No tengo una identidad sexual definida y busco ");
		
		if (this.queBusco == 0)
			System.out.printf("a una persona sin importarme su orientación\n");
		else if (this.queBusco == 1)
			System.out.printf("a un hombre\n");
		else
			System.out.printf("a una mujer\n");
		
		if(this.edadMinima == 18 && this.edadMaxima == 200)
			System.out.println("No tengo preferencias en cuanto a tu edad\n");
		else
			System.out.printf("Busco a una persona entre %d y %d años\n\n", this.edadMinima, this.edadMaxima);
	}
	
	public int getQueBusco() {
		return this.queBusco;
	}
	
	public boolean esMatch(Persona p) {
		boolean match = true;
		int edad1 = this.getEdad();
		int edad2 = p.getEdad();
		if(edad1 < p.edadMinima || edad1 > p.edadMaxima || edad2 < this.edadMinima || edad2 > this.edadMaxima)
			match = false;
		return match;
	}
}
