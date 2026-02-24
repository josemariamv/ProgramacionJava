package pooPaqueteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paquete {

	private static ArrayList<Paquete> listaPaquetes = new ArrayList<>();

	private Localizacion direccion;
	private double peso;

	public Paquete(double peso, int x, int y) {
		this.direccion = new Localizacion(x, y);
		this.peso = peso;
		Paquete.listaPaquetes.add(this);
	}

	public static Paquete destinoMasCercano(Localizacion punto) {
		HashMap<Paquete, Double> distancias = new HashMap<>();
		Paquete destino = null;
		if (Paquete.listaPaquetes.size() != 0) {
			for (Paquete paquete : Paquete.listaPaquetes) {
				// por cada paquete, calculo la distancia usando la funcion que hice ayer
				double distancia = punto.distancia(paquete.direccion);
				// y meto en el diccionario una entrada nueva con el paquete y su distancia
				distancias.put(paquete, distancia);
			}
			// al final devuelvo el paquete con menor distancia
			double minimo = Double.MAX_VALUE;
			for(Map.Entry<Paquete,Double> entrega : distancias.entrySet()){
				if(entrega.getValue()< minimo) {
					minimo = entrega.getValue();
					destino = entrega.getKey();
				}
			}
		}
		// no olvides comprobar en algun momento que la lista de paquetes no está vacía!
		return destino;
	}

	public int getX() {
		return direccion.getX();
	}

	public int getY() {
		return direccion.getY();
	}
	
	public Localizacion getLocalizacion() {
		return direccion;
	}
	
	public static void borrarDestino(Paquete entrega) {
		Paquete.listaPaquetes.remove(entrega);
	}
}
