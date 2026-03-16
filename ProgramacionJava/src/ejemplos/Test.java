package ejemplos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		String fSoluciones = "/mnt/temp/soluciones.txt";
		String fRespuestas = "/mnt/temp/respuestas.txt";
		String fNotas = "/mnt/temp/notas.txt";
		int numPreguntas = 10;
		String soluciones[];
		HashMap<String, String[]> respuestas = null;
		soluciones = leeSoluciones(fSoluciones);
		respuestas = leeRespuestas(fRespuestas);
		grabaNotas(fNotas, soluciones, respuestas);
	}
	
	public static String[] leeSoluciones(String fichero){
		Path ruta = Path.of(fichero);
		String linea = null;
		String[] soluciones = null;
		try {
			linea = Files.readString(ruta);
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		if(linea!=null)
			soluciones = linea.split(", ");
		return soluciones;
	}
	
	public static HashMap<String, String[]> leeRespuestas(String fichero){
		HashMap<String, String[]> diccionario = new HashMap<>();
		try (BufferedReader lector = new BufferedReader(new FileReader(fichero))){
			String linea;
			while((linea = lector.readLine())!=null){
				int posicion = linea.indexOf(':');
				String alumno = linea.substring(0,posicion);
				String respuestas = linea.substring(posicion+2);
				diccionario.put(alumno,respuestas.split(", "));
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return diccionario;
	}
	
	public static void grabaNotas(String fichero, String[] soluciones, HashMap<String, String[]> respuestas) {
		try(PrintWriter pluma = new PrintWriter(fichero)){
			
			for(Map.Entry<String, String[]> respuesta: respuestas.entrySet()) {
				System.out.print(respuesta.getKey() + ": ");
				System.out.println(calcularNota(soluciones, respuesta.getValue()));
				pluma.printf("%s: %.1f", respuesta.getKey(), calcularNota(soluciones, respuesta.getValue()));
				pluma.println();
			}
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public static double calcularNota(String[] soluciones, String[] respuesta) {
		double nota = 0;
		for(int i=0; i<soluciones.length; i++) {
			if(soluciones[i].charAt(0) == respuesta[i].charAt(0))
				nota+=1;
			else
				nota-=0.3;
			//System.out.println(soluciones[i] + " - " + respuesta[i] + " - " + nota);
		}
		//nota = Math.round(nota*10.0)/10.0;
		if(nota<0)
			nota = 0;
		return nota;
	}

}
