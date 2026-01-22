package pooMedicos;

import java.util.ArrayList;

public class Centro {
	private String nombre;
	private String codigo;
	private ArrayList<Medico> medicos = new ArrayList<>();
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private ArrayList<Consulta> consultas = new ArrayList<>();
	
	public Centro(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	public void anyadeMedico(Medico m) {
		this.medicos.add(m);
	}
	
	public void eliminaMedico(Medico m) {
		this.medicos.remove(m);
	}
	
	public void anyadePaciente(Paciente p) {
		this.pacientes.add(p);
	}
	
	public void eliminaPaciente(Paciente p) {
		this.pacientes.remove(p);
	}
	
	public void anyadeConsulta(Consulta c) {
		this.consultas.add(c);
	}
	
	public void listaMedicos() {
		for(Medico m: medicos) {
			System.out.println(m.getNombre() + " " + m.getApellidos());
		}
	}
	
	public void listaPacientes() {
		for(Paciente p: pacientes) {
			System.out.println(p.getNombre() + " " + p.getApellidos());
		}
	}
	
	public void listaConsultas() {
		for(Consulta c: consultas) {
			c.muestraConsulta();
		}
	}	
}
