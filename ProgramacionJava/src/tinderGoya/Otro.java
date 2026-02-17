package tinderGoya;

public class Otro extends Persona{
	
	public Otro(Tinder app, String nombre, String nacimiento, int busco) {
		super(nombre, nacimiento, busco);
		app.anyade(this);
	}
	
	public Otro(Tinder app, String nombre, String nacimiento, int busco, int minimo, int maximo) {
		super(nombre, nacimiento, busco, minimo, maximo);
		app.anyade(this);
	}
}
