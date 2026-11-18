package primerTrimestre;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Una expresión regular es un patrón que nos permite identificar o validar si una entrada
 * de texto cumple con ciertos requisitos establecidos previamente. Establecemos el patrón
 * mediante un String y siguiendo unos códigos establecidos
 */

/*
 * Las reglas básicas
 * 
 * a		- El caracter a y ningún otro
 * a.c 		- El punto valida cualquier caracter (abc, a3c...)
 * [abc] 	- Uno de los caracteres (a, b o c)
 * [a-z]	- Un caracter en el rango indicado (a, p, x...) siguen la tabla ascci (la ñ no está incluida)
 * [^aeiou]	- Cualquiera excepto estos (1, n, P...)
 * \d		- Un dígito cualquiera
 * \w		- Una letra, un dígito o el signo de subrayado _
 * \s		- Un espacio, un tabulador o un salto de línea
 * NOTA: Las barras hay que duplicarlas ya que van en un String
 * 
 * CARDINALIDAD:
 * *		- 0 o mas veces
 * +		- 1 o mas veces
 * ? 		- 0 o 1 vez
 * {n}		- exactamente n veces
 * {n,m}	- entre n y m veces (ambas incluidas
 * {n,}		- n o mas veces
 * ^Hola	- Valida la cadena Hola si está al inicio
 * mundo$	- Valida la cadena mundo si está al final
 * a|b		- Alternativa (o a o b)
 * 
 * Todas estas reglas se pueden combinar entre si
 * Cuidado que el acento ^ significa cosas diferentes si va dentro de un corchete o no
 */

public class ExpresionesRegulares {
	public static void main(String[] args) {
		// La forma más cómoda para buscar una coincidencias exactas con una expresión regular
		// es usar el método matches de la clase String
		String dni1 = "12345678";
		String dni2 = "12345678S";
        String patronDNI =  "\\d{8}[A-Z]"; // El patrón ahora son 8 dígitos seguidos de una letra en mayúsculas  
        
        // En este caso el patrón si que tiene que coincidir exactamente con la cadena. Si tiene algo adicional evalúa como false
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
        	System.out.println(matricula1 + " es una matrícula válida");
        else
        	System.out.println(matricula1 + " no es una matrícula válida");
        
        if(matricula2.matches(patronMatricula) == true)
        	System.out.println(matricula2 + " es una matrícula válida");
        else
        	System.out.println(matricula2 + " no es una matrícula válida");
        
        // Algunos ejemplos de patrones un poco mas complejos:
        String consonantes = "[A-ZÑ && [^AEIOU]]{5}"; // valida cinco letras consonantes mayúsculas
        if("QÑERT".matches(consonantes) == true)
        	System.out.println("sólo tiene consonantes");
        else
        	System.out.println("tiene alguna vocal");
        
        String meses = "[1-9]|1[0-2]"; // valida un mes entre el 1 y el 12, ambos incluidos
        if("3".matches(meses) == true)
        	System.out.println("es un mes válido");
        else
        	System.out.println("no es un mes válido");
        
        /*
		 * Para buscar coincidencias no exactas usamos las clases Pattern y Matcher
		 * Pattern me permite definir el patrón que busco
		 * Matcher me identificará si ese patrón existe o no en una cadena de texto concreta.
		 */
		
		Pattern patron = Pattern.compile("\\d{8}");
		// Este segundo patrón es equivalente al anterior
		Pattern patron2 = Pattern.compile("[0-9]{8}");
		
		Matcher coincidencia = patron.matcher("28896");
		// En este caso el patrón no coincide. El texto no tiene 8 dígitos
		if(coincidencia.find() == true)
			System.out.println("El patrón coincide");
		else
			System.out.println("El patrón no coincide");
		
		coincidencia = patron2.matcher("X12345678P");
		// En este caso si coincide. El patrón tiene 8 dígitos seguidos. No importa si tiene algo adicional
		// Busca que haya una coincidencia, que el patrón exista dentro de la cadena
		if(coincidencia.find() == true)
			System.out.println("El patrón coincide");
		else
			System.out.println("El patrón no coincide");
		
		// Si quiero usar este método pero buscar una coincidencia exacta uso matches en lugar de find
		Pattern.compile("\\d{8}");
		coincidencia = patron.matcher("28896111");
		if(coincidencia.matches() == true)
			System.out.println("El patrón coincide");
		else
			System.out.println("El patrón no coincide");
		
		// Matcher.matches() y String.matches() son equivalentes en los casos básicos, pero Matcher es mucho mas potente
		// y tiene funcionalidades adicionales que no vamos a ver. También es más rápido cuando tenemos que hacer muchas
		// comparaciones contra el mismo patrón  
	}
}
