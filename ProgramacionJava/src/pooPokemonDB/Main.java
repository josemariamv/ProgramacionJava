package pooPokemonDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pokemon> lista = leerDDBB();
		Collections.sort(lista);
		for(Pokemon p: lista)
			System.out.println(p);
	}
	
	public static ArrayList<Pokemon> leerDDBB(){
		ArrayList<Pokemon> lista = new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/pokemondb";
		String usr = "josemaria";
		String pwd = "abc123";
		try (Connection conexion = DriverManager.getConnection(url, usr, pwd)) {
			System.out.println("Conexión realizada con exito\n");
			PreparedStatement sql = conexion.prepareStatement("SELECT * FROM pokemon");
			ResultSet r = sql.executeQuery();
			while (r.next()) {
				sql = conexion.prepareStatement("SELECT nombre FROM tipo JOIN pokemon_tipo WHERE tipo.id_tipo = pokemon_tipo.id_tipo AND numero_pokedex = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				sql.setInt(1, r.getInt("numero_pokedex"));
				ResultSet rTipo = sql.executeQuery();
				rTipo.last();
				int numTipos = rTipo.getRow();
				rTipo.first();
				if( numTipos == 1)
					lista.add(new Pokemon(r.getInt("numero_pokedex"), r.getString("nombre"), rTipo.getString("nombre"), r.getDouble("peso"), r.getDouble("altura")));
				else {
					String t1 = rTipo.getString("nombre");
					rTipo.next();
					String t2 = rTipo.getString("nombre");
					lista.add(new Pokemon(r.getInt("numero_pokedex"), r.getString("nombre"), t1, t2, r.getDouble("peso"), r.getDouble("altura")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}	
		return lista;
	}
}
