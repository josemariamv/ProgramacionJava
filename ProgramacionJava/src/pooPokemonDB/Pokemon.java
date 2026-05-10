package pooPokemonDB;

public class Pokemon implements Comparable<Pokemon>{
	private int codigo;
	private String nombre;
	private String[] tipo = new String[2];
	private double peso;
	private double altura;

	public Pokemon(int c, String n, String t, double p, double a) {
		this.codigo = c;
		this.nombre = n;
		this.tipo[0] = t;
		this.peso = p;
		this.altura = a;
		this.tipo[1] = null;
	}

	public Pokemon(int c, String n, String t1, String t2, double p, double a) {
		// forma elegante de no repetir código entre dos constructores cuando existe una parte común
		// La llamada al método this que invoca al otro constructor debe de ser siempre la primera línea de este segundo constructor!!!!
		this(c, n, t1, p, a);
		this.tipo[1] = t2;
	}
	
	@Override
	public String toString() {
		String linea = this.nombre + " (#" + String.valueOf(this.codigo) + ")\n";
		if(this.tipo[1] == null)
			linea += "Tipo: " + this.tipo[0] + "\n";
		else
			linea += "Tipos: " + this.tipo[0] + " y " + this.tipo[1] + "\n";
		linea = linea + "Peso: " + String.valueOf(this.peso) + " / Altura: " + String.valueOf(this.altura) + "\n";
		linea += "---";
		return linea;
	}
	
	@Override
	public int compareTo(Pokemon otro) {
		int resultado = 0;
		if(this.nombre.compareTo(otro.nombre) > 0)
			resultado = 1;
		else if(this.nombre.compareTo(otro.nombre) < 0)
		 	resultado = -1;
		return resultado;
	}
}

