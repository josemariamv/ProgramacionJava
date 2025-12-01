package segundoTrimestre;


public class Poo1 {

	public static void main(String[] args) {
		// Creamos una variable de tipo Persona pero no lo inicializamos. No llamamos a su constructor
		// ni se reserva memoria para el. Cualquier llamada a un método de esa clase nos dará error
		// Porque el objeto aún no está creado. No existe aún
		Persona p1;
		// Para crear un objeto usamos el operador new y llamamos al constructor de la clase
		p1 = new Persona("José María", "Morales Vázquez");
		// Ahora ya podemos llamar a los métodos de la clase
		p1.mostrar();

		// También podemos hacerlo de una sola vez
		Persona p2 = new Persona("Isabel", "Gutiérrez Pérez");
		p2.mostrar();
		
		// Si tratamos de mostrar un objeto en consola veremos una referencia pero nada que nos sea útil 
		System.out.println(p1);
		// Si  tratamos de mostrar un atributo privado de un objeto no se nos dejará. ¡Es privado!
		// si lo defines como público si puedes hacerlo. Prueba a ver
		// System.out.println(p1.nombre);		
		
		// Si creamos un nuevo objeto usando una referencia existente o lo igualamos a null
		// java entiende que el anterior ya no nos sirve y liberará la memoria asignada al 
		// mismo de forma automática mediante su recolector de basura
		// si queremos realizar alguna acción antes de su destrucción creamos un método y lo invocamos nosotros
		// En Java no hay destructores
		p2.eliminaPersona();
		p2 = null;
		p1.eliminaPersona();
		p1 = new Persona("Andrés", "Pérez, Pérez");
		
		// Cuando una clase tiene mas de un constructor distingue a cual llamamos por los argumentos (número y tipo)
		// Por tanto podemos tener diferentes constructores pero siempre que haya una diferenciación en los argumentos de los mismos
		Persona p3 = new Persona("José María", "Morales Vázquez", 57);
		p3.aniversario();
		
		System.out.println(p3.cuantasPersonas());
		System.out.println(p1.cuantasPersonas());
	}
}
