package DayTwo;
import java.util.Scanner;
/**
 * @author Anthony Simbaña
 * 
 * Un poco de contexto:
Supongamos que tenemos la siguiente cadena de caracteres que es ingresada por el usuario:

4$$E&95KPfjT$%TJ7#6T2%tcnS#3$^

En esta cadena existen 5 caracteres especiales los cuales pueden ser "!@#$%^&*" y 5 números. 


 * ¿Qué deberías presentar?
1.	🧑‍💻 Programa un bloque o función que retorne la cantidad de letras que existe en la cadena.
2.	👩‍💻 Programa un bloque o función que retorne la cantidad de dígitos que existe en la cadena.
3.	👨‍💻Programa un bloque o función que retorne la cantidad de dígitos indicado por el usuario, sea mayúscula o minúscula de la cadena; es decir el usuario ingresa "^" y el programa muestra 1, esto para el ejemplo de la cadena anterior.

 */
public class Caracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una cadena cualquiera");
        String cadena = s.nextLine();
        System.out.println("La cadena ingresada es: " + cadena);
        System.out.println("# de letras: "+ cantidadLetras(cadena));
        System.out.println("# de digitos: "+ cantidadDigitos(cadena));
        System.out.print ("Ingrese un caracter de la cadena: "); char c = s.nextLine().charAt(0);
        System.out.println("\n# del caracter "+ c + " es: " + cantidadCaracter(cadena, c));
    }

    public static int cantidadLetras(String cadena){
        int numeroLetras = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.substring(i,i+1).matches("[A-Za-z]")) {
                numeroLetras++;
            }
        }
        return numeroLetras;
    }

    public static int cantidadDigitos(String cadena){
        int numeroDigitos = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.substring(i,i+1).matches("[0-9]")) {
                numeroDigitos++;
            }
        }
        return numeroDigitos;
    }

    public static int cantidadCaracter(String cadena, char s){
        int repeticionCaracter = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i)==(s)) {
                repeticionCaracter++;
            }
        }
        return repeticionCaracter;
    }
    
}
