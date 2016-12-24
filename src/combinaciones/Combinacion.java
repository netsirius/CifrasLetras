/*
 * Generador de combinaciones de una lista de elementos de tamaño k tomadas de n en n.
 */
package combinaciones;

import java.util.Stack;

/**
 *
 * @author Javier Triviño
 */
public class Combinacion {
    private Integer[] elementos;
    private Stack<Integer[]> pilaCombinaciones;
    private Integer[][] combinaciones;
    private Stack<Integer> pila;
    private int k, n;

    public Combinacion(Integer[] elementos, int n) throws Exception {
        if(elementos.length < n) throw new Exception("El tamaño de la lista debe ser más grande o igual que n. (k="+elementos.length+", n="+n);
      
        this.k = elementos.length-1;
        this.n = n;
        
        this.pila = new Stack<>();
        this.elementos = elementos;
        this.pilaCombinaciones = new Stack();
    }
    
    public Integer[][] getCombinaciones(){
        combinar();
        
        return combinaciones;
    }
    private void combinar(){
        for (int i = 0; i < n; i++) {
            pila.add(i);
        }
        saveState();
        combine();
        
        combinaciones = new Integer[pilaCombinaciones.size()][];
        for (int i = 0; i < pilaCombinaciones.size(); i++) {
            combinaciones[i] = pilaCombinaciones.get(i);
        }
    }
    private void prepare(){
        Integer i;
        
        pila.pop();
        if(!pila.empty()){
            i = pila.peek();
            pila.pop();
            i++;
            pila.push(i);

            if(pila.peek() + (n - pila.size()) <= k){
                while(pila.size() < n){
                    i++;
                    pila.push(i);
                }
                saveState();
                combine();
            } else {
                prepare();
            }
        }
    }  
    private void combine(){
        Integer i;
        
        i = pila.peek();
        while(i < k){
            pila.pop();
            i++;
            pila.push(i);
            saveState();
        }
        prepare();
    }   
    private void saveState(){
        Integer[] combinacion = new Integer[n];
        
        for (int i = 0; i < pila.size(); i++) {
           combinacion[i] = elementos[pila.get(i)];
        }
        pilaCombinaciones.push(combinacion);
    }
}
