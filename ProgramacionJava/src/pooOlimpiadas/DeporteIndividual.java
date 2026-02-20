package pooOlimpiadas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DeporteIndividual extends Deporte {

	private HashMap<Participante, Double> listaParticipantes = new HashMap<>();

	public DeporteIndividual(String nombre) {
		super(nombre);
	}

	public void resultado(Participante p, double marca) {
		if (this.listaParticipantes.containsKey(p)) {
			if (this.listaParticipantes.get(p) < marca)
				this.listaParticipantes.put(p, marca);
		} else
			this.listaParticipantes.put(p, marca);
	}

	public void obtenerPodium() {
		// for(Participante p: this.listaParticipantes.keySet())
		// System.out.printf("%s - %.2f\n", p.getNombre(),
		// this.listaParticipantes.get(p));
		System.out.printf("Medallero %s\n", this.nombre);
		System.out.println("----------------------------");
		// 1. hacemos una copia de la lista
		HashMap<Participante, Double> copia = new HashMap<>(this.listaParticipantes);

		// 2. buscamos el mayor
		// 3. lo imprimimos y lo borramos
		obtenerMedalla("ORO", copia);
		obtenerMedalla("PLATA", copia);
		obtenerMedalla("BRONCE", copia);
	}

	public void obtenerMedalla(String medalla, HashMap<Participante, Double> copia) {
		System.out.println(medalla);
		if (copia.size() != 0) {
			Participante p = obtenerMayor(copia);
			double mayor = copia.get(p);
			System.out.printf("%s con %.2f puntos\n", p.getNombre(), mayor);
			copia.remove(p);
			Iterator <Map.Entry<Participante, Double>> iterador = copia.entrySet().iterator();
			while(iterador.hasNext()) {
				Map.Entry<Participante, Double> elemento = iterador.next();
				if(elemento.getValue() == mayor) {
					System.out.printf("%s con %.2f puntos\n", elemento.getKey().getNombre(), mayor);
					iterador.remove();
				}
			}
		} else
			System.out.println("No hay mas participantes en esta competición");
	}

	public Participante obtenerMayor(HashMap<Participante, Double> lista) {
		double mayor = -1;
		Participante pMayor = null;
		for (Participante p : lista.keySet())
			if (lista.get(p) > mayor) {
				mayor = lista.get(p);
				pMayor = p;
			}
		return pMayor;
	}

}
