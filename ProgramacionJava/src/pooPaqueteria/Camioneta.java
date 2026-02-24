package pooPaqueteria;

public class Camioneta {

	private static Localizacion almacen = new Localizacion(0, 0);
	private double peso;
	private double kilometros;
	private Ruta ruta = new Ruta();

	public Camioneta(double peso, double kilometros) {
		this.peso = peso;
		this.kilometros = kilometros;
	}

	public void calcularRuta() {
		Paquete destino = Paquete.destinoMasCercano(almacen);
		int peso = 0;
		int distancia = 0;
		while (destino != null) {
			ruta.anyadirEntrega(destino);
			Localizacion nuevoOrigen = destino.getLocalizacion();
			Paquete.borrarDestino(destino);
			destino = Paquete.destinoMasCercano(nuevoOrigen);
		}
	}

	public void mostrarRuta() {
		ruta.mostrarRuta();
	}
}
