package pooProtectora;

import java.util.Arrays;

public class Protectora {
	// Creamos una clase protectora que será la que guardará las referencias a todos los animales y clientes.
	// No vamos a necesitar constructor
	// Tendrá cuatro listas que en principio están vacías

	private Gato[] gatos = null;
	private Perro[] perros = null;
	private Tortuga[] tortugas = null;
	private Cliente[] clientes = null;
	
	// Cada vez que llega un nuevo perro a la protectora creamos el objeto y lo añadimos a la lista de perros de la protectora
	// fijate que no es necesario usar this delante de los atributos cuando no hay problema de que se confunda con otra variable
	public Perro nuevoPerro(int nacimiento, boolean vacunado, String nombre) {
		if(perros == null)
			perros = new Perro[1];
		else
			perros = Arrays.copyOf(perros,perros.length+1);
		perros[perros.length-1] = new Perro(nacimiento, vacunado, nombre);	
		return perros[perros.length-1]; 
	}
	
	// tenemos que crear dos métodos diferentes para que se correspondan con los dos constructores que hemos creado (con nombre o sin el)
	public Perro nuevoPerro(int nacimiento, boolean vacunado) {
		if(perros == null)
			perros = new Perro[1];
		else
			perros = Arrays.copyOf(perros,perros.length+1);
		perros[perros.length-1] = new Perro(nacimiento, vacunado);
		return perros[perros.length-1];
	}
	
	// el resto de animales son similares a los perros
	public Gato nuevoGato(int nacimiento, boolean vacunado, String nombre) {
		if(gatos == null)
			gatos = new Gato[1];
		else
			gatos = Arrays.copyOf(gatos,gatos.length+1);
		gatos[gatos.length-1] = new Gato(nacimiento, vacunado, nombre);	
		return gatos[gatos.length-1];
	}
	
	public Gato nuevoGato(int nacimiento, boolean vacunado) {
		if(gatos == null)
			gatos = new Gato[1];
		else
			gatos = Arrays.copyOf(gatos,gatos.length+1);
		gatos[gatos.length-1] = new Gato(nacimiento, vacunado);
		return gatos[gatos.length-1];
	}
	
	public Tortuga nuevaTortuga(int nacimiento, boolean terrestre, String nombre) {
		if(tortugas == null)
			tortugas = new Tortuga[1];
		else
			tortugas = Arrays.copyOf(tortugas,tortugas.length+1);
		tortugas[tortugas.length-1] = new Tortuga(nacimiento, terrestre, nombre);
		return tortugas[tortugas.length-1];
	}
	
	public Tortuga nuevaTortuga(int nacimiento, boolean terrestre) {
		if(tortugas == null)
			tortugas = new Tortuga[1];
		else
			tortugas = Arrays.copyOf(tortugas,tortugas.length+1);
		tortugas[tortugas.length-1] = new Tortuga(nacimiento, terrestre);
		return tortugas[tortugas.length-1];
		}
	
	// Los listados de animales no adoptados consisten en recorrer los tres arrays y mostrar los datos de los no adoptados
	// para eso hemos creado dos métodos: uno en Animal que nos dice si está adoptado o no
	// y otro en cada tipo de animal que nos muestra sus datos por consola)
	public void listarNoAdoptados() {
		System.out.println("\nPerros no adoptados");
		System.out.println("###################");
		listarPerros();
		System.out.println("\nGatos no adoptados");
		System.out.println("###################");
		listarGatos();
		System.out.println("\nTortugas no adoptadas");
		System.out.println("#######################");
		listarTortugas();
	}
	
	public void listarPerros() {
		for(Perro perro:this.perros) {
			if(perro.getAdoptado() == false)
				perro.datos();
		}
	}
	
	public void listarGatos() {
		for(Gato gato:this.gatos) {
			if(gato.getAdoptado() == false)
				gato.datos();
		}
	}
	
	public void listarTortugas() {
		for(Tortuga tortuga:this.tortugas) {
			if(tortuga.getAdoptado() == false)
				tortuga.datos();
		}
	}
}
