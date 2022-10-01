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
        System.out.println("Ingrese la fecha de fin en formato: dd/mm/yyyy");
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

    //Calcula los dias entre dos fechas sin considerar los fines de semana
    public static float obtenerDiasLaborablesEntre(String fechaInicio, String fechaFin) throws ParseException{
        LocalDate fechaIn = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("d/M/yyyy") );
        LocalDate fechaFi = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("d/M/yyyy") );
        float noOfDaysBetween = (int)ChronoUnit.DAYS.between(fechaIn, fechaFi); //obtiene los dias entre fechas
        LocalDate newDate = fechaIn;
        int weekendDays=0;
        do{ //Cuenta los dias sabados y domingos existentes entre las dos fechas
            if(newDate.getDayOfWeek().toString().equalsIgnoreCase("SATURDAY") ||
               newDate.getDayOfWeek().toString().equalsIgnoreCase("SUNDAY")){
               weekendDays++; 
            }
            newDate = newDate.plusDays(1);
        }while(newDate.isBefore(fechaFi) || newDate.equals(fechaFi));
        noOfDaysBetween-=weekendDays;   //Disminuye de los dias totales los dias que corresponden a un fin de semana
        return noOfDaysBetween;
    }
    
    //Verifica que el tiempo a distribuir sea menor o igual que el que se dispone y calcula la distribución
    public static void distribuirHoras(float dias, float horas){
        float distSegundos=0;
        if(horas<=dias*24){
            distSegundos=horas*60*60/(dias);
            System.out.println(CalcularTiempo((int)distSegundos));
        }
    }   
    
    //Convierte los segundos en formato horas, minutos, segundos
    private static String CalcularTiempo(int tsegundos){
        int horas = (tsegundos / 3600);
        int minutos = ((tsegundos-horas*3600)/60);
        int segundos = tsegundos-(horas*3600+minutos*60);
        return "Tiempo a distribuir por dia es: "
        +horas+ ":" + minutos+ ":" + segundos 
        + " en formato hh:mm:ss";
    }
               
}
