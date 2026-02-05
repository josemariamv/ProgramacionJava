package pooAutoescuela;

public class Main {
	
	public static void main(String[] args) {
		new Pregunta("¿Qué señales son azules?", "informativas", "peligro", "no hay señales azules");
		new Pregunta("¿Velocidad máxima en autopistas?", "120", "60", "la que de tu coche");
		new Pregunta("¿Puedo circular en caballo por autovía?", "De ninguna forma", "En casos especiales",
				"Si, si llevas gorro de vaquero");
		new Pregunta("¿Quién tiene preferencia en un cruce?", "Quién esté señalizado. Si no, el de la derecha",
				"Siempre el de la derecha", "El que antes entre");
		
		Examen ex1 = new Examen(4, Pregunta.getListaPreguntas());
		ex1.mostrarExamen();
		ex1.corregirExamen();
		ex1.solucionExamen();
		
	}
}
