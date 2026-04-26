package pooSeguridadSocial;

public interface Jubilacion {
	int EDAD_MINIMA_JUBILACION = 67;
	int ANYOS_MINIMOS_COTIZADOS_100 = 37; // Años cotizados para cobrar el 100%
	int ANYOS_MINIMOS_COTIZADOS_50 = 15;  // Años cotizados para cobrar el 50%
	
	public void consultaJubilacion();
	
}
