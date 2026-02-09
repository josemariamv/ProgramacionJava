package ejemplos;

import java.util.ArrayList;
import java.util.List;

public class Ordenacion {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>(List.of(7,3,6,1,15,2,8,6,1));
		ArrayList<Integer> ordenados;
		
		//ordenados = ordenacionPorSeleccion(numeros);
		ordenados = ordenacionPorBurbuja(numeros);
		System.out.println(ordenados);
	}
	
	public static ArrayList<Integer> ordenacionPorSeleccion(ArrayList<Integer> desordenados){
		ArrayList<Integer> ordenados = new ArrayList<>();
		while(desordenados.size()!=0) {
			int mayor = -1;
			for(int n:desordenados)
				if(n > mayor)
					mayor = n;
			desordenados.remove((Integer)mayor);
			ordenados.add(mayor);
		}
		return ordenados;
	}
	
	public static ArrayList<Integer> ordenacionPorBurbuja(ArrayList<Integer> lista){
		boolean cambios = true;
		while(cambios == true) {
			cambios = false;
			for(int i=0; i<lista.size()-1; i++) {
				//System.out.println(lista.get(i) + " - " + lista.get(i+1));
				if(lista.get(i)<lista.get(i+1)){
					int num=lista.remove(i);
					lista.add(i+1,num);
					cambios = true;
				}
			}
		}
		return lista;
	}
}
