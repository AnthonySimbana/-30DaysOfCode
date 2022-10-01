package DayFive;
import java.util.Scanner;


/**
 * @author Anthony Simbaña
 */

public class Tarjeta {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el numero de targeta de credito");
        String targeta = s.nextLine();
        if(targetaValida(targeta)){
            System.out.println("Targeta valida");
        }else{
            System.out.println("Targeta no valida");
        }            
    }

    public static boolean targetaValida(String numTarj) {
        int[] impares = new int[8];
        int[] pares = new int[8];
        //Extraigo los valores pares e impares
        for(int i=0; i<numTarj.length()/2; i+=1 ){
                pares[i]=Integer.parseInt(numTarj.substring(i*2, i*2+1));
                impares[i]=Integer.parseInt(numTarj.substring(i*2+1, i*2+2));
        }
        //Los valores pares se duplican y si son mayores a 9 les resta 9
        for(int i=0;i<pares.length;i++){
            int aux = pares[0]*2;
            if(aux>9){
                pares[0]=aux-9;
            }else{
                pares[0]=aux;
            }
        }
        //Realiza la suma total
        int suma=0;
        for(int i=0; i<numTarj.length()/2;i++){
            suma+=pares[i];
            suma+=impares[i];
        }
        return suma%10==0; //Verifica que la suma sea divisible para 10
    }


               
}
