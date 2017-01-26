/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiacifras;

import java.util.ArrayList;

/**
 *
 * @author hectoralbertosantosrodriguez
 */
public class Cifras {
    private ArrayList<Integer> contenedorNumeros; 

    public ArrayList<Integer> removeNumero() {
        int size = contenedorNumeros.size();
        contenedorNumeros.remove(size);
        return contenedorNumeros;
    }
    
    
}
