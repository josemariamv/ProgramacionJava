package pooPaqueteria;

public class Localizacion {
	
	private int x;
	private int y;
	
	public Localizacion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Localizacion destino) {
		int cateto1 = this.x - destino.x;
		int cateto2 = this.y - destino.y;
		return(Math.hypot(cateto1, cateto2));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
