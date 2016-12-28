/*
 * Generador de combinaciones de una lista de elementos de tamaño k tomadas de n en n.
 */
package combinaciones;

import java.util.Stack;

/**
 *
 * @author Javier Triviño
 */
public class Generador {
    private Integer[] elementos;
    private Combinacion[] combinaciones;
    private Stack<Combinacion> pilaCombinaciones;
    private Stack<Integer> pila;
    private int k, n;

    public Generador(Integer[] elementos, int n) throws Exception {
        if(elementos.length < n) throw new Exception("El tamaño de la lista debe ser más grande o igual que n. (k="+elementos.length+", n="+n);
      
        this.k = elementos.length-1;
        this.n = n;
        
        this.pila = new Stack<>();
        this.elementos = elementos;
        this.pilaCombinaciones = new Stack();
    }
    
    public Combinacion[] generar(){
        combinar();
        
        return combinaciones;
    }
    private void combinar(){
        for (int i = 0; i < n; i++) {
            pila.add(i);
        }
        saveState();
        combine();
        
        combinaciones = new Combinacion[pilaCombinaciones.size()];
        int i = 0;
        while (!pilaCombinaciones.empty()) {
            combinaciones[i++] = pilaCombinaciones.pop();
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
        System.out.println(pilaCombinaciones.size());
        pilaCombinaciones.push(new Combinacion(combinacion));
    }
}
