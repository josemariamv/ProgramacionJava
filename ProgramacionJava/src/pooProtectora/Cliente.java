package pooProtectora;

import java.util.Arrays;

public class Cliente {
	String nombre;
	String apellidos;
	int edad;
	int telefono;
	String interes;

	Gato[] gatos = null;
	Perro[] perros = null;
	Tortuga tortuga = null;

	public Cliente(String nombre, String apellidos, int edad, int telefono, String interes) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.interes = interes;
	}

	// cuando un cliente adopta un perro primero comprobamos si no ha sobrepasado ya los dos máximo
	// si no ha sido así lo marcamos como adoptado y referenciamos el animal en los arrays que tiene cada cliente
	public void adopta(Perro perro) {
		if (perros!=null && perros.length == 2)
			System.out.println("Este cliente ya ha adoptado dos perros");
		else {
			perro.adoptado();
			if (perros == null) {
				perros = new Perro[1];
				perros[0] = perro;
			} else{
				perros = Arrays.copyOf(perros, perros.length + 1);
				perros[perros.length - 1] = perro;
			}
		}
	}

	// El resto de animales es igual
	public void adopta(Gato gato) {
		if (gatos!=null && gatos.length == 3)
			System.out.println("Este cliente ya ha adoptado tres gatos");
		else {
			gato.adoptado();
			if (gatos == null) {
				gatos = new Gato[1];
				gatos[0] = gato;
			} else{
				gatos = Arrays.copyOf(gatos, gatos.length + 1);
				gatos[gatos.length - 1] = gato;
			}
		}
	}

	// En este caso si usamos this para diferenciar el atributo del objeto del argumento de la función
	// ya que se llaman igual
	public void adopta(Tortuga tortuga) {
		if (this.tortuga == null) {
			tortuga.adoptado();
			this.tortuga = tortuga;
		}
		else
			System.out.println("\nEste cliente ya ha adoptado una tortuga");
	}

	// Para listar los animales adoptados por un cliente recorremos los arrays (la tortuga es un dato simple)
	// y llamamos a la función que muestra sus datos en consola que ya usamos en el listado de la protectora
	public void listaAdoptados() {
		System.out.println("\nCliente: " + nombre + " " + apellidos + " (" + telefono + ")");
		if(perros!=null) {
			System.out.println("Perros adoptados:");
			for(Perro perro:this.perros)
				perro.datos();
		}
		if(gatos!=null) {
			System.out.println("Gatos adoptados:");
			for(Gato gato:this.gatos)
				gato.datos();
		}
		if(tortuga!=null) {
			System.out.println("Tortuga adoptada:");
			tortuga.datos();
		}
	}
}
