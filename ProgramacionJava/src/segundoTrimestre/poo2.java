package segundoTrimestre;

public class poo2 {

	public static void main(String[] args) {

		Pokemon p1 = new Pokemon("Bulbasaur");
		Pokemon p2 = new Pokemon("Venasaur");
		Pokemon p3 = new Pokemon ("Ivysaur");
		
		
		//hola
		p1.setEvolucion(p2);
		
		p2.setEvolucion(p3);
		
		p1.mostrar();
		
		p1 = p1.evoluciona();
		p1.mostrar();
		
		p1 = p1.evoluciona();
		p1.mostrar();
		
		p1 = p1.evoluciona();
		p1.mostrar();
		
		Pokemon p4 = new Pokemon("Pikachu");
		p4.combateContra(p1);
		p4.mostrar();
		p1.mostrar();
		p4.combateContra(p1);
	}

}
