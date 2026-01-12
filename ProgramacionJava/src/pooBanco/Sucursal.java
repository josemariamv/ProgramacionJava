package pooBanco;

import java.util.ArrayList;

public class Sucursal {
	String calle;
	int numero;
	String ciudad;
	int codPostal;
	String codigo;
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Cuenta> cuentas = new ArrayList<>();
	
	public Sucursal(Banco b, String calle, int numero, String ciudad, int codPostal, String codigo) {
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.codigo = codigo;
		
		b.nuevaSucursal(this);
	}
}
