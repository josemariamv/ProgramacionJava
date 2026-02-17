package tinderGoya;

import java.util.ArrayList;
import java.util.HashSet;

public class Tinder {
	
	private HashSet<Hombre> listaHombres = new HashSet<>();
	private HashSet<Mujer> listaMujeres = new HashSet<>();
	private HashSet<Otro> listaOtros = new HashSet<>();
	
	public Tinder() {}
	
	public void anyade(Hombre hombre) {
		listaHombres.add(hombre);
	}
	
	public void anyade(Mujer mujer) {
		listaMujeres.add(mujer);
	}
	
	public void anyade(Otro otro) {
		listaOtros.add(otro);
	}
	
	public ArrayList<Persona> construirListaMatches(Hombre hombre) {
		ArrayList<Persona> matches = new ArrayList<>();
		
		if(hombre.getQueBusco() == 0) {
			for(Hombre h:this.listaHombres)
				if(h.getQueBusco()!=2 && hombre.esMatch(h)== true && h!=hombre)
					matches.add(h);
			for(Mujer m:this.listaMujeres)
				if(m.getQueBusco()!=2 && hombre.esMatch(m)== true )
					matches.add(m);
			for(Otro o:this.listaOtros)
				if(o.getQueBusco()!=2 && hombre.esMatch(o)== true )
					matches.add(o);
		}else if(hombre.getQueBusco() == 1) {
			for(Hombre h:this.listaHombres)
				if(h.getQueBusco()!=2 && hombre.esMatch(h)== true && h!=hombre)
					matches.add(h);	
		}else { // queBusco == 2
			for(Mujer m:this.listaMujeres)
				if(m.getQueBusco()!=2 && hombre.esMatch(m)== true )
					matches.add(m);
		}
		return matches;
	}
	
	public void buscaMatches(Hombre hombre) {
		ArrayList<Persona> matches = new ArrayList<>();
		matches = construirListaMatches(hombre);
		// finalmente hago el listado de matches
		if(matches.size() == 0)
			System.out.println("Lo siento, pero no hay ningún perfil que haga match contigo");
		else
			for(Persona persona:matches)
				persona.mostrarDatos();
	}
	
	public void buscaMatchAzar(Hombre hombre) {
		ArrayList<Persona> matches = new ArrayList<>();
		matches = construirListaMatches(hombre);
		int azar = (int)(Math.random()*matches.size());
		matches.get(azar).mostrarDatos();
	}
	
	// falta por desarrollar la búsqueda en Mujeres y no definidos/as
	// y tratar de encontrar coincidencias, si puede ser, para no duplicar código
	
	public static void buscaMatches(Mujer mujer) {
		
	}
	
	public static void buscaMatches(Otro otro) {
		
	}

}
