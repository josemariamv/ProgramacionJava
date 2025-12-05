package segundoTrimestre;

public class Poo2 {

	public static void main(String[] args) {

        Pokemon p1 = new Pokemon(1, "Bulbasaur", "Planta");
		Pokemon p2 = new Pokemon(6, "Charizard", "Fuego", "Volador");
		Pokemon p3 = new Pokemon(2, "Ivysaur", "Planta");
		Pokemon p4 = new Pokemon(25, "Pikachu", "Eléctrico");
		Pokemon p5 = new Pokemon(11, "Metapod", "Bicho");
		Pokemon p6 = new Pokemon(7, "Squirtle", "Agua");
		
		p1.setEvolucion(p2);
		p2.setEvolucion(p3);
		
		p1.mostrar();
		
		p1 = p1.evoluciona();
		p1.mostrar();
		
		p1 = p1.evoluciona();
		p1.mostrar();
		
		p1 = p1.evoluciona();
		p1.mostrar();
		
		p4.combateContra(p1);
		p4.mostrar();
		p1.mostrar();
		p4.combateContra(p1);

		Equipo equipo1 = new Equipo("José María", p1, p2, p4);
		Equipo equipo2 = new Equipo("Ash Ketchum", p3, p5, p6);
		
		p3.combateContra(p5);
		p6.combateContra(p4);
		
		//equipo2.mostrar();
		
		PokemonLegendario l1 = new PokemonLegendario(151, "Mew", "Psiquico");
		l1.mostrar();

	}

}
