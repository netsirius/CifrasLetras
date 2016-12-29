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
    private Combinacion[] combinaciones;
    private Stack<Combinacion> pilaCombinaciones;
    private Stack<Integer> pila;
    private int k, n;

    public Generador(int k, int n) throws Exception {
        if(k < n) throw new Exception("El tamaño de la lista debe ser más grande o igual que n. (k="+k+", n="+n);
        
        this.k = k-1; // Corrección
        this.n = n;
        
        this.pila = new Stack<>();
        this.pilaCombinaciones = new Stack();
    }
    
    public Combinacion[] generar() throws Exception{
        combinar();
        
        return combinaciones;
    }
    private void combinar() throws Exception{
        int nextInstruction = 1;
        
        for (int i = 0; i < n; i++) {
            pila.add(i);
        }
        saveState();
        
        while(nextInstruction != -1){
            nextInstruction = execute(nextInstruction);
        }
        
        combinaciones = new Combinacion[pilaCombinaciones.size()];
        int i = 0;
        while (!pilaCombinaciones.empty()) {
            combinaciones[i++] = pilaCombinaciones.pop();
        }
    }
    private int prepare(){
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
                return 1;
            } else {
                return 0;
            }
        }
        
        return -1;
    }  
    private int combine(){
        Integer i;
        
        i = pila.peek();
        while(i < k){
            pila.pop();
            i++;
            pila.push(i);
            saveState();
        }
        return 0;
    }   
    private void saveState(){
        Integer[] combinacion = new Integer[n];
        
        for (int i = 0; i < pila.size(); i++) {
           combinacion[i] = pila.get(i);
        }
        pilaCombinaciones.push(new Combinacion(combinacion));
    }
    
    private int execute(int instruction) throws Exception{
        switch(instruction){
            case 0:
                return prepare();
            case 1:
                return combine();
            default:
                throw new Exception("Unknown error");
        }
    }
}
