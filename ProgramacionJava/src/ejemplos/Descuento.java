package ejemplos;

@FunctionalInterface
public interface Descuento {
	double aplicar(double precio, int tipo);
	
}
