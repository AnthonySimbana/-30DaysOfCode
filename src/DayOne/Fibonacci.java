package DayOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Anthony Simbaña
 */

public class Fibonacci {
    //Obtiene la serie de Fibonacci dado un valor n
    public static List serie(int n){
        int a=0,b=1,c=0;
        List serie = new ArrayList();
        serie.add(a);
        serie.add(b);
        if(n>2){
            for(int i=0;i<n-2;i++){
            c=nextFibonacci(a, b);
            a=b;
            b=c;
            serie.add(c);
            }
        }
        return serie;
    }
    
    public static int nextFibonacci(int a, int b){
        return a+b;
    }
    
    //Obtiene el n-eximo termino
    public static int nesimoTermino(List serie){
        int tamanio = serie.size()-1;
        int nesimoTermino = (int)serie.get(tamanio);
        return nesimoTermino;
    }
    
    //Suma todos los terminos de la serie
    public static int sumaNTerminos(List serie){
        int suma=0;
        for(Object aux : serie){
            suma+=(int)aux;
        }
        return suma;
    }
    
    //Imprime la serie
    public static void print(List serie){
        for(Object aux : serie){
            System.out.print(" " + aux);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        List serie = new ArrayList();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un numero n");
        
        try{
            int n=s.nextInt();
            serie = serie(n);
            System.out.println("\nLa serie de Fibonacci es:");
            print(serie);
            System.out.println("\nEl n-esimo numero es: ");
            System.out.println(nesimoTermino(serie));
            System.out.println("\nLa suma de todos los numeros es:");
            System.out.println(sumaNTerminos(serie));
        }catch(Exception e){
            System.err.println(e);
        }

    }
}
