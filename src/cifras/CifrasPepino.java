/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author hecto
 */
public class CifrasPepino {
    
    public static List<ArrayList<String>> combinaciones = new ArrayList<>();
    public static List<String> combOrden = new ArrayList<String>();
    public static List<String> combOperadores = new ArrayList<String>();
    public static List<String> combOperandos = new ArrayList<String>();
    public static String operaciones = "+-*/";
    public static String opMejor = "";
    public static String exprMejor = "";
    public static final Random r = new Random();
    public static int resMejor = 0,n=8,meta = numk();
    public static PostFix post= new PostFix();
    public static int cont = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cifras("", 0);
    }
    
    
    public static void cifras(String exprActual, int resActual){ 
        String[] cifras = generarCifras(n);
        for (String cifra : cifras) {
            System.out.print(cifra + " ");
        }
        System.out.println("");
        String expr = "";
        for (int i = 0; i < n; i++) {
            if(i == 0)expr += cifras[i];
            else expr += " " +cifras[i];
        }
        for (int i = 0; i < n-1; i++) {
            expr += " *";
        }
        resActual = (int) post.evaluatePostfix(expr);
        if (resActual < meta) resMejor = resActual;
        else{
            generarPerm(cifras);
            generarExpr();
            System.out.println("meta: " + meta);
            System.out.println(exprMejor + " = " + resMejor);
        }
    }
    
    public static void comprobar(String exprActual, int resActual){
        if (resActual == meta || Math.abs(meta-resMejor)>Math.abs(meta-resActual)) {
            resMejor = resActual;
            exprMejor = exprActual;
        }
    }
    
    public static void generarPerm(String[] cifras){
        String str = generarOrden(n);
        permutarStr(str, "", combOrden);
        combinaciones.add((ArrayList<String>) combOrden);
        combinarOper(n-1, operaciones.toCharArray(), "");
        combinaciones.add((ArrayList<String>) combOperadores);
        permutarArr(0, cifras);
        combinaciones.add((ArrayList<String>) combOperandos);
    }
    
    public static void generarExpr(){
        for (String opOrd : combinaciones.get(0)) {
            for (String opOp : combinaciones.get(1)) {
                for (String opCifr : combinaciones.get(2)) {
                    String[] op = opOrd.split(" ");
                    String[] oper = new String[opOp.length()];
                    for (int i = 0; i < opOp.length(); i++) {
                        oper[i]=""+opOp.charAt(i);
                    }
                    String exprPolaca = "";
                    String[] numeros = opCifr.split(" ");
                    int contN = 0, contOp = 0;
                    for (int i = 0; i < op.length; i++) {
                        if (i==0) {
                            if (op[i].equals("1")){
                                exprPolaca += numeros[contN];
                                contN++;
                            }
                            else {
                                exprPolaca += oper[contOp];
                                contOp++;
                            }
                        }else{
                            if (op[i].equals("1")){
                                exprPolaca += " " + numeros[contN];
                                contN++;
                            }
                            else {
                                exprPolaca += " " + oper[contOp];
                                contOp++;
                            }
                        }
                    }
                    comprobar(exprPolaca, (int) post.evaluatePostfix(exprPolaca));
                }
            }
        }
    }
    
    public static String generarOrden(int n){
        String str = "";
        for (int i = 0; i < n-2; i++) {
            str += "1";
        }
        for (int i = 0; i < n-1; i++) {
            str += ".";
        }
        return str;
    }
    
    public static void permutarStr(String input, String output, List<String> combs) {
        if (input.equals("")) {
            char[] aux = output.toCharArray();
            if(aux[aux.length-1]!='1'){
                output = "1 1"+output;
                if(post.isPostfix(output))combs.add(output);
                //System.out.println("perm num " + cont++);
            }
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (input.indexOf(c, i + 1) != -1)
                continue;
            permutarStr(input.substring(0, i) + input.substring(i + 1), output + " " + c, combs);
        }
    }
    
    public static void combinarOper(int combLen, char[] caracteres, String comb) {
        if(comb.length() == combLen) {
            combOperadores.add(comb);
            //System.out.println("perm num " + cont++);
        } else {
            for (char c : caracteres) {
                String oldCurr = comb;
                comb += c;
                combinarOper(combLen,caracteres,comb);
                comb = oldCurr;
            }
        }
    }
    
    public  static void permutarArr(int start, String[] input ) {
        if (start == input.length) {
            String perm = "";
            for (int i = 0; i < input.length; i++) {
                if (i==0) perm += input[i];
                else perm += " " + input[i];
            }
            combOperandos.add(perm);
            //System.out.println("perm num " + cont++);
            return;
        }
        for (int i = start; i < input.length; i++) {
            // swapping
            String temp = input[i];
            input[i] = input[start];
            input[start] = temp;
           // swap(input[i], input[start]);

            permutarArr(start + 1, input);
           // swap(input[i],input[start]);

            String temp2 = input[i];
            input[i] = input[start];
            input[start] = temp2;
        }
    }
    
    public static int calcula(int op1,int op2, int operador){
        
        switch(operador){
            case 0:
                return op1+op2;
            case 1:
                return Math.abs(op1-op2);
            case 2:
                if (op1==1 || op2==1){
                    return 0;
                }
                else{
                    return op1*op2;
                }
            default:
                int aux=0;
                if (op2>op1){
                    aux=op1;
                    op1=op2;
                    op2=aux;
                }
                if (op2>1 && op1%op2==0){
                    return op1/op2;
                }
                else{
                    return 0;
                }
        }
    }
    
    /**
     * A partir de un numero n, n numeros del rango (1-10, 35, 50, 75 o 100).
     * @param n
     * @return array con las cifras generadas
    */
    public static String[] generarCifras(int n){
        String[] cf = new String[n];
        int numeros[] = {0,1,2,3,4,5,6,7,8,9,10,25,50,75,100};
        String cifr = "";
        for (int i = 0; i < n; i++) {
            cf[i] = ""+numeros[r.nextInt(14)+1];
        }
        Arrays.sort(cf);
        cifr += cf[0];
        for (int i = 1; i < cf.length; i++) {
            cifr += " "+cf[i];
        }
        return cf;
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
    
    public static int evaluatePostfixExpression(String postfixExpr) {
    Stack<Integer> s = new Stack<Integer>();
    String[] items   = postfixExpr.split(" ");

    for (String item : items) {
        try {
            s.push(Integer.valueOf(item));
        } catch (NumberFormatException e) {
            Integer value1 = s.pop();
            Integer value2 = s.pop();

            switch (item) {
                case "+":
                    s.push(value2 + value1);
                    break;
                case "-":
                    s.push(value2 - value1);
                    break;
                case "*":
                    s.push(value2 * value1);
                    break;
                case "/":
                    s.push(value2 / value1);
                    break;
            }
        }
    }

    return s.pop();
    }
    
    public static void swap(String[] arr, int i, int j ) {
       String t = arr[i];
       arr[i] = arr[j];
       arr[j] = t;
    }
    
}
