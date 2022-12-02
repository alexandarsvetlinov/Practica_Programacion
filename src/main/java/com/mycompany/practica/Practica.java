package com.mycompany.practica;

import java.util.*;

public class Practica {

    public static void main(String[] args) {
        //Pide el numero de bits de codigo
        Scanner scan = new Scanner(System.in);
        System.out.println("Cual es la longitud de tu mensaje");
        int Longitud = scan.nextInt();
        int[] Mensaje = new int[Longitud];
        //Codigo random
        for (int i = 0; i < Mensaje.length; i++) {
            Mensaje[i] = (int) (Math.random() * (1 - 0 + 1) + 0);
        }
        //Imprimir mensaje
        System.out.println("El codigo generado es: ");
        for (int k = 0; k < Mensaje.length; k++) {
            System.out.print(Mensaje[k]);
        }
        System.out.println("");

        //Calculo bits pariedad
        int Bits_Mensaje = Longitud;
        int Pariedad_Total;
        int Total_bits;
        int Bits_Pariedad;
        String Cal_Pariedad;

        Cal_Pariedad = Integer.toBinaryString(Bits_Mensaje);
        Pariedad_Total = Cal_Pariedad.length();
        Pariedad_Total = Pariedad_Total + Bits_Mensaje;
        Cal_Pariedad = Integer.toBinaryString(Pariedad_Total);
        Bits_Pariedad = Cal_Pariedad.length();
        Pariedad_Total = Cal_Pariedad.length() + 1;
        Total_bits = Pariedad_Total + Bits_Mensaje;

        System.out.println("Numero bits total: " + Total_bits);

        //Array que llevara el Codigo Final con la longitud del numero total de bits
        int[] Codigo_Final = new int[Total_bits];

        //Potencias de 2 guardades en un Array
        int[] Potencias2 = new int[Pariedad_Total];
        for (int x = 0; x < Bits_Pariedad; x++) {
            Potencias2[x] = (int) Math.pow(2, x);
        }
        //Ordeno el mensaje y los bits de pariedad dentro del Codigo final
        //Pongo el bit global los pongo a dos para ver mas facil donde estan situados
        Codigo_Final[0] = 2;

        int Contador_Potencias = 0;
        int Contador_mensaje = 0;
        //Situo un 2 donde estarian los bits de pariedad, la posicion es dada segun las potencias de dos
        for (int x = 1; x <= Bits_Pariedad; x++) {
            Codigo_Final[Potencias2[Contador_Potencias]] = 2;
            Contador_Potencias++;
        }
        //Una vez puestos los bits de pariedad inserto el mensaje, recorre el array, si ve un 2 para al siguiente.
        //Cada vez que pone 1 bit de mensaje suma uno al contator para que en el siguiente ciclo ponga el siguiente.
        for (int y = 0; y < Total_bits; y++) {
            if (Codigo_Final[y] != 2) {
                Codigo_Final[y] = Mensaje[Contador_mensaje];
                Contador_mensaje++;
            }
        }
        /*Poner los valores corespondientes a los bits de pariedad
        Coje la posicion de las potencias, recorre el array Haciendo Posicion bit de pariedad & Posicion
        Si el resultado es = a la posicion del bit de pariedad es que lo esta mirando.
        Cuenta la cantidad de 1 que esta mirando es par, pone el bit de pariedad en 0 y resetea el contador,
        si no, lo pone en 1 y resetea el contador
        */
        int ResultadoBitWise;
        int Contador = 0;
        for (int x = 0; x < Bits_Pariedad; x++) {
            for (int y = Potencias2[x] + 1; y < Total_bits - Potencias2[x] - 1; y++) {
                ResultadoBitWise = Potencias2[x] & y;
                if (ResultadoBitWise == Potencias2[x]) {
                    if (Codigo_Final[y] == 1) {
                        Contador++;
                    }
                }
            }
            if (Contador / 2 == 0) {
                Codigo_Final[Potencias2[x]] = 0;
                Contador = 0;
            } else {
                Codigo_Final[Potencias2[x]] = 1;
                Contador = 0;
            }
        }
        // Calculo el valor del bit global recorriendo el Array y contando los 1.
        for (int x = 1; x < Total_bits; x++) {
            if (Codigo_Final[x] == 1) {
                Contador++;
            }
        }
        if (Contador / 2 == 0) {
            Codigo_Final[0] = 0;
        } else {
            Codigo_Final[0] = 1;
        }     
        //Imprimo el codigo
        for (int x = 0; x < Codigo_Final.length; x++) {
            System.out.print(Codigo_Final[x]);
        }
        System.out.println("");
        //Un math random para calcular el numero de eerores e imprimo cuantos son.
        int Errores = (int) (Math.random() * (2 - 0 + 1) + 0);
        System.out.println("Numero de errores: " + Errores);
        int PosRandom;
        //Creo un unuevo array para poner los errores en el
        int Codigo_Errores[] = Codigo_Final;
        //Pongo el numero de errores en posiciones random
        for (int x = 0; x < Errores; x++) {
            PosRandom = (int) (Math.random() * Total_bits);
            if (Codigo_Errores[PosRandom] == 1) {
                Codigo_Errores[PosRandom] = 0;
            } else {
                Codigo_Errores[PosRandom] = 1;
            }
        }
        //Imprimo el codigo con los erroes
        for (int x = 0; x < Codigo_Errores.length; x++) {
            System.out.print(Codigo_Errores[x]);
        }
    }

}
