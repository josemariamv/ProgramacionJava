package pooProtectora;

public class Main {

	public static void main(String[] args) {
		// Como siempre, procuramos que nuestro programa sea limpio y legible a simple vista
		// y escondemos toda la complejidad en los métodos de las diferentes clases
		Protectora goya = new Protectora();
		Perro p1 = goya.nuevoPerro(2024, true, "Tobi");
		Perro p2 = goya.nuevoPerro(2025, false);
		Gato g1 = goya.nuevoGato(2022, true, "Tita");
		Tortuga t1 = goya.nuevaTortuga(2013, false, "Tomasa");
		Tortuga t2 = goya.nuevaTortuga(2000, true, "Antonia");
		goya.listarNoAdoptados();
		
		Cliente c1 = new Cliente("José María", "Morales Vázquez", 57, 655112233, "Gatos");
		c1.adopta(g1);
		c1.adopta(t1);
		c1.adopta(t2);
		c1.listaAdoptados();
		
		goya.listarNoAdoptados();
	}

}
