package segundoTrimestre;

import tinderGoya.Hombre;

// Una clase abstracta es aquella con al menos un método abstracto sin implementar
// No se pueden crear objetos de clases abstractas. Sólo se pueden usar a partir de clases heredadas
abstract class Abstracta {
	protected int dato1;
	protected String dato2;
	
	public void metodo1() {
		// el operador instanceof me permite saber con que tipo de objeto heredado estoy trabajando
		// desde un método de la clase padre
		if(this instanceof Real)
			System.out.println("Es una instancia del objeto Real");
		else
			System.out.println("Es una instancia del objeto Real2");
	}
	
	// Los métodos abstractos no se definen, pero es obligatrio hacerlo en las clases hijas
	abstract void metodo2();
}

// La clase que hereda de la clase abstracta tiene obligatoriamente que 
// declarar y definir los métodos que aparezcan como abstractos en la clase padre
class Real extends Abstracta{
	private float dato3;
	
	public void metodo2() {
		
	}
}
	
class Real2 extends Abstracta{
	private float dato3;	
	public void metodo2() {
			
		}
}



