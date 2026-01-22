package pooMedicos;

import java.util.ArrayList;

abstract class Persona {
	protected String nombre;
	protected String apellidos;
	protected Centro centro;
	protected ArrayList<Consulta> consultas = new ArrayList<>();
	
	public Persona(String nombre, String apellidos, Centro centro) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.centro = centro;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public Centro getCentro() {
		return this.centro;
	}
	
	public void anyadeConsulta(Consulta c) {
		consultas.add(c);
	}
	
	public void listaConsultas() {
		for(Consulta c: consultas) {
			c.muestraConsulta();
		}
	}
	
	abstract public void cambiaCentro(Centro c);
}
