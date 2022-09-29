package DayThree;
import java.util.Scanner;
/**
 * @author Anthony Simbaña
 * ¿Qué deberías presentar?
 * 1. Programa que tome como entrada los puntos de coordenadas y las horas (si es necesario) que se demora en cada trabajo (cada punto) y retorne el orden que el usuario tiene que seguir si decide trabajar por distancias (Mira la primera lista).
 * 2. Programa que tome como entrada los puntos de coordenadas y las horas (si es necesario) que se demora en cada trabajo (cada punto) y retorne el orden que el usuario tiene que seguir si decide trabajar por horas (Mira la segunda lista).
 */
public class OrdenamientoElementros {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de pares a ordenar");
        int numPares = s.nextInt();
        Object datos[][]=obtenerDatos(numPares);
        int option=0;
        do{
            System.out.println("\n1. Orden por distancia"+
                           "\n2. Orden por horas" +
                           "\n3. Salir");
            option = s.nextInt();
            switch(option){
                case 1: ordenPorDistancia(datos);break;
                case 2: ordenPorHoras(datos); break;
                default: break;
            }
        }while(option!=3);
        
    }  
    
    //Metodo para ingresar los datos (Pares) desde consola y almacenarlos en un arreglo de objetos
    public static Object[][] obtenerDatos(int numPares) {
        Scanner s = new Scanner(System.in);
        Object datos[][]=new Object[numPares][4];
        for(int i=0; i<numPares ;i++){
            System.out.println("Par : " + i); 
            System.out.print("Letra: "); datos[i][0] = s.nextLine();
            System.out.print("Valor X: "); datos[i][1] = s.nextLine();
            System.out.print("Valor Y: "); datos[i][2] = s.nextLine();
            System.out.print("Duración: "); datos[i][3] = s.nextLine();
        }
        return datos;
    }

    //Metodo que ordena los pares considerando su cercania
    public static void ordenPorDistancia(Object[][] datos) {
        Object aux1=null,aux2=null, aux3=null ,aux4=null;
        float auxf1=0;
        float[] distancias = obtenerDistancia(datos);
        for (int i = 0; i < distancias.length - 1; i++) {
            for (int j = 0; j < distancias.length - i - 1; j++) {                                                              
                if (distancias[j + 1] < distancias[j]) {
                    auxf1 = distancias[j + 1];
                    distancias[j + 1] = distancias[j];
                    distancias[j] = auxf1;

                    aux1=datos[j+1][0];
                    aux2=datos[j+1][1];
                    aux3=datos[j+1][2];
                    aux4=datos[j+1][3];

                    datos[j+1][0]=datos[j][0];
                    datos[j+1][1]=datos[j][1];
                    datos[j+1][2]=datos[j][2];
                    datos[j+1][3]=datos[j][3];

                    datos[j][0] =aux1;
                    datos[j][1] =aux2;
                    datos[j][2] =aux3;
                    datos[j][3] =aux4;
                }
            }
        }
        printOrdenDatos(datos);
    }

    //Metodo para obtener la distancia de on arreglo de objetos
    public static float[] obtenerDistancia(Object[][] A) {
        float dis[] = new float[A.length];
        int indiceRandomico = (int)Math.random()*A.length;
        System.out.println("Punto de partida aleatorio es:" 
        + A[indiceRandomico][0].toString()+"\n");
        for(int i = 0 ;i <A.length; i++){
            int x=Integer.parseInt(A[i][1].toString());
            int y=Integer.parseInt(A[i][1].toString());
            dis[i]=(float)Math.sqrt(x*x+y*y);
        }
        return dis;
    }
    
    //Metodo para ordenar los pares por las horas de duración
    public static void ordenPorHoras(Object[][] datos) {
        double anterior=0, posterior=0;
        Object aux1=null,aux2=null, aux3=null ,aux4=null;
        for (int i = 0; i < datos.length - 1; i++) {
            for (int j = 0; j < datos.length - i - 1; j++) {   
                posterior=Double.parseDouble(datos[j+1][3].toString());
                anterior=Double.parseDouble(datos[j][3].toString());
                if (posterior > anterior) {

                    aux1=datos[j+1][0];
                    aux2=datos[j+1][1];
                    aux3=datos[j+1][2];
                    aux4=datos[j+1][3];

                    datos[j+1][0]=datos[j][0];
                    datos[j+1][1]=datos[j][1];
                    datos[j+1][2]=datos[j][2];
                    datos[j+1][3]=datos[j][3];

                    datos[j][0] =aux1;
                    datos[j][1] =aux2;
                    datos[j][2] =aux3;
                    datos[j][3] =aux4;
                }
            }
        }
        printOrdenDatos(datos);
    }

    //Metodo para imprimir los datos en el orden que se encuentren
    public static void printOrdenDatos(Object[][] datos){
        for(int i=0; i<datos.length;i++){
            System.out.println((i+1) + "." 
            +datos[i][0]+ " "
            +datos[i][1]+ " "
            +datos[i][2]+ " "
            +datos[i][3]);
        }
    }

    
}
