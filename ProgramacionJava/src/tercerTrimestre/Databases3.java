package tercerTrimestre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Databases3 {
	 public static void main(String[] args) {      
	        String database = "jdbc:mysql://localhost:3306/sakila";        
			String usr = "josemaria";
			String pswd = "abc123";
	              
	       verJTable(database,usr,pswd);
	    }
	       
	     public static void verJTable(String database, String user, String password){
	        String query01 = "SELECT actor_id, first_name, last_name FROM actor;";
	        
	        try {
	            Connection conexion = DriverManager.getConnection(database,user,password);
	            Statement consulta = conexion.createStatement();
	            ResultSet ejecucion = consulta.executeQuery(query01);
	            
	           //Creamos una ventana
	            JFrame ventana = new JFrame("Contenido de la tabla actor");
	            
	            // Creamos una tabla con JTable
	            DefaultTableModel modelo = new DefaultTableModel();
	            JTable tabla = new JTable(modelo);
	            
	            // Le metemos cuatro columnas a nuestra tabla, las que queremos mostrar
	            modelo.addColumn("id");
	            modelo.addColumn("nombre");
	            modelo.addColumn("apellido");
	            
	            // Metemos la tabla en la ventana
	            JScrollPane scroll = new JScrollPane(tabla);
	            ventana.getContentPane().add(scroll);
	            
	            //JButton boton = new JButton("Salir");
	            //ventana.getContentPane().add(boton);
	            
	            // Metemos el resultado del select en la tabla
	            while(ejecucion.next()){
	                Object [] fila = new Object[4];
	                fila[0] = ejecucion.getInt("actor_id");
	                fila[1] = ejecucion.getString("first_name");
	                fila[2] = ejecucion.getString("last_name");
	                modelo.addRow(fila); 
	            }
	            
	            // Últimos retoques. Y hacemos visible el conjunto
	            ventana.pack();
	            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            ventana.setVisible(true);
	          
	            ejecucion.close();
	            consulta.close();
	            conexion.close();     
	        } catch (SQLException ex) {
	        	// Podemos obtener información acerca de los errores
	            System.out.println("Ha ocurrido una excepción");
	            System.out.println("Código: " + ex.getErrorCode());
	            System.out.println("Mensaje: " + ex.getMessage());
	            System.out.println("Estado: " + ex.getSQLState());
	        }
	    }
}
