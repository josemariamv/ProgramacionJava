package pooBanco;

import java.util.ArrayList;

public class Banco {
	String nombre;
	String codigo;
	ArrayList<Sucursal> sucursales = new ArrayList<>();
	
	public Banco(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	public void nuevaSucursal(Sucursal s) {
		this.sucursales.add(s);
	}
	
	public void listarSucursales() {
		System.out.println("Banco: " + this.nombre + " / Código: (" + this.codigo + ")");
		for(Sucursal s: sucursales) {
			System.out.println("-" + s.ciudad + "(" + s.codigo + ")");
		}
	}
}
