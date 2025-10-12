
public class Cadenas {

	public static void main(String[] args) {
		/* Las cadenas de texto son objetos de Java. Aunque son básicos
		 * no podemos considerarlos tipos de datos simples como los int,
		 * los double o los boolean
		 */
		/* Creamos una variable de tipo texto de cualquiera de estas dos formas
		* En la segunda vemos claramente que es un objeto porque invocamos al
		* constructor igual que con otros objetos. Cualquiera de ambos métodos
		* es equivalente y no tenemos preferencia por usar uno u otro
		*/
		String texto = "Hola mundo";
		String texto2 = new String("Hola mundo");
		
		/*
		 * Una cosa muy importante respecto a los textos: no se pueden modificar directamente
		 * Para crear un nuevo texto a partir de la manipulación de otro siempre tenemos que crear
		 * un nuevo texto y construirlo con las modificaciones que queremos
		 */
		
		// El operador + está "sobrecargado". Cuando se usa con textos los concatena
		String texto3 = "Hola" + " mundo";
		System.out.println(texto3);
		
		// El método concat también concatena textos
		String texto7 = texto3.concat(" cruel");
		System.out.println(texto7);
		
		// Podemos combinar textos y números con el operador + Java se da cuenta de 
		// que no podemos sumar un texto con un número y convierte automáticamente
		// ese número en texto para unirlo al resto del mensaje
		int contador = 5;
		String texto4 = "Tenemos " + contador + " elementos";
		System.out.println(texto4);
		
		// El método lenght me devuelve la longitud (número de caractéres) de un texto
		System.out.println(texto4.length());
		// Importante: podemos usar cualquier método de texto sobre una variable, como 
		// en la línea anterior, pero también sobre un texto entrecomillado, como en 
		// la siguiente
		System.out.println("Hola mundo".length());
		
		// El método charAt me devuelve el caracter que está en la posición que ponemos
		// como argumento entre paréntesis.
		// Dos cosas importantes: lo que me devuelve es de tipo char y no String
		// Y dos: recuerda que la primera posición del texto es la 0 y no la 1
		System.out.println(texto3.charAt(1));
        
		// De esta forma recorremos una cadena de texto de izquierda a derecha
        for(int i=0; i<texto3.length(); i++)
            System.out.println(texto3.charAt(i));
        
        // Y así al revés, de derecha a izquierda
        for(int i=texto3.length()-1; i>=0; i--)
            System.out.println(texto3.charAt(i));
		
        // Usamos el método equals para comparar si dos textos son iguales. Devuelve true si son iguales
        // y false si no lo son
		String texto5 = "HOLA MUNDO";
		if (texto3.equals(texto5) != true)
			System.out.println("No son iguales");
		
		// Tambien podemos comparar si dos textos son iguales usando el operador ==
		String texto6 = "HOLA MUNDO";
		if (texto5 == texto6)
			System.out.println("Son iguales");
		
		// equalsIgnoreCase hace lo mismo pero ignorando mayúsculas y minúsculas. "HOLA" sería igual que "hola"
		// y que "HoLa
		if (texto3.equalsIgnoreCase(texto5) == true)
			System.out.println("Son iguales sin tener en cuenta mayúsculas y minúsculas");
		
		// compareTo devuelve 0 si los textos son iguales, > 0 si texto8 (en este caso) fuese después que el argumento
		// (siguiendo el orden alfabético) y <0 si fuese antes 
		String texto8 = "abc";
		if(texto8.compareTo("def") < 0)
			System.out.println("abc va antes que def");
		else if (texto8.compareTo("def") > 0)
			System.out.println("abc va después que def");
		else
			System.out.println("abc es igual que def. Esto no va a ocurrir, verdad?");
		
		/* Esto no es correcto
		 * No se pueden comparar textos con operadores lógicos salvo en el caso de la igualdad
		if("abc" < "def")
			System.out.println("abc va antes que def");
		*/
		
		// Estos dos métodos devuelven una copia de la cadena convertida a minúsculas
		// o a mayúsculas respectivamente
		System.out.println(texto6.toLowerCase());
		System.out.println(texto4.toUpperCase());
		
		// el método substring me extrae un trozo del texto original.
		// En este primer caso me extrae la cadena desde la posición 5 (incluida) hasta el final
		System.out.println(texto6.substring(5));
		// En este segundo caso me extrae el trozo de texto entre la posición 5 (incluida) y la 8 (no incluida)
		System.out.println(texto6.substring(5,8));
		
		// Esto es una cadena vacia.
		String cadenaVacia = "";
		
		// el método isEmpty devuelve true si la cadena está vacía
		if(cadenaVacia.isEmpty())
			System.out.println("La cadena está vacía");
		
		// Y esto son dos formas de crear una cadena nula
		String cadenaNula = null; 
		String cadenaNula2;
		// Este segundo caso puede dar problemas si trato de verificar si es nula
		/*
		if(cadenaNula2 == null)
			System.out.println("La cadena es nula");
		*/
		
		// En el primer caso si que puedo hacer esta comparación
		if(cadenaNula == null)
			System.out.println("La cadena es nula");
		
		/* Cualquier referencia a una cadena nula provoca una excepción
		if(cadenaNula.isEmpty())
			System.out.println("La cadena está vacía");
		*/
		
		/* También provoca una excepción cualquier referencia a una posición
		 * de una cadena que no exista. En el siguiente caso la posición 4 no existe
 		String texto9="HOLA";
		System.out.println(texto9.charAt(4));
		 */
		
		// El método indexOf devuelve la posición en la que aparece por primera vez la subcadena
		// que va como argumento. Si no aparece devuelve -1
		int posicion = texto6.indexOf("a");
		System.out.println(posicion);
		posicion = texto6.indexOf("A");
		System.out.println(posicion);
		// Puede ponerse un caracter o una subcadena
		posicion = texto6.indexOf("DO");
		System.out.println(posicion);
		
		// replace nos devuelve una nueva cadena que sustituye todas las apariciones del primer argumento
		// por el segundo. 
		System.out.println(texto6.replace("O", "X"));
		// La cadena original no se ha modificado:
		System.out.println(texto6);
		// si quiero modificar la cadena original por la nueva puedo hacerlo así
		texto6 = texto6.replace("O", "X");
		System.out.println(texto6);
		// Igualmente pueden ser caracteres o subcadenas
		System.out.println(texto6.replace("LA", "*******"));

		// trim devuelve una nueva cadaena después de eliminar todos los espacios en blanco
		// a la derecha y a la izquierda de la original
        String dni = "             28888999X    ";
		System.out.println(dni);
		dni = dni.trim();
		System.out.println(dni);
		
		// Existen montones de funciones mas para tratar los textos. Y otros usos imaginativos y originales de estos
		// Aquí se recogen solo algunos de los métodos y usos para empezar a trabajar con cadenas de textos y
		// sus particularidades
	}
}