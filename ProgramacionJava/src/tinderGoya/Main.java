package tinderGoya;

public class Main {

	public static void main(String[] args) {
		
		Tinder tinderGoya = new Tinder();
		
		Hombre h1 = new Hombre(tinderGoya, "Pepe", "12/08/1975", 0,35,50);
		Hombre h2 = new Hombre(tinderGoya, "Antonio", "22/10/1965", 2, 20, 60);
		Hombre h3 = new Hombre(tinderGoya, "Álvaro", "01/01/1990", 1);
		Mujer m1 = new Mujer(tinderGoya, "María", "23/12/1970", 2, 50, 70);
		Mujer m2 = new Mujer(tinderGoya, "Ines", "13/01/2000", 1);
		Otro o1 = new Otro(tinderGoya, "Jorge", "01/06/1980", 1);
		Otro o2 = new Otro(tinderGoya, "Valentina", "11/07/2005", 0, 18, 25);
			
		tinderGoya.buscaMatchAzar(h2);
		//tinderGoya.buscaMatches(h1);
	}
}
