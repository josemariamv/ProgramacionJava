package primerTrimestre;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Una expresión regular es un patrón que nos permite identificar o validar si una entrada
 * de texto cumple con ciertos requisitos establecidos previamente. Establecemos el patrón
 * mediante un String y siguiendo unos códigos establecidos
 */

public class ExpresionesRegulares {
	public static void main(String[] args) {
		/*
		 * Para usar expresiones regulares en Java necesitamos usar dos clases nuevas: Pattern y Matcher
		 * Pattern me permite definir el patrón que busco
		 * Matcher me identificará si ese patrón existe o no en una cadena de texto concreta
		 */
		
		Pattern patron = Pattern.compile("\\d{8}");
		
		Matcher coincidencia = patron.matcher("28896");
		// En este caso el patrón no coincide. El texto no tiene 8 dígitos
		if(coincidencia.find() == true)
			System.out.println("El patrón coincide");
		else
			System.out.println("El patrón no coincide");
		
		coincidencia = patron.matcher("X12345678P");
		// En este caso si coincide. El patrón tiene 8 dígitos seguidos. No importa si tiene algo adicional
		if(coincidencia.find() == true)
			System.out.println("El patrón coincide");
		else
			System.out.println("El patrón no coincide");
		
		// Otro método mas sencillo consiste en usar directamente el método match de la clase String
		String dni1 = "12345678";
		String dni2 = "12345678S";
        String patronDNI =  "\\d{8}[A-Z]"; // El patrón ahora son 8 dígitos seguidos de una letra en mayúsculas  
        
        if(dni1.matches(patronDNI) == true)
        	System.out.println(dni1 + " es un dni válido");
        else
        	System.out.println(dni1 + " no es un dni válido");
        
        if(dni2.matches(patronDNI) == true)
        	System.out.println(dni2 + " es un dni válido");
        else
        	System.out.println(dni2 + " no es un dni válido");
        
        // La expresión regular "\\d{4}[\\s][A-Z]{3}" valida una matrícula con cuatro dígitos, un espacio y tres letras
        String matricula1 = "1234 ABC";
		String matricula2 = "1234ABC";
        String patronMatricula =  "\\d{4}[\\s][A-Z]{3}";  
        
        if(matricula1.matches(patronMatricula) == true)
        	System.out.println(matricula1 + " es una matrícula válido");
        else
        	System.out.println(matricula1 + " no es una matrícula válida");
        
        if(matricula2.matches(patronMatricula) == true)
        	System.out.println(matricula2 + " es una matrícula válido");
        else
        	System.out.println(matricula2 + " no es una matrícula válida");
        	
	}
}
