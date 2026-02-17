package tinderGoya;

public class Mujer extends Persona{

	public Mujer(Tinder app, String nombre, String nacimiento, int busco) {
		super(nombre, nacimiento, busco);
		app.anyade(this);
	}
	
	public Mujer(Tinder app, String nombre, String nacimiento, int busco, int minimo, int maximo) {
		super(nombre, nacimiento, busco, minimo, maximo);
		app.anyade(this);
	}
}
