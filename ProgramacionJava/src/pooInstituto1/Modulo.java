package pooInstituto1;

public class Modulo {
	private String nombre;
	private int horasSemana;
	private int curso;
	private boolean optativa;
	
	public Modulo(String nombre, int horasSemana, int curso, boolean optativa) {
		this.nombre = nombre;
		this.horasSemana = horasSemana;
		this.curso = curso;
		this.optativa = optativa;
	}
	
	public int getCurso() {
		return this.curso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
