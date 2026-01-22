package pooMedicos;

import java.time.LocalDate;

public class Consulta {
	
	private Medico medico;
	private Paciente paciente;
	private LocalDate fecha;
	private String sintomas;
	private String remedio;
	
	public Consulta(Paciente p, Medico m, LocalDate f, String s, String r) {
		this.medico = m;
		this.paciente = p;
		this.fecha = f;
		this.sintomas = s;
		this.remedio = r;
		
		Centro centro = this.medico.getCentro();
		centro.anyadeConsulta(this);
		this.medico.anyadeConsulta(this);
		this.paciente.anyadeConsulta(this);
	}
	
	public void muestraConsulta() {
		System.out.println("(" + this.fecha + ") - Doctor: " + this.medico.getApellidos() );
		System.out.println("Paciente: " + this.paciente.getApellidos() );
		System.out.println("Síntomas: " + this.sintomas);
		System.out.println("Diagnóstico: " + this.remedio);
		System.out.println("-----------------------------------------------------------");
	}
}

