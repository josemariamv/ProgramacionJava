package segundoTrimestre;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FechasyHoras {
	public static void main(String[] args) {

		// Crea un objeto de tipo LocalDate y lo inicializa a la fecha de hoy
		LocalDate fecha = LocalDate.now();
		System.out.println(fecha);

		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yy");
		String fechaconFormato = fecha.format(formato1);
		System.out.println("Fecha correctamente formateada: " + fechaconFormato);

		formato1 = DateTimeFormatter.ofPattern("E, dd-MMM-yyyy");
		fechaconFormato = fecha.format(formato1);
		System.out.println("Fecha correctamente formateada: " + fechaconFormato);

		formato1 = DateTimeFormatter.ofPattern("EEEE, dd  MMMM yyyy");
		fechaconFormato = fecha.format(formato1);
		System.out.println("Fecha correctamente formateada: " + fechaconFormato);

		// Crea un objeto de tipo Localtime y lo inicializa con la hora actual
		LocalTime hora = LocalTime.now();
		System.out.println(hora);

		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaconFormato = hora.format(formato2);
		System.out.println("Hora correctamente formateada: " + horaconFormato);

		formato2 = DateTimeFormatter.ofPattern("HH:mm:ss a");
		horaconFormato = hora.format(formato2);
		System.out.println("Hora correctamente formateada: " + horaconFormato);

		// Fecha y hora simultaneamente
		LocalDateTime fechayHora = LocalDateTime.now();
		System.out.println(fechayHora);

		DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
		String fechayHoraconFormato = fechayHora.format(formato3);
		System.out.println("Fecha correctamente formateada: " + fechayHoraconFormato);

		// Inicializarla con una fecha
		LocalDate fechaEspecifica = LocalDate.of(1968, 10, 8);
		System.out.println(fechaEspecifica);
		formato1 = DateTimeFormatter.ofPattern("EEEE, dd/MMMM/yy");
		fechaconFormato = fechaEspecifica.format(formato1);
		System.out.println("Fecha correctamente formateada: " + fechaconFormato);
		
		formato1 = DateTimeFormatter.ofPattern("EEEE");
		fechaconFormato = fechaEspecifica.format(formato1);
		System.out.println("Día de la semana: " + fechaconFormato);
		formato1 = DateTimeFormatter.ofPattern("MMMM");
		fechaconFormato = fechaEspecifica.format(formato1);
		System.out.println("Mes: " + fechaconFormato);
		

		LocalTime horaEsp = LocalTime.of(10, 15);
		System.out.println(horaEsp);
		horaEsp = LocalTime.of(10, 15, 30);
		System.out.println(horaEsp);
		horaEsp = LocalTime.of(10, 0);
		System.out.println(horaEsp);

		// Inicializar un objeto tipo fecha u hora a partir de una cadena de texto
		String fechaTxt = "08/10/1968";
		DateTimeFormatter formato4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate fecha2 = LocalDate.parse(fechaTxt, formato4);
		System.out.println("Fecha: " + fecha2);

		String horaTxt = "13:42";
		DateTimeFormatter formato5 = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime hora2 = LocalTime.parse(horaTxt, formato5);
		System.out.println("Hora: " + hora2);

		// Añadir o restar días u horas
		// Los objetos de fecha y hora son inmutables. No se pueden modificar directamente
		fechaEspecifica = fechaEspecifica.plusDays(365);
		System.out.println(fechaEspecifica);

		System.out.println(horaEsp);
		horaEsp = horaEsp.plusHours(1);
		horaEsp = horaEsp.plusMinutes(15);
		System.out.println(horaEsp);
		horaEsp = horaEsp.minusHours(3);
		horaEsp = horaEsp.minusMinutes(18);
		System.out.println(horaEsp);

		LocalDate hoy = LocalDate.now();
		LocalDate manyana = hoy.plusDays(1);
		System.out.println("Mañana: " + manyana);

		LocalDate mesPasado = hoy.minusMonths(1);
		System.out.println("El mes pasado: " + mesPasado);

		LocalDate enTresAnyos = hoy.plusYears(3);
		System.out.println("Dentro de 3 años: " + enTresAnyos);

		// Comparar fechas y horas
		if (fechaEspecifica.isBefore(fecha))
			System.out.println(fechaEspecifica + " es anterior " + fecha);
		else
			System.out.println(fechaEspecifica + " no es anterior " + fecha);

		if (fecha.isAfter(fechaEspecifica))
			System.out.println(fecha + " es posterior " + fechaEspecifica);
		else
			System.out.println(fecha + " no es posterior " + fechaEspecifica);

		if (horaEsp.isBefore(hora))
			System.out.println(horaEsp + " es anterior " + hora);
		else
			System.out.println(horaEsp + " no es anterior " + hora);

		// obtener el día, el mes, los minutos, etc.
		System.out.println(hora.getMinute() + " minutos");
		System.out.println(hora.getHour() + " horas");
		System.out.println(hora.getSecond() + " segundos");

		System.out.println(fecha.getDayOfYear());

		System.out.println(fecha.getDayOfMonth());
		System.out.println(fecha.getYear());
		System.out.println(fecha.getYear());
		System.out.println(fecha.getMonthValue());

		// Es complicado obtenerlo en castellano y tenemos el método visto antes con el formatter
		System.out.println(fecha.getMonth());
		System.out.println(fecha.getDayOfWeek());

	}
}
