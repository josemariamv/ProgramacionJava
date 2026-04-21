package ejemplos;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Scanner;

public class Login2 {
	public static void main(String[] args) {
		String user = "josemaria";
		String password = "abc123";
		String server = "jdbc:mysql://localhost:3306/";
		String server2 = "jdbc:mysql://localhost:3306/login";
		int opcion = menu();
		switch (opcion) {
		case 1:
			registro(user, password, server);
			break;
		case 2:
			login(user, password, server2);
		}
	}

	public static int menu() {
		int opcion = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.println("---------------------------------------------");
		System.out.println("-- IES GOYA. APLICACIÓN DE CONTROL ----------");
		System.out.println("---------------------------------------------");
		System.out.println("1. Registro de nuevos usuarios");
		System.out.println("2. Acceso a la aplicación");
		while (opcion < 1 || opcion > 2) {
			System.out.print("Elige una opción: ");
			opcion = teclado.nextInt();
			if (opcion < 1 || opcion > 2)
				System.out.println("Opción no válida. Elige una opción: ");
		}
		return opcion;
	}
	
	public static void login(String usr, String pwd, String srv) {
		Scanner teclado = new Scanner(System.in);
		boolean valido = true;
		try (Connection cnx = DriverManager.getConnection(srv, usr, pwd)) {
			System.out.println("Conexión realizada con éxito");
			
			System.out.print("Nombre de usuario: ");
			String nombre = teclado.nextLine();
			System.out.print("Contraseña: ");
			String contrasenya = teclado.nextLine();
			
			PreparedStatement query = cnx.prepareStatement("SELECT * FROM usuarios WHERE nombre = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			query.setString(1, nombre);
			ResultSet resultado = query.executeQuery();
			
			resultado.last();
			if(resultado.getRow() !=1)
				valido = false;
			else {
				String salt = resultado.getString("salt");
				String hash = generarHash(salt+contrasenya);
				if(hash.equals(resultado.getString("hash")) == false)
					valido = false;
			}
			
			if(valido == false)
				System.out.println("El usuario introducido no existe o no tiene acceso");
			else
				System.out.println("Acceso correcto");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void registro(String usr, String pwd, String srv) {
		Scanner teclado = new Scanner(System.in);
		String query1 = "CREATE DATABASE IF NOT EXISTS login";
		String query2 = "USE login";
		String query3 = "CREATE TABLE IF NOT EXISTS usuarios(nombre VARCHAR(50) PRIMARY KEY, email VARCHAR(50), prioridad int(1), salt VARCHAR(24), hash VARCHAR(88))";
		try (Connection conexion = DriverManager.getConnection(srv, usr, pwd)) {
			System.out.println("Conexión realizada con éxito");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate(query1);
			consulta.executeUpdate(query2);
			consulta.executeUpdate(query3);

			String nombre = obtenerNombreUnico(conexion, teclado);
			System.out.print("Correo electrónico: ");
			String email = teclado.nextLine();
			String contrasenya = obtenerContrasenya(teclado);
			String salt = generarSalt();
			String hash = generarHash(salt + contrasenya);
			
			PreparedStatement query4 = conexion.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
			query4.setString(1,nombre);
			query4.setString(2,email);
			query4.setInt(3,1);
			query4.setString(4,salt);
			query4.setString(5,hash);
			query4.executeUpdate();
			System.out.println("Usuario grabado con éxito");	

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static String obtenerNombreUnico(Connection cnx, Scanner teclado) throws SQLException{
		String nombre="";
		ResultSet resultado = null;
		do {
			System.out.print("Nombre de usuario: ");
			nombre = teclado.nextLine();
			PreparedStatement query = cnx.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE nombre = ?");
			query.setString(1, nombre);
			resultado = query.executeQuery();
			resultado.next();
			if(resultado.getInt(1)==1)
				System.out.println("Nombre ya existente");
		}while(resultado.getInt(1) == 1);
		return nombre;
	}
	
	public static String obtenerContrasenya(Scanner teclado) {
		String contrasenya ="";
		String contrasenya2 ="";
		do {
			System.out.print("Contraseña: ");
			contrasenya = teclado.nextLine();
			System.out.print("Repite la contraseña: ");
			contrasenya2 = teclado.nextLine();
			if(contrasenya.equals(contrasenya2) == false)
				System.out.println("Las contraseñas no coinciden");
		}while(contrasenya.equals(contrasenya2) == false);
		return contrasenya;
	}

	public static String generarSalt() {
		SecureRandom azar = new SecureRandom();
		byte[] salt = new byte[16];
		azar.nextBytes(salt);
		String saltTxt = Base64.getEncoder().encodeToString(salt);
		return saltTxt;
	}

	public static String generarHash(String txt) {
		String hashTxt = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			byte[] hash = digest.digest(txt.getBytes(StandardCharsets.UTF_8));
			hashTxt = Base64.getEncoder().encodeToString(hash);
		} catch (Exception e) {
			System.out.println("El algoritmo SHA-512 no está disponible");
		}
		return hashTxt;
	}
}