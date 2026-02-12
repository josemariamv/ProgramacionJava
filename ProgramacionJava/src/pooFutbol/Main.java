package pooFutbol;

import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Competicion laLiga = new Competicion("La Liga eaSports");
		
		Equipo elMadrid = new Equipo("Real Madrid FC");
		Equipo Betis = new Equipo("Real Betis CF");
		Equipo Barca = new Equipo("Barcelona FC");
		Equipo Atleti = new Equipo("Atlético de Madrid");
		Equipo Rayo = new Equipo("Rayo Vallecano");
		Equipo Sevilla = new Equipo("Sevilla");
		
		HashSet<Equipo> listaEquipos = new HashSet<>(List.of(Barca, Atleti, Rayo, Sevilla));
		
		laLiga.anyadeEquipo(elMadrid);
		laLiga.anyadeEquipo(Betis);
		laLiga.anyadeEquipos(listaEquipos);
		
		Jugador jugador1 = new Jugador("Messi", 12, elMadrid);
		Jugador jugador2 = new Jugador("Ronaldo");
		Entrenador entrenador1 = new Entrenador("Simeone", elMadrid);
		
		Arbitro arbitro1 = new Arbitro("Alexandru");
		Arbitro arbitro2 = new Arbitro("Andrea");
		Arbitro arbitro3 = new Arbitro("Jorge");
		
/* Por terminar: crear el objeto jornada que haga los emparejamientos
		Jornada j1 = new Jornada(laLiga);
		
		j1.resultadosPartido(1,0,3);
		j1.resultadosPartido(2,5,0);
		j1.resultadosPartido(3,2,2);
*/		
		Partido p1 = new Partido(elMadrid, Betis);
		Partido p2 = new Partido(Barca, Sevilla);
		Partido p3 = new Partido(Rayo, Atleti);	
		p1.resultado(0, 3);
		p2.resultado(5, 0);
		p3.resultado(2, 2);
		
		laLiga.verClasificacion();
		
	}
}

