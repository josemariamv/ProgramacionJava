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
			local.ganaPartido();
			visitante.pierdePartido();
		}else if (golesVisitante > golesLocal) {
			visitante.ganaPartido();
			local.pierdePartido();
		}else {
			local.empataPartido();
			visitante.empataPartido();
		}
		local.cambiaGoles(golesLocal, golesVisitante);
		visitante.cambiaGoles(golesVisitante,golesLocal);
	}

}
