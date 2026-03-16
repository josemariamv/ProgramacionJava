package ejemplos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String fichero = "/home/josemaria/usuarios.txt";
		HashMap<String, String> diccionario = leerFichero(fichero);
		//comprobarUsuario(diccionario);
		nuevoUsuario(diccionario, fichero);
		diccionario = leerFichero(fichero);
		comprobarUsuario(diccionario);
	}
	
	public static HashMap<String, String> leerFichero(String fichero){
		HashMap<String, String> diccionario = new HashMap<>();
		try (BufferedReader lector = new BufferedReader(new FileReader(fichero))){
			String linea;
			while((linea = lector.readLine())!=null) {
				int posicion = linea.indexOf(':');
				diccionario.put(linea.substring(0,posicion) , linea.substring(posicion+1));
			}
			if(diccionario.size() == 0)
				System.out.println("Fichero vacío");
		}
		catch(Exception e) {
			System.out.println("Fichero inexistente o imposible acceder a él");
		}
		return diccionario;
	}
	
	public static void comprobarUsuario(HashMap<String, String> diccionario) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Usuario: ");
		String usuario = teclado.nextLine();
		System.out.print("Contraseña: ");
		String password = teclado.nextLine();
		teclado.close();
		if(diccionario.containsKey(usuario) == false)
			System.out.println("Usuario no encontrado");
		else if(diccionario.get(usuario).equals(password) == false) {
			System.out.println("Contraseña incorrecta");
		}
		else
			System.out.println("Usuario y contraseñas correctas");
	}
	
	public static void grabarEnFichero(String usuario, String password, String fichero) {
		try(PrintWriter escritor = new PrintWriter(new FileWriter(fichero, true))){
			escritor.printf("%s:%s", usuario, password);
			escritor.println();
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void nuevoUsuario(HashMap<String, String> diccionario, String fichero) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Nuevo usuario: ");
		String usuario = teclado.nextLine();
		System.out.print("Contraseña: ");
		String password = teclado.nextLine();
		System.out.print("Repite la contraseña: ");
		String passwordRepetida = teclado.nextLine();
		teclado.close();
		if(password.equals(passwordRepetida) == false)
			System.out.println("Las contraseñas no coinciden");
		else if(diccionario.containsKey(usuario) == true)
			System.out.println("Ese usuario ya existe");
		else if(usuario.indexOf(':')>=0 || password.indexOf(':')>=0)
			System.out.println("Ni el usuario o la contraseña pueden tener el caracter ':'");
		else
			grabarEnFichero(usuario, password, fichero);
	}

}
