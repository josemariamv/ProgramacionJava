package tercerTrimestre;

import java.io.Serializable;

// Para poder grabar los objetos en un fichero y darles persistencia tienen que ser Serializables
public class Pokemon implements Serializable{
	private int codigo;
	private String nombre;
	private String[] tipo = new String[2];
	protected int pv;
	private Pokemon evolucion = null;
	
	// Los datos estáticos, si los hubiera, no se guardan
	// Si quisiéramos que algún atributo no se guardara (por tener información sensible, por ejemplo)
	// lo definimos como transient:
	// private transient String password;

	public Pokemon(int c, String n, String t) {
		this.codigo = c;
		this.nombre = n;
		this.tipo[0] = t;
		this.pv = (int) ((Math.random() * 51) + 50);
	}

	public Pokemon(int c, String n, String t1, String t2) {
		this.codigo = c;
		this.nombre = n;
		this.tipo[0] = t1;
		this.tipo[1] = t2;
		this.pv = (int) ((Math.random() * 51) + 50);
	}

	public void mostrar() {
		System.out.println("------------------");
		System.out.println(this.codigo + " - " + this.nombre);
		if (this.tipo[1] == null)
			System.out.println("Tipo: " + this.tipo[0]);
		else
			System.out.println("Tipos: " + this.tipo[0] + ", " + this.tipo[1]);
		if (this.evolucion != null)
			System.out.println("Evoluciona en: " + this.evolucion.nombre);
		System.out.println("PV: " + this.pv);
		System.out.println("------------------");
	}

	public void setEvolucion(Pokemon p) {
		this.evolucion = p;
	}

	public Pokemon evoluciona() {
		Pokemon pokemon = this;
		if (this.evolucion == null)
			System.out.println("Este pokemon no sabe evolucionar");
		else
			pokemon = this.evolucion;
		return pokemon;
	}

	public boolean combateContra(Pokemon atacado) {
		boolean combateTerminado;
		boolean vencedor = true;
		if (this.pv <= 0 || atacado.pv <= 0)
			System.out.println("Un pokemon sin PV no puede combatir");
		else {
			do {
				int danyo = (int) ((Math.random() * 51) + 25);
				atacado.pv -= danyo;
				if (atacado.pv > 0) {
					danyo = (int) ((Math.random() * 51) + 25);
					this.pv -= danyo;
					if (this.pv > 0)
						combateTerminado = false;
					else {
						vencedor = false;
						System.out.println(this.nombre + " ha sido derrotado");
						combateTerminado = true;
					}
				} else {
					vencedor = true;
					System.out.println(atacado.nombre + " ha sido derrotado");
					combateTerminado = true;
				}
			} while (combateTerminado == false);
		}
		// True si gana el atacante, false si gana el atacado		
		return vencedor;
	}

}

// En las clases hijas no hace falta poner que es serializable. Si la clase Padre lo es, también lo son todas sus hijas
class PokemonLegendario extends Pokemon{
	public PokemonLegendario(int c, String n, String t) {
		super(c, n, t);
		this.pv = (int) ((Math.random() * 201) + 100);
	}
	
	public void mostrar() {
		System.out.println("------------------");
		System.out.println("*** LEGENDARIO ***");
		super.mostrar();
	}
}
