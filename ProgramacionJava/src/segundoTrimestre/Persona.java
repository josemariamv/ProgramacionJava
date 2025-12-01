package segundoTrimestre;

// Crearemos nuestras clases en archivos independientes dentro del mismo paquete donde estará nuestra función main que será el punto 
// de entrada a nuestro progama, como siempre. Un fichero con una clase como esta pero sin main no puede ejecutarse

public class Persona {
	/*
	 * Los atributos de la clase son los datos que luego van a identificar a cada uno de los objetos
	 * Por defecto los definiremos a todos como privados. Eso hace que nuestra única forma de interactuar 
	 * con ellos sea a través de los métodos y nos dará protección para que no haya manipulaciones indeseadas
	 */
	private String nombre;
	private String apellidos;
	// se pueden inicializar atributos direcamente en su declaración
	private int edad = 0;
	
	// Un atributo static no es independiente para cada objeto sino que es común a todos los objetos de la clase
	private static int numPersonas=0;
	
	// El método que se llama como la clase es el constructor
	// Una clase puede tener mas de un constructor. 
	public Persona(String nom, String ape) {
		// la palabra reservada this es una referencia al objeto que invoca al método. 
		// Ya que los atributos son, normalmente, diferentes e independientes para cada objeto por separado
		this.nombre = nom;
		this.apellidos = ape;
		// Los atributos static no usan this
		numPersonas++;
	}
	
	public Persona(String nomb, String ape, int ed) {
		this.nombre = nomb;
		this.apellidos = ape;
		this.edad = ed;
		numPersonas++;
	}
	
	/*
	 * Los métodos de la clase son los que definen su funcionalidad y su comportamiento
	 * Por lo demás son funciones iguales a las que ya hemos visto. Por defecto todos los métodos
	 * serán publicos y serán nuestra forma de interactuar con los objetos
	 * Podemos tener métodos para mostrar datos, para cambiarlos, para recuperarlos o para hacer cualquier cosa
	 */
	public void mostrar() {
		System.out.println(apellidos + ", " + nombre);
	}

	public void aniversario() {
		this.edad++;
	}

	public int cuantasPersonas() {
		return numPersonas;
	}
	
	// Java no tiene destructores como otros lenguajes de programación
	// si necesitamos ejecutar algo antes de destruir un objeto creamos un método y
	// debemos de invocarlo nosotros mismos
	
	public void eliminaPersona() {
		numPersonas--;
	}

	// Podemos crear automáticamente funciones para interactuar con nuestros atributos
	// Se llaman getters y setters. Pulsamos sobre el archivo de la clase con el botón derecho
	// elegimos Source y luego genertar getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}

