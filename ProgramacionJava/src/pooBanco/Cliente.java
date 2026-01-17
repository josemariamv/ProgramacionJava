package pooBanco;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String nif;
	private int telefono;
	private Sucursal sucursal;
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	
	public Cliente(String nombre, String apellido, String nif, int telefono, Sucursal sucursal) {
		this.nombre = nombre;
		this.apellidos = apellido;
		this.nif = nif;
		this.telefono = telefono;
		this.sucursal = sucursal;
		this.sucursal.anyadeCliente(this);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public String getNif() {
		return this.nif;
	}
	
	public void anyadeCuenta(Cuenta c) {
		this.cuentas.add(c);
	}

}
