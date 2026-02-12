package pooFutbol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

public class Competicion {

	private String nombre;
	private HashSet<Equipo> listaEquipos = new HashSet<>();

	public Competicion(String nombre) {
		this.nombre = nombre;
	}

	public void anyadeEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}

	public void anyadeEquipos(HashSet<Equipo> equipos) {
		listaEquipos.addAll(equipos);
	}

	public void verClasificacion() {
		// cabecera de la clasificacion
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yy");
		String fechaDeHoy = fecha.format(formato);
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" Competición: " + this.nombre + " Clasificación a día " + fechaDeHoy);
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-25s | %3s | %2s | %2s | %2s | %2s | %3s | %3s\n", " EQUIPO", "Pts", "PJ", "PG", "PE", "PP",
				"GF", "GC");
		System.out.println("-----------------------------------------------------------------");

		// ordenar la lista de equipos
		ArrayList<Equipo> listaEquiposOrdenada = new ArrayList<Equipo>();
		listaEquiposOrdenada = this.ordenarClasificacion();
		// mostrar cada equipo de la lista
		for (Equipo e : listaEquiposOrdenada) {
			int PJ = e.getPG() + e.getPP() + e.getPE();
			System.out.printf("%-25s | %3d | %2d | %2d | %2d | %2d | %3d | %3d\n", e.getNombre(), e.getPuntos(), PJ,
					e.getPG(), e.getPE(), e.getPP(), e.getGF(), e.getGC());
		}
	}

	public ArrayList<Equipo> ordenarClasificacion() {
		ArrayList<Equipo> ordenada = new ArrayList<>();
		ArrayList<Equipo> desordenada = new ArrayList<>(this.listaEquipos);
		while (desordenada.size() != 0) {
			//int puntosMayor = -1;
			Equipo elQueMasPuntosTiene = null;
			for (Equipo equipo : desordenada)
				elQueMasPuntosTiene = decideCualVaAntes(equipo, elQueMasPuntosTiene);
			desordenada.remove(elQueMasPuntosTiene);
			ordenada.add(elQueMasPuntosTiene);
		}
		return ordenada;
	}

	public Equipo decideCualVaAntes(Equipo equipo1, Equipo equipo2) {
		Equipo elegido = null;
		if(equipo2 == null)
			elegido = equipo1;
		else if (equipo1.getPuntos() > equipo2.getPuntos()) {
			elegido = equipo1;
		} else if (equipo1.getPuntos() == equipo2.getPuntos()) {
			int dif1 = equipo1.getGF() - equipo1.getGC();
			int dif2 = equipo2.getGF() - equipo2.getGC();
			if (dif2 > dif1)
				elegido = equipo2;
			else
				elegido = equipo1;
		}else
			elegido = equipo2;
		return elegido;
	}
}
