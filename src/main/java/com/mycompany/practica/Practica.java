
package com.mycompany.practica;
import java.util.*;

public class Practica {

    public static void main(String[] args) {
        //Pide el numero de bits de codigo
        Scanner scan = new Scanner(System.in);
        System.out.println("Cual es la longitud de tu mensaje");
        int longitud = scan.nextInt();
        int[] numeros = new int[longitud];
        //Codigo random
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * (1 - 0 + 1) + 0);
        }
        //Imprimir mensaje
        System.out.println("El codigo generado es: ");

        for (int k = 0; k < numeros.length; k++) {
            System.out.print(numeros[k]);
        }
        System.out.println("");
        //Calculo bits pariedad
        int Bits_Mensaje = longitud;
        int Pariedad;
        int Total_bits;
        int BitsPariedad;
        String Cal_Pariedad;

        Cal_Pariedad = Integer.toBinaryString(Bits_Mensaje);
        Pariedad = Cal_Pariedad.length();
        Pariedad = Pariedad + Bits_Mensaje;
        Cal_Pariedad = Integer.toBinaryString(Pariedad);
        BitsPariedad = Cal_Pariedad.length();
        Pariedad = Cal_Pariedad.length() + 1;
        Total_bits = Pariedad + Bits_Mensaje;

        System.out.println("Numero bits total: " + Total_bits);

        //Array con bits de pariedad
        int[] Codigo_final = new int[Total_bits];

        //Las potencias de 2
        int[] Potencias2 = new int[Pariedad];
        for (int x = 0; x < BitsPariedad; x++) {
            Potencias2[x] = (int) Math.pow(2, x);
        }

        int contadorpotencias = 0;
        int contadormensaje = 0;

        Codigo_final[0] = 2;

        for (int x = 1; x <= BitsPariedad; x++) {
            Codigo_final[Potencias2[contadorpotencias]] = 2;
            contadorpotencias++;
        }

        for (int y = 0; y < Total_bits; y++) {

            if (Codigo_final[y] != 2) {
                Codigo_final[y] = numeros[contadormensaje];
                contadormensaje++;
            }

        }

        for (int x = 0; x < Codigo_final.length; x++) {
            System.out.print(Codigo_final[x]);
        }
        System.out.println("");
        
        
    }
}