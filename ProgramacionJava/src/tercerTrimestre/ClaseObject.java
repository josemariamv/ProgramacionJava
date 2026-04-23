package tercerTrimestre;

import java.util.ArrayList;
import java.util.Collections;

public class ClaseObject {
	public static void main(String[] args) {
		// Todas las clases en Java heredan de la clase Object
		// La clase Object tiene algunos métodos muy útiles que podemos 
		// sobreescribir para nuestro uso
		
		Pokemon pikachu = new Pokemon(25,"Pikachu","Eléctrico");
		Pokemon butterfree = new Pokemon(12,"Butterfree","Bicho", "Volador");
		Pokemon ekans = new Pokemon(23,"Ekans","Veneno");
		Pokemon arkanine = new Pokemon(59,"Arcanine","Fuego");

		
		pikachu.mostrar();
		// el método toString debe devolver un texto y nos permite modificar
		// lo que se ve en consola al hacer un syso
		
		// probar antes y después de redefinir el método en la clase Pokemon
		System.out.println(pikachu);
		System.out.println(butterfree);
		
		// Por defecto dos objetos son iguales solo son el mismo objeto
		Pokemon otroPikachu = pikachu;
		if(pikachu == otroPikachu)
			System.out.println("Son el mismo pokemon");
		if(pikachu.equals(otroPikachu))
			System.out.println("Siguen siendo el mismo pokemon");
		
		// El método equals se comporta igual
		// Si lo redefino puedo comparar también contenidos. Debe devolver un boolean
		// probar, igualmente, antes y después de redefinir el método
		Pokemon unPikachuNuevo = new Pokemon(25,"Pikachu","Eléctrico");
		if(pikachu.equals(unPikachuNuevo))
			System.out.println("Son el mismo pokemon");
		else
			System.out.println("No son el mismo pokemon");
		
		// compareTo me permite hacer comparaciones de mayor, menor o igual
		// debe de devolver un entero. negativo si es menor, 0 si es igual y positivo si es mayor
		// también me va a permitir ordenar los objetos con sort 
		ArrayList<Pokemon> listaPokemons = new ArrayList<>();
		listaPokemons.add(arkanine);
		listaPokemons.add(pikachu);
		listaPokemons.add(butterfree);
		listaPokemons.add(ekans);
		Collections.sort(listaPokemons);
		System.out.println("ORDENADOS:");
		for(Pokemon p:listaPokemons)
			System.out.println(p);
		
		
	}
}

