/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrasletras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author netsirius
 */
public class CifrasLetras {
    
    private static final Random r = new Random();
    private static int meta;
    private static int mejor;
    private static String mejorCamino;
    private static int diferencia;
    private int nodosTotales;
    private static int nodosVisitados;
    private static int N;
    private static int[] lista;
    private static String camino;
    private static boolean exito;

    public CifrasLetras(int numCifras) {
        this.meta = numk();
        this.lista = generarCifras(numCifras);
        this.N = numCifras;
        this.nodosTotales = -1;
        this.nodosVisitados = -1;
        this.exito = false;
    }
    
    public static void main(String[] args) {
        
        cambiarMejor(lista[0],camino);
        
        if (diferencia != 0) {
            exito = Buscar(lista, camino);
        }else{
            exito = true;
        }
        
    }
    
    /**
     * A partir de un numero n, n numeros del rango (1-10, 35, 75 i 100).
     * @param n
     * @return array con las cifras generadas
     */
    public static int[] generarCifras(int n){
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
    public static int numk(){
        int k = r.nextInt(10000)+101;
        return k;
    }
    
    public static boolean Buscar(int[] lista, String camino){
        return false;
    }
    
    public static void cambiarMejor(int nuevo, String nuevoCamino){
        mejor = nuevo;
        mejorCamino = nuevoCamino;
        diferencia = meta-mejor;
        
    }
}
