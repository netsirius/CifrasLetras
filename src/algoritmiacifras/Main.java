/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiacifras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author hectoralbertosantosrodriguez
 */
public class Main {
    
    private static final int N = 10;
    private static final Random r = new Random();
    public static void main(String[] args) {
        ArrayList<Integer> numeros = generarCifras(N);
        int meta = numk();
        AlgoritmiaCifras cifras = new AlgoritmiaCifras(meta,numeros);
        System.out.println("META: " + meta);
        if (cifras.resuelve(meta)) System.out.println("Solución: ");
        else System.out.println("Aproximación: ");
        System.out.println(numeros);
        cifras.escribeOperaciones();
        
    }
    
        /**
     * Generamos numero k, es el número al cual hay que aproximarse o obtener a aprtir de
     * las operaciones elementales (+, -, ×, ÷) realizadas con las cifras generadas.
     * @return numero esperado k
     */
    private static int numk(){
        int k = r.nextInt(10000)+101;
        return k;
    }
    
        /**
     * A partir de un numero n, n numeros del rango (1-10, 35, 75 i 100).
     * @param n
     * @return array con las cifras generadas
     */ 
    private static ArrayList<Integer> generarCifras(int n){
        ArrayList<Integer> cifras = new ArrayList<>();
        int rangos[] = {0,1,2,3,4,5,6,7,8,9,10,25,50,75,100};
        for (int i = 0; i < n; i++) {
            cifras.add(rangos[r.nextInt(14)+1]);
        }
        Collections.sort(cifras);
        return cifras;
    }
}
