package ejemplos;

public class LambdaDescuentos {

	public static void main(String[] args) {
		
		Descuento sinDescuento= (precio, tipo) ->{
			return precio;
		};
		
		Descuento diezPorCiento= (precio, tipo) ->{
			return (precio * 0.9);
		};
		
		System.out.println(sinDescuento.aplicar(47.55,3));
		System.out.println(diezPorCiento.aplicar(47.55,2));
		
	}

}
