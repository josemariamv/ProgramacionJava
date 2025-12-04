package segundoTrimestre;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FechasyHoras {
	public static void main(String[] args){
		
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
	    
	    // Inicializar un objeto tipo fecha u hora no a partir de la actual, sino de una dada
	    String fechaTxt = "08/10/1968";
        DateTimeFormatter formato4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate fecha2 = LocalDate.parse(fechaTxt, formato4);
        System.out.println("Fecha: " + fecha2);
        
        String horaTxt = "13:42";
        DateTimeFormatter formato5 = DateTimeFormatter.ofPattern("HH:mm");
        
        LocalTime hora2 = LocalTime.parse(horaTxt, formato5);
        System.out.println("Hora: " + hora2);
	    
	}
}
