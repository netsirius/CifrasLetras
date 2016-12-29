/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinaciones;

import java.util.Arrays;

/**
 *
 * @author Javier Triviño
 */
public class Combinacion {
    private final int k;
    private final Integer[] combinacion;

    public Combinacion(Integer[] combinacion) {
        this.k = combinacion.length;
        this.combinacion = combinacion;
    }
    

    public Integer[] getCombinacion() {
        return combinacion;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(combinacion);
    }
    
    /**
     *
     * @param elementos Deben estar ordenados
     * @return
     * @throws Exception
     */
    public Character[] convertToLetras(Character[] elementos) throws Exception{
        if(elementos.length < k) throw new Exception("El tamaño del vector debe ser mayor o igual al tamaño de esta combinacion ("+k+")");
        
        Character[] newElementos = new Character[k];
        
        for (int i = 0; i < combinacion.length; i++) {
            newElementos[i] = elementos[combinacion[i]];
        }
        return newElementos;
    }
    
    
}
