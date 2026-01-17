package pooBanco;

public class Cuenta {
	private Cliente titular1;
	private Cliente titular2 = null;
	private double saldo;
	private Sucursal sucursal;
	private String codigo;
	
	public Cuenta(Cliente c1, double saldo, Sucursal sucursal, String codigo) {
		this.titular1 = c1;
		this.saldo = saldo;
		this.sucursal = sucursal;
		this.codigo = codigo;
		
		c1.anyadeCuenta(this);
		sucursal.anyadeCuenta(this);
	}
	
	public Cuenta(Cliente c1, Cliente c2, double saldo, Sucursal sucursal, String codigo) {
		this.titular1 = c1;
		this.titular2 = c2;
		this.saldo = saldo;
		this.sucursal = sucursal;
		this.codigo = codigo;
		
		c1.anyadeCuenta(this);
		c2.anyadeCuenta(this);
		sucursal.anyadeCuenta(this);
	}
	
	public String getIBAN() {
		return sucursal.getCodigoCompleto() + " " + this.codigo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void verCuenta() {
		System.out.println(this.getIBAN() + " - " + this.getSaldo() + "€");
	}

}
