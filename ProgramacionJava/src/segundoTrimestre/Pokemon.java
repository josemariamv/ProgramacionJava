package segundoTrimestre;

public class Pokemon {
	private Pokemon evolucion = null;
	private String nombre;
	private int pv = (int)((Math.random()*51)+50);

	public Pokemon(String nombre) {
		this.nombre = nombre;
	}
	
	public void mostrar() {
		System.out.println(this.nombre + " - " + this.pv);
	}
	
	public void setEvolucion(Pokemon p) {
		this.evolucion = p;
	}
	
	public Pokemon evoluciona() {
		Pokemon devolver;
		if(this.evolucion == null) {
			System.out.println("Este pokemon no tiene evolución");
			devolver = this;
		}
		else {
			devolver = this.evolucion;
			devolver.pv+=this.pv;
		}
		return(devolver);
	}
	
	public void combateContra(Pokemon contrincante) {
		int danno = (int)((Math.random()*26)+25);
		contrincante.pv-=danno;
		if(contrincante.pv <= 0)
			System.out.println(contrincante.nombre + " ha sido derrotado");
		else {
			danno = (int)((Math.random()*26)+25);
			this.pv-=danno;
			if(this.pv <= 0)
				System.out.println(this.nombre + " ha sido derrotado");
			else
				System.out.println("El combate no ha concluido con la victoria de ninguno");				
		}
	}
}
