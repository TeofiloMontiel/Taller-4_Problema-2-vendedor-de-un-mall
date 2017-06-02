/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendedor.de.un.mall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Pc
 */
public class VendedorDeUnMall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader intro = new BufferedReader(new InputStreamReader(System.in));
        int horas;
        int sueldofinal = 0;
        Vector sueldosemanas = new Vector(4);
        for (int i = 1; i <= 4; i++) {
            horas = 0;
            do {
                try {
                    System.out.println("Ingrese numero de horas trabajadas en la semana numero " + i + " (Mayor o igual a 40)");
                    horas = Integer.parseInt(intro.readLine());
                    if (horas < 40) {
                        System.out.println("Cantidad de horas demaciado bajas, se requiere un mínimo de 40 horas");
                    }
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Datos ingresados no validos, por favor ingreselos nuevamente");
                }
            } while (horas < 40);
            int sueldo = (40 * 2000) + ((horas - 40) * 3000) + SueldoPorVentas(i);
            System.out.println("El sueldo del trabajador en la semana numero " + i + " es de " + sueldo + "\n");
            sueldosemanas.addElement(sueldo);
        }
        System.out.println("Resumen de pago por semana:");
        for (int cont = 0; cont < 4; cont++) {
            System.out.println("El sueldo de la semana numero " + (cont + 1) + " es de: " + sueldosemanas.elementAt(cont));
            sueldofinal = sueldofinal + (int) (sueldosemanas.elementAt(cont));
        }
        System.out.println("El sueldo total del trabajador es " + sueldofinal);
    }

    public static int SueldoPorVentas(int i) {
        int ventas = 0;
        int sueldoextra = 0;
        BufferedReader intro = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.println("Ingrese la cantidad  de ventas realizadas por el trabajador en la semana numero " + i);
                ventas = Integer.parseInt(intro.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Cantidad ingresada invalida, por favor ingrese datos validos");
            }
        } while (ventas < 0);
        if (ventas > 500000) {
            sueldoextra = (ventas / 100) * 10;
        } else {
            if (ventas > 300000) {
                sueldoextra = (ventas / 100) * 5;
            }
        }
        return sueldoextra;
    }
}
