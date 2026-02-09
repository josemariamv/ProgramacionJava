package pooFutbol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
		// 1. Cabecera de la tabla
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yy");
		String fechaDeHoy = fecha.format(formato);
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.println(" La Liga eaSport. Clasificación a día "+ fechaDeHoy);
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf(" %-25s | %3s | %2s | %2s | %2s | %2s | %2s | %2s | %3s%n", "EQUIPO", "PTs", "PJ", "PG", "PE", "PP", "GF",
				"GC", "DIF");
		System.out.println("-----------------------------------------------------------------------");
		// 2. Convertimos el HashSet a una Lista y la ordenamos
		// 2.1 Método de selección
		
		// 2.2 Método de la burbuja
		
		// 3. Imprimir cada fila
		for (Equipo e : listaEquipos) {
			int difGoles = e.getGolesAFavor() - e.getGolesEnContra();
			int partidosJugados = e.getPartidosGanados() + e.getPartidosEmpatados() + e.getPartidosPerdidos();
			System.out.printf(" %-25s | %3d | %2d | %2d | %2d | %2d | %2d | %2d | %3d%n", e.getNombre(), e.getPuntos(), partidosJugados, 
					e.getPartidosGanados(), e.getPartidosEmpatados(), e.getPartidosPerdidos(), e.getGolesAFavor(),
					e.getGolesEnContra(), difGoles);
		}
		System.out.println("-----------------------------------------------------------------------");
	}
}
