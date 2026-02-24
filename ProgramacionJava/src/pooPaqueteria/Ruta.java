package pooPaqueteria;

import java.util.ArrayList;

public class Ruta {
	
	private ArrayList<Paquete> rutaPaquetes = new ArrayList<>();
	
	public Ruta() {
	}

	public void anyadirEntrega(Paquete entrega) {
		this.rutaPaquetes.add(entrega);
	}
	
	public void mostrarRuta() {
		int i = 1;
		for(Paquete p: rutaPaquetes) {
			System.out.printf("%d - La siguiente entrega está en la localización %d:%d\n", i, p.getX(), p.getY());
			i++;
		}
	}
}
