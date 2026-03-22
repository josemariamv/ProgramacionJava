package tercerTrimestre;

import java.io.RandomAccessFile;

public class Ficheros4 {

	static final int TAMANYO_NOMBRE = 20; // caracteres. un caracter ocupa 2 bytes
	static final int TAMANYO_EDAD = 4; // bytes. un entero ocupa 4 bytes
	static final int TAMANYO_REGISTRO = TAMANYO_NOMBRE *2 + TAMANYO_EDAD;
	
	public static void main(String[] args) {
		// El acceso aleatorio a un fichero nos permite dirigirnos directamente a un dato concreto sin necesidad
		// de pasar por los demas. Lo mas importante para ello es que los "registros" de datos tengan un
		// tamaño fijo.

		String fichero = "registros.dat";
		
		try {
			crearRegistro(fichero);
			leerRegistro(fichero,2);
			modificarRegistro(fichero, 2, "Luis Miguel", 31);
			leerRegistro(fichero,2);
			leerTodosLosRegistros(fichero);
			anyadeRegistro(fichero,"Armando", 35);
			leerRegistro(fichero,5);
			leerTodosLosRegistros(fichero);
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// otra forma de tratar las excepciones: se capturan todas desde el programa principal
	// en los métodos añadimos la clausula throws Exception (o el nombre de la excepción concreta)
	// cuando se produzca esa excepción el método deja de ejecutarse y vuelve al programa principal
	// y se ejecuta allí el bloque catch
	public static void crearRegistro (String fichero) throws Exception{
		// el modo rw permite leer y escribir y crea el fichero si no existe. No existe modo w como en los ficheros de texto
		// los modos rws y rwd son similares pero escriben directamente a disco y no a cache.
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            String[] nombres = {"Ana", "Luis", "Carlos", "Marta"};
            int[] edades = {25, 30, 28, 35};

            for (int i = 0; i < nombres.length; i++) {
                escribirNombre(raf, nombres[i]);
                raf.writeInt(edades[i]);  // Los enteros se graban con 4 bytes
            }
            
            System.out.println("Archivo creado con " + nombres.length + " registros");
            System.out.println("Tamaño total del archivo: " + raf.length() + " bytes");
        }
	}
	
	// Método para escribir un nombre con tamaño fijo
    private static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
    	// Crear un array de caracteres del tamaño fijo
        char[] chars = new char[TAMANYO_NOMBRE];     
        // Llenar con espacios o con el nombre
        for (int i = 0; i < TAMANYO_NOMBRE; i++) {
            if (i < nombre.length()) {
                chars[i] = nombre.charAt(i);
            } else {
                chars[i] = ' ';  // Rellenar con espacios
            }
        }
        // Escribir cada caracter como char (2 bytes cada uno)
        for (char c : chars) {
            raf.writeChar(c);
        }
    }
    
    private static void leerRegistro(String fichero, int registro) throws Exception {
    	// el modo r es de solo lectura. provoca excepción si el fichero no existe
    	try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
            // Calcular la posicion donde empezamos a leer
    		// El registro 1 es el primero (y empieza en la posición 0)
            long offset = (registro-1) * TAMANYO_REGISTRO;
            raf.seek(offset);
            
            String nombre = leerNombre(raf);
            int edad = raf.readInt();
            
            System.out.printf("Registro %d: '%s', %d años%n", registro, nombre, edad);
        }
    }
    
    private static String leerNombre(RandomAccessFile raf) throws Exception {
        String nombre ="";
        // Leer cada caracter
        for (int i = 0; i < TAMANYO_NOMBRE; i++) {
            char c = raf.readChar();
            nombre = nombre + c;
        }
        return nombre.trim();  // trim() para eliminar espacios
    }
    
    private static void modificarRegistro(String fichero, int registro, String nombre, int edad) throws Exception{
    	try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            long offset = (registro-1) * TAMANYO_REGISTRO;
            raf.seek(offset);
          
            escribirNombre(raf, nombre);
            raf.writeInt(edad);
         
            System.out.println("Registro " + registro + " modificado");
        }
    }
    
    private static void leerTodosLosRegistros(String fichero) throws Exception {
    	try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
    		// calculamos el número de registros a partir del tamaño del fichero
    		int numRegistros = (int)raf.length()/TAMANYO_REGISTRO;
    		System.out.println("NÚMERO DE REGISTROS: " + numRegistros);
    		for(int i=0; i< numRegistros; i++) {
    			String nombre = leerNombre(raf);
    			int edad = raf.readInt();
    			System.out.printf("Registro %d: '%s', %d años%n", i+1, nombre, edad);
    		}
        }
    }
    
    private static void anyadeRegistro(String fichero, String nombre, int edad) throws Exception{
    	try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            raf.seek(raf.length());
            escribirNombre(raf, nombre);
            raf.writeInt(edad);
            System.out.println("Registro añadido");
        }
    }
    
    

}
