package DayFour;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anthony Simbaña
 */

public class Fechas {

    public static void main(String[] args) {
        try {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la fecha de inicio en formato: dd/mm/yyyy");
        String fechaInicial = s.nextLine();
        System.out.println("Ingrese la fecha de inicio en formato: dd/mm/yyyy");
        String fechaFinal = s.nextLine();
        System.out.println("Numero de horas a distribuir entre estas fechas");
        String horas = s.nextLine();
        float diasEntre = obtenerDiasLaborablesEntre(fechaInicial, fechaFinal);
        System.out.println("Existen " + (int)diasEntre + " dias entre: " + fechaInicial + " y " + fechaFinal);
        distribuirHoras(diasEntre, Long.parseLong(horas));
        } catch (ParseException ex) {
            Logger.getLogger(Fechas.class.getName()).log(Level.SEVERE, null, ex);
        }
                

    }

    public static float obtenerDiasLaborablesEntre(String fechaInicio, String fechaFin) throws ParseException{
        LocalDate fechaIn = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("d/M/yyyy") );
        LocalDate fechaFi = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("d/M/yyyy") );
        float noOfDaysBetween = (int)ChronoUnit.DAYS.between(fechaIn, fechaFi); 
        LocalDate newDate = fechaIn;
        int weekendDays=0;
        do{
            if(newDate.getDayOfWeek().toString().equalsIgnoreCase("SATURDAY") ||
               newDate.getDayOfWeek().toString().equalsIgnoreCase("SUNDAY")){
               weekendDays++; 
            }
            newDate = newDate.plusDays(1);
        }while(newDate.isBefore(fechaFi) || newDate.equals(fechaFi));
        noOfDaysBetween-=weekendDays;
        return noOfDaysBetween;
    }
    
    public static void distribuirHoras(float dias, float horas){
        float distSegundos=0;
        if(horas<dias*24){
            distSegundos=horas*60*60/(dias);
            System.out.println(CalcularTiempo((int)distSegundos));
        }
    }   
    
    private static String CalcularTiempo(int tsegundos){
        int horas = (tsegundos / 3600);
        int minutos = ((tsegundos-horas*3600)/60);
        int segundos = tsegundos-(horas*3600+minutos*60);
        return "Tiempo a distribuir por dia es: "
        +horas+ ":" + minutos+ ":" + segundos 
        + " en formato hh:mm:ss";
    }
               
}
