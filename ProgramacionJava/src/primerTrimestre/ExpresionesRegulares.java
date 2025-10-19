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
		
		// Veamo algún ejemplo mas
		
	}
}
