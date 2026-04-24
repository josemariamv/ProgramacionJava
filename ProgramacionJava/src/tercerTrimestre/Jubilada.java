package tercerTrimestre;

import java.time.LocalDate;

public interface Jubilada {
	 // 1. ATRIBUTOS: Siempre son public, static y final (constantes)
    int EDAD_JUBILACION = 67;
    
    // método abstracto (por defecto)
	void jubilada();
	
    // método normal de instancia. Público. Tiene cuerpo pero se puede sobreescribir
	/*  default void jubilada() {
	  	System.out.println("Jubilada. Comprueba que tenga " + this.EDAD_JUBILACION + " años");
	 
	} */
	
	// método estático. Pertenece a la interfaz
	 static void edadJubilacion(int edad) {
		 if(edad < EDAD_JUBILACION)
			 System.out.println("No Puede jubilarse");
		 else
			 System.out.println("Puede jubilarse");
	    }
	
}
