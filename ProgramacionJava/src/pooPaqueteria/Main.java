package pooPaqueteria;

public class Main {
	public static void main(String[] args) {
		// Peso, coordenada x, coordenada y
		new Paquete(20.7,4,2);
		new Paquete(2.1,6,7);
		new Paquete(3.5,1,6);
		new Paquete(40.2,1,1);
		new Paquete(40.2,2,7);
		
		// peso máximo, kms. máximos diarios
		Camioneta c1 = new Camioneta(100,100);
				
		c1.calcularRuta();
		c1.mostrarRuta();
	} 

}
