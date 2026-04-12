package tercerTrimestre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databases1 {

	public static void main(String[] args) {
		// En la cadena de conexión indicamos la ubicación del gestor de bases de datos
		// String url = "jdbc:mysql://localhost:3306/";
		// Y, opcionalmente, la base de datos con la que queremos trabajar. 
		// Sería equivalente a ejecutar el comando USE después de hacer la conexión
		String url = "jdbc:mysql://localhost:3306/sakila";
		String usr = "josemaria";
		String pswd = "abc123";
		Connection conexion;

		try {
			// El objeto de la clase Connection es obligatorio para conectar a la base de datos
			conexion = DriverManager.getConnection(url, usr, pswd);
			System.out.println("Conexión realizada con exito\n");
			
			// Statement es la clase que nos permite lanzar queryes
			Statement sql = conexion.createStatement();
			// Y ResultSet la que nos permite recoger los resultados
			// podemos hacer cualquier query con JOIN, WHERE, ORDER, etc!
			ResultSet resultado = sql.executeQuery("SELECT * FROM actor");
			// el método .next() devuelve false cuando el query ya no tenga mas resultados
			// mientras tanto, avanza a la siguiente línea de los resultados del query
			// cada vez que lo ejecutamos. Igual que readLine en un fichero!
			while(resultado.next()) {
				// Podemos recoger los resultados indicando el número de la columna (empezando por 1)
				//System.out.printf("ID: %d - %s, %s\n", resultado.getInt(1), resultado.getString(3), resultado.getString(2));
				// O el nombre que devuelve la base de datos
				System.out.printf("ID: %d - %s, %s\n", resultado.getInt("actor_id"), resultado.getString("last_name"), resultado.getString("first_name"));
				// o con la posición que ocupa en el query, empezando por 0
			}
			// Al final de la ejecución hay que cerrar el objeto de conexión
			// si te das cuenta la mecánica es muy similar a como se trabaja con ficheros
			conexion.close();
			// SQLException nos da mas información que Exception sobre los posibles errores
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
