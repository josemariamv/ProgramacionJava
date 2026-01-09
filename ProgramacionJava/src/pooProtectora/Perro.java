package pooProtectora;

public class Perro extends Animal {
	private boolean vacunado;
	
	public Perro(int nacimiento, boolean vacunado) {
		super(nacimiento);
		this.vacunado = vacunado;
	}
	
	public Perro(int nacimiento, boolean vacunado, String nombre) {
		super(nacimiento, nombre);
		this.vacunado = vacunado;
	}
	
	public void datos() {
		System.out.print("- Año de nacimiento: " + this.nacimiento + " / Vacunado: ");
		if(this.vacunado)
			System.out.print("Si");
		else
			System.out.print("No");
		if(this.nombre !=null)
			System.out.println(" / Nombre: " + this.nombre);
		else
			System.out.println();
	}
	
}
