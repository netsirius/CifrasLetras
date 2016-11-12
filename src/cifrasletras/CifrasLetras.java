/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrasletras;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author netsirius
 */
public class CifrasLetras {
    private static final Random r = new Random();
    /**
     * A partir de un numero n, n numeros del rango (1-10, 35, 75 i 100).
     * @param n
     * @return array con las cifras generadas
     */
    public int[] generarCifras(int n){
        int cifras[] = new int[n*5];
        int rangos[] = {10,25,50,75,100};
        for (int i = 0; i < cifras.length; i++) {
            for (int j = 0; j < rangos.length; j++) {
                cifras[i] = r.nextInt(rangos[j])+1; 
            }
        }
        Arrays.sort(cifras);
        return cifras;
    }
    /**
     * Generamos numero k, es el número al cual hay que aproximarse o obtener a aprtir de
     * las operaciones elementales (+, -, ×, ÷) realizadas con las cifras generadas.
     * @return numero esperado k
     */
    public int numk(){
        int k = r.nextInt(10000)+101;
        return k;
    }
}
