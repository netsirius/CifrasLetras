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
public class AlgoritmiaCifras {
    
    private final int BUSCADOS = 1000;
    private ArrayList<Integer> numeros = new ArrayList<>();; 
    private ArrayList<Operar> operaciones = new ArrayList<>();
    private ArrayList<Operar> mejorOperaciones = new ArrayList<>();
    private ArrayList<Boolean> encontrado = new ArrayList<>();
    private int meta, totalEncontrados,mejor;
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

    public AlgoritmiaCifras(int meta,ArrayList<Integer> numeros) {
        this.meta = meta;
        this.numeros = numeros;
        for (int i = 0; i < BUSCADOS; i++) {
            encontrado.add(Boolean.FALSE);
        }
        this.totalEncontrados = 0;
        this.mejor = -1;
        this.ops = "+-*/";
        marcar(0);
    }
    
    public boolean resuelve(int meta){
        
        // resolvemos recursivamente tofas las posibilidades
        boolean resuelto = resuelve_rec(meta, numeros.size());
        
        normalizaOperaciones();
        return resuelto;
    }
    
    private boolean resuelve_rec(int meta, int size){
        
        Operar opActual;
        
        if (size < 2) return false;
        //Cojemos el primer número disponinle
        for (int i = 0; i < size-1; i++) {
            int a = numeros.get(i);
            if (a !=0) {
                numeros.set(i, numeros.get(size-1));
            } else continue;
            
            //Cojemos el segundo número dispoible
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
                    opActual = new Operar(c, d, ops.charAt(op), resultado);
                    operaciones.add(opActual);
                    
                    //Intentamos resolver o mejorar el nuevo número, sin pasarnos
                    if (Math.abs(meta-resultado) < Math.abs(meta-mejor)) {
                        mejor = resultado;
                        mejorOperaciones = (ArrayList<Operar>) operaciones.clone();
                        
                        if (resultado == meta) {
                            return true;
                        }
                    }
                    
                    // Marcamos el nuevo resultado y compruebamos si están todos marcados
                    if (marcar(resultado)) {
                        return true;
                    }
                    
                    // Guardamos el nuevo resultado y siguimos buscando
                    numeros.set(size-2, resultado);
                    if (resuelve_rec(meta, size-1)) {
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
    
    public void escribeOperaciones(){
        for (Operar it : mejorOperaciones) {
            System.out.println("Operación: " + it.getOp1() + it.getOperador() + it.getOp2() + " = " + it.getResultado());
        }
    }
    
    private boolean marcar(int n) {
        if (n<1000 && !encontrado.get(n)) {
            encontrado.set(n, true);
            totalEncontrados--;
            if (totalEncontrados == BUSCADOS) {
                return true;
            }
        }
        return false;
    }
    
    public void imprimeRestantes(){
        for (int i = 0; i < BUSCADOS; i++) {
            if (!encontrado.get(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
    
    public boolean todosMarcados(){
        boolean todos = true;
        for (int i=0; i<BUSCADOS && todos; ++i){
            todos = encontrado.get(i);
        }
        return todos;
    }
    
    private void normalizaOperaciones(){
        int size = mejorOperaciones.size();
        int posEscribir = size-2;
        if (posEscribir >=0) {
            buscaOperandos(mejorOperaciones.get(size-1), posEscribir);
            for (int i = 0; i < posEscribir+1; i++) {
                mejorOperaciones.remove(i);
            }
        }
    }
    
    private void buscaOperandos(Operar unaCuenta, int posEscribir){
        boolean unoEncontrado = false,otroEncontrado = false;
        int j = posEscribir;
        int unOperando = unaCuenta.getOp1(), otroOperando = unaCuenta.getOp2();
        
        while ((!unoEncontrado || !otroEncontrado) && j>=0) {            
            if ((mejorOperaciones.get(j).getResultado() == unOperando) ||
                (mejorOperaciones.get(j).getResultado()==otroOperando)) {
                
                if (unoEncontrado) {
                    otroEncontrado = true;
                }else{
                    unoEncontrado = true;
                }
                
                Operar aux = new Operar(mejorOperaciones.get(j));
                mejorOperaciones.set(j, mejorOperaciones.get(posEscribir));
                mejorOperaciones.set(posEscribir, aux);
                posEscribir--;
                
                buscaOperandos(mejorOperaciones.get(posEscribir+1),posEscribir);
                j = posEscribir;
                
            }else{
                j--;
            }
        }
        
    }
    
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
