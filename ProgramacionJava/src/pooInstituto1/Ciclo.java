package pooInstituto1;

public class Ciclo {
	private Modulo[] primero = new Modulo[8];
	private Modulo[] segundo = new Modulo[8];
	private String nombre;
	private String grado;
	private int numModulosPrimero = 0;
	private int numModulosSegundo = 0;
	
	public Ciclo(String nombre, String grado) {
		this.nombre = nombre;
		this.grado = grado;
	}
	
	public void anyadeModulo(Modulo m) {
		if(m.getCurso() == 1) {
			primero[this.numModulosPrimero] = m; 
			numModulosPrimero++;
		}
		else {
			segundo[this.numModulosSegundo] = m; 
			numModulosSegundo++;
		}
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Modulo[] getModulos(int curso) {
		Modulo[] modulos;
		if(curso == 1)
			modulos = primero;
		else
			modulos = segundo;
		return modulos;
	}
}
