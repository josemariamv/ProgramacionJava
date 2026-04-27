package tercerTrimestre;

// Definimos las funciones Lambda a partir de una Interface 
// especial que debe de tener un único método abstracto

// El decorador es opcional, pero es conveniente ponerlo
@FunctionalInterface
public interface Operacion {
	// en la definicion solo digo que va a recibir dos parámetros int
	// y que va a devolver un int
	int ejecutar(int a, int b);
	
}
