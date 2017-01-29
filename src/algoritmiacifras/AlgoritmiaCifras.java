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
public class AlgoritmiaCifras {
    
    private ArrayList<Integer> numeros = new ArrayList<>();; 
    private ArrayList<Operacion> operaciones = new ArrayList<>();
    private ArrayList<Operacion> mejorOperaciones = new ArrayList<>();
    private int meta,mejor;
    private String ops;
    private enum Operaciones{
        SUM(0),
        SUB(1),
        MULT(2),
        DIV(3),
        NOP(4);
        private final int op;

        private Operaciones(int op) {
            this.op = op;
        }

        public int getOp() {
            return this.op;
        }
    }
    /**
     * Constructor de la clase, donde inicializamos todas las variables necesarias.
     * @param meta (La meta a la que queremos llegar mediante ciertas operaciones con los números)
     * @param numeros (La lista de números)
    */
    public AlgoritmiaCifras(int meta,ArrayList<Integer> numeros) {
        this.meta = meta;
        this.numeros = numeros;
        this.mejor = -1;
        this.ops = "+-*/";
    }
    
    /**
     * Devolvemos true si hemos encontrado la solución exacta, en caso conbtrario solo hemos podido aproximarnos y devolvemos false.
     * @param meta
     * @return 
     */
    public boolean cifras(int meta){  
        // resolvemos recursivamente tofas las posibilidades
        boolean resuelto = cifrasBacktracking(meta, numeros.size());
        return resuelto;
    }
    
    /**
     * Función recursiva, mediante backtracking, vamos llamando recursivamente al método creando en cada iteración una operación nueva. 
     * Por cada operación generada se va comprobando si es válida y si se hacerca mas al resultado. 
     * Las operaciones se van guardando para ser mostradas al llegar a un resultado.
     * @param meta
     * @param size
     * @return 
     */
    private boolean cifrasBacktracking(int meta, int size){
        
        Operacion opActual;
        
        if (size < 2) return false;
        //Cogemos el primer número disponinle
        for (int i = 0; i < size-1; i++) {
            int a = numeros.get(i);
            if (a !=0) {
                numeros.set(i, numeros.get(size-1));
            } else continue;
            
            //Cogemos el segundo número dispoible
            for (int j = i; j < size-1; j++) {
                int b = numeros.get(j);
                if (b != 0) {
                    numeros.set(j, numeros.get(size-2));
                }else continue;
                
                //Sobre los números escojidos probamos todas las operaciones
                for (int op = 0; op < Operaciones.NOP.getOp(); op++) {
                    //cogemos c como el mayor de ambos números
                    int c = (a > b) ? a:b; 
                    int d = (c==a) ? b:a;
                    //Comprobamos la valideza de la operación
                    boolean indivisible = ((c%d != 0) && op==Operaciones.DIV.getOp());
                    if (indivisible) {
                        continue;
                    }
                    
                    //Comprueba que la operación sea útil
                    int resultado = calcula(op, a, b);
                    boolean trivial = (resultado == a || resultado == b);
                    boolean zero = (resultado == 0);
                    boolean overwlof = (resultado < 0);
                    if (trivial || overwlof || zero) {
                        continue;
                    }
                    
                    //Calculamos y guardamos la operación
                    opActual = new Operacion(c, d, ops.charAt(op), resultado);
                    operaciones.add(opActual);
                    
                    //Intentamos resolver o mejorar el nuevo número, sin pasarnos
                    if (Math.abs(meta-resultado) < Math.abs(meta-mejor)) {
                        mejor = resultado;
                        mejorOperaciones = (ArrayList<Operacion>) operaciones.clone();
                        
                        if (resultado == meta) {
                            return true;
                        }
                    }
                    
                    // Guardamos el nuevo resultado y siguimos buscando
                    numeros.set(size-2, resultado);
                    if (cifrasBacktracking(meta, size-1)) {
                        return true;
                    }
                    
                    //Sacamos las operaciones
                    operaciones.remove(operaciones.size()-1);                    
                }
                
                numeros.set(size-2, numeros.get(j));
                numeros.set(j, b);
            }
            numeros.set(i, a);
        }
        return false;
        
    }
    /**
     * Mostramos la operación por consola
     */
    public void escribeOperaciones(){
        for (Operacion it : mejorOperaciones) {
            System.out.println("Operación: " + it.getOp1() + it.getOperador() + it.getOp2() + " = " + it.getResultado());
        }
    }
    
    /**
     * Calculamos a (op) b
     * @param op
     * @param a
     * @param b
     * @return 
     */
    private int calcula(int op,int a, int b){
        
        switch (op) {
            case 0:  
                return a+b;
            case 1:  
                return a-b;
            case 2:  
                return a*b;
            case 3:  
                return a/b;
            default: 
                return 0;
        }
        
    }
    
}
