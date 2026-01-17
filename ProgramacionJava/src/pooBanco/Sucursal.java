package pooBanco;

import java.util.ArrayList;

public class Sucursal {
	private String calle;
	private int numero;
	private String ciudad;
	private int codPostal;
	private String codigo;
	private Banco banco;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	
	public Sucursal(Banco b, String calle, int numero, String ciudad, int codPostal, String codigo) {
		this.banco = b;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.codigo = codigo;
		
		b.nuevaSucursal(this);
	}
	
	public String getCiudad() {
		return this.ciudad;
		}
	
	public String getCodigo() {
		return this.codigo;
		}
	
	public void anyadeCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void listarClientes() {
		System.out.println("Sucursal: " + this.ciudad + " / Código: (" + this.codigo + ")");
		for(Cliente c: clientes) {
			System.out.println("-" + c.getApellidos() + ", " + c.getNombre() + " (" + c.getNif() + ")");
		}
	}
	
	public void anyadeCuenta(Cuenta c) {
		this.cuentas.add(c);
	}
	
	public String getCodigoCompleto() {
		return banco.getCodigo() + " " + this.codigo;
	}
}
