package pooProtectora;

public abstract class Animal {
	protected int nacimiento;
	protected boolean adoptado = false;
	String nombre = null;
	
	public Animal(int nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public Animal(int nacimiento, String nombre) {
		this.nacimiento = nacimiento;
		this.nombre = nombre;
	}
	
	public boolean getAdoptado() {
		return this.adoptado;
	}
	
	public void adoptado() {
		this.adoptado = true;
	}
}


