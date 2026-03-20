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
		// Fíjate que usamos "output" para escribir e "input" para leer. Puede parecer contradictorio
		// pero piensa que el punto de vista es el de la "persona" que lee o graba
		// cuando escribes es output porque los datos salen de ti hacia el fichero
		// cuando lees es input porque los datos vienen a ti desde el fichero
		 try (DataOutputStream binario = new DataOutputStream(new FileOutputStream(fichero))) {
	            // Lo mas importante a la hora de escribir en un fichero binario es que importa el tipo de datos
			 	// que se escribe. En los de texto no, porque siempre escribimos texto. Aquí usamos métodos distintos
			 	// por cada tipo de datos
			 	// Por lo demás, la estructura es muy similar
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
			// Prueba a intercambia el orden de las dos líneas siguientes y verás que lo que se lee
			// en ese caso es totalmente distinto a lo que escribiste
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
		// guardar un objeto es sumamente fácil. Usamos siempre el mismo método y no hace falta usar un "cast"
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
        	// Al leer, el cast al tipo de objeto es obligatorio
            pokemon = (Pokemon) binario.readObject();
            System.out.println("Pokemon recuperado correctamente");
            
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return pokemon;
    }
	
	public static void guardarListaPokemons(ArrayList<Pokemon> lista, String fichero) {
		// Un método muy práctico para guardar y recuperar objetos sin preocuparnos de cuantos son es guardarlos en una lista
		// La lista se trata como un único objeto independientemente de su tamaño
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
        	// Al leer, la lista es también un único objeto de forma independiente a su tamaño
        	// No olvides el cast, que también hace falta
            lista = (ArrayList<Pokemon>) binario.readObject();
            System.out.println("Lista de Pokemons recuperada correctamente");
            
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
