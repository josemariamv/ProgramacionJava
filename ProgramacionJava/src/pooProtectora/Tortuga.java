package pooProtectora;

public class Tortuga extends Animal {
	private boolean terrestre;
	
	public Tortuga(int nacimiento, boolean terrestre) {
		super(nacimiento);
		this.terrestre = terrestre;
	}
	
	public Tortuga(int nacimiento, boolean terrestre, String nombre) {
		super(nacimiento, nombre);
		this.terrestre = terrestre;
	}
	
	public void datos() {
		System.out.print("- Año de nacimiento: " + this.nacimiento);
		if(this.terrestre)
			System.out.print(" / Terrestre");
		else
			System.out.print(" / Acuática");
		if(this.nombre !=null)
			System.out.println(" / Nombre: " + this.nombre);
		else
			System.out.println();
	}
}
