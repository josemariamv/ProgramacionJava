package primerTrimestre;

public class OpTernario {

	public static void main(String[] args) {
		/*
		* El operador ternario es la forma abreviada de una condicional binaria
		* en una sola línea elige entre dos valores según una condición
		* y ese valor se guarda en una variable o se usa dentro de otra instrucción
		* Se llama ternario porque tiene tres partes:
		* la condición, el valor si es verdadera y el valor si es falsa.
		*/
		int edad = 15;
		
		String resultado = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";
        System.out.println(resultado);
        
        // sería equivalente a:
        
        if(edad>=18)
        	resultado = "Eres mayor de edad";
        else
        	resultado = "Eres menor de edad";
        System.out.println(resultado);
        
        // lo más cómodo es la posibilidad de usarlo dentro de otra instrucción:
        System.out.println((edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad");
        
        // Las condicionales de este tipo se pueden anidar como un if else pero
        // en ese caso se vuelven tan complejas que no dejan de merecer la pena

	}

}
