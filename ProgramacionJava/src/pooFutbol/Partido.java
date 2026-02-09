package pooFutbol;

public class Partido {
	private Equipo local;
	private Equipo visitante;
	
	public Partido(Equipo local, Equipo visitante) {
		this.local = local;
		this.visitante = visitante;
	}
	
	public void resultado(int golesLocal, int golesVisitante) {
		if(golesLocal > golesVisitante) {
			this.local.ganaPartido();
			this.visitante.pierdePartido();
		}else if(golesVisitante > golesLocal){
			this.visitante.ganaPartido();
			this.local.pierdePartido();
		}else {
			this.local.empataPartido();
			this.visitante.empataPartido();
		}
		this.local.modificaGoles(golesLocal,golesVisitante);
		this.visitante.modificaGoles(golesVisitante,golesLocal);
		
	}
}
