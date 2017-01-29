/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiacifras;

/**
 *
 * @author hectoralbertosantosrodriguez
 */
public class Operar {
    private int op1;
    private int op2;
    private char operador;
    private int resultado;
    
    public Operar(int op1, int op2, char operador, int resultado) {
        this.op1 = op1;
        this.op2 = op2;
        this.operador = operador;
        this.resultado = resultado;
    }

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
      
}
