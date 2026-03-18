package tercerTrimestre;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ficheros3 {

	public static void main(String[] args) {
		// Los ficheros binarios guardan información no legible ni modificable directamente
		// ventajas: menos espacio, mas velocidad, permite guardar datos complejos y persistencia de objetos de forma mas cómoda
		String fichero = "/home/josemaria/binario.bin";
		escribirFichero(fichero);
		leerFichero(fichero);
		
		// Persistencia de objetos
		Pokemon pokemon = new Pokemon(6, "Charizard", "Fuego", "Volador");
		guardarPokemon(pokemon, fichero);
		Pokemon pokemonRecuperado = recuperarPokemon(fichero);
		if(pokemonRecuperado!=null)
			pokemonRecuperado.mostrar();
		
		// Guardar y recuperar listas de objetos
		Pokemon p1 = new Pokemon(1, "Bulbasaur", "Planta");
		Pokemon p2 = new Pokemon(6, "Charizard", "Fuego", "Volador");
		Pokemon p3 = new Pokemon(2, "Ivysaur", "Planta");
		Pokemon p4 = new Pokemon(25, "Pikachu", "Eléctrico");
		Pokemon p5 = new Pokemon(11, "Metapod", "Bicho");
		Pokemon p6 = new Pokemon(7, "Squirtle", "Agua");
		ArrayList<Pokemon> listaPokemons = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6));
		guardarListaPokemons(listaPokemons, fichero);
		ArrayList<Pokemon> listaRecuperada = recuperarListaPokemons(fichero);
		for (Pokemon poke:listaRecuperada) {
			poke.mostrar();
		}
		
		// Si quisieramos añadir un pokemon a un fichero existente lo recuperamos, añadimos el fichero a la lista y volvemos a grabar
		Pokemon p7 = new Pokemon(131,"Lapras","Agua","Hielo");
		listaRecuperada = recuperarListaPokemons(fichero);
		listaRecuperada.add(p7);
		guardarListaPokemons(listaRecuperada, fichero);
		listaRecuperada = recuperarListaPokemons(fichero);
		for (Pokemon poke:listaRecuperada) {
			poke.mostrar();
		}
	}
	
	public static void escribirFichero(String fichero) {
		 try (DataOutputStream binario = new DataOutputStream(new FileOutputStream(fichero))) {
	            
	            binario.writeInt(42);             
	            binario.writeDouble(3.14159);     
	            binario.writeBoolean(true);       
	            binario.writeUTF("Hola Mundo");   
	            binario.writeChar('A');           
	            
	            System.out.println("Datos escritos correctamente en " + fichero);
	            
	        } catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	}
	
	public static void leerFichero(String fichero) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(fichero))) {
            
            // Tenemos que leer en el mismo orden y los mismos tipos que se escribieron
            int entero = binario.readInt();
            double decimal = binario.readDouble();
            boolean bool= binario.readBoolean();
            String texto = binario.readUTF();
            char caracter = binario.readChar();
            
            System.out.println("Datos leídos del fichero:");
            System.out.println("Entero: " + entero);
            System.out.println("Double: " + decimal);
            System.out.println("Booleano: " + bool);
            System.out.println("String: " + texto);
            System.out.println("Char: " + caracter);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public static void guardarPokemon(Pokemon pokemon, String fichero) {
        try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
            binario.writeObject(pokemon);
            System.out.println("Pokemon guardado correctamente en " + fichero);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public static Pokemon recuperarPokemon(String fichero) {
		Pokemon pokemon = null;
        try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
            
        	// El cast al tipo de objeto a leer es obligatorio siempre
            pokemon = (Pokemon) binario.readObject();
            System.out.println("Pokemon recuperado correctamente");
            
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return pokemon;
    }
	
	// Un método muy práctico para guardar y recuperar objetos sin preocuparnos de cuantos son es guardarlos en una lista
	public static void guardarListaPokemons(ArrayList<Pokemon> lista, String fichero) {
        try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
            binario.writeObject(lista);
            System.out.println("Lista de Pokemons guardada correctamente en " + fichero);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public static ArrayList<Pokemon> recuperarListaPokemons(String fichero) {
		ArrayList <Pokemon> lista = null;
        try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
            
        	// Igualmente, el cast es obligatorio
            lista = (ArrayList<Pokemon>) binario.readObject();
            System.out.println("Lista de Pokemons recuperada correctamente");
            
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
