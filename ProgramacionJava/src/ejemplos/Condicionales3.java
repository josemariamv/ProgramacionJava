package ejemplos;

public class Condicionales3 {

	public static void main(String[] args) {
		int a = 21;
		int b = 21;
		int c = 21;
		int temporal, temporal2, temporal3;
		int menor, mayor, enmedio;
		if(a<b) {
			temporal = a;
			temporal2 = b;
		}
		else {
			temporal = b;
			temporal2 = a;
		}
		if(temporal<c) {
			menor = temporal;
			temporal3 = c;
		}
		else {
			menor = c;
			temporal3 = temporal;
		}
		if(temporal2 < temporal3) {
			enmedio = temporal2;
			mayor = temporal3;
		}
		else {
			enmedio = temporal3;
			mayor = temporal2;
		}
		System.out.println(menor);
		System.out.println(enmedio);
		System.out.println(mayor);
		
		if(a<b && a<c) {
			menor = a;
			if(b<c) {
				enmedio = b;
				mayor = c;
			}
			else {
				enmedio = c;
				mayor = b;
			}
		}
		else if(b<a && b<c) {
			menor = b;
			if(a<c) {
				enmedio = a;
				mayor = c;
			}
			else {
				enmedio = c;
				mayor = a;
			}
		}
		else {
			menor = c;
			if(a<b) {
				enmedio = a;
				mayor = b;
			}
			else {
				enmedio = b;
				mayor = a;
			}
		}
		System.out.println(menor);
		System.out.println(enmedio);
		System.out.println(mayor);	
	}

}
