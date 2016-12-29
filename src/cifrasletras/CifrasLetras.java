/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrasletras;

import combinaciones.Combinacion;
import combinaciones.Generador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        
//        cambiarMejor(lista[0],camino);
//        
//        if (diferencia != 0) {
//            exito = Buscar(lista, camino);
//        }else{
//            exito = true;
//        }

//        Combinacion[] combinaciones = new Generador(3, 2).generar();
//        Character[] word = new Character[]{'a','b','c'};
//        
//        for (Combinacion combinacion : combinaciones) {
//            System.out.println(Arrays.toString(combinacion.convertir(word)));
//        }
        
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
    
    /**
     * Lee todas las palabras del diccionario y genera otro diccionario con el siguiente formato:
     * $palabra_original$,$palabra_ordenada$
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static void ordenarDiccionario() throws FileNotFoundException, IOException{
        char[] originalWord, sortedWord;
        char[][] generatedWords;
        int i;
        final int WORDS_IN_DIC = 600000;
        
        BufferedReader dicOriginal = new BufferedReader(new FileReader("dic.txt"));
        FileWriter dicOrdenado = new FileWriter("dic_ordenado.txt");
        
        generatedWords = new char[WORDS_IN_DIC][];
        
        i = 0;
        originalWord = dicOriginal.readLine().toCharArray();
        while(originalWord[0] != '.'){ // Hasta llegar al final del fichero
            
            sortedWord = Arrays.copyOf(originalWord, originalWord.length);
            Arrays.sort(sortedWord);
            
            if(!existeDuplicado(generatedWords,sortedWord)){
                generatedWords[i] = sortedWord;
                
                dicOrdenado.write(sortedWord);
                dicOrdenado.write(',');
                dicOrdenado.write(originalWord);
                dicOrdenado.write(System.getProperty("line.separator"));
                
                i++;
            }
            if(i%10000 == 0)
                System.out.println(i);
            
            originalWord = dicOriginal.readLine().toCharArray();
        }
        
        dicOriginal.close();
        dicOrdenado.close();
    }
    
    /**
     * Devuelve true si en generatedWords existe el elemento word.
     * @param generatedWords
     * @param word
     * @return 
     */
    private static boolean existeDuplicado(char[][] generatedWords, char[] word){
        for (char[] generatedWord : generatedWords) {
            if (Arrays.equals(generatedWord, word)) {
//                System.out.println("Se ha encontrado un duplicado con: "+Arrays.toString(word));
                return true;
            }
        }
        return false;
    }
    /**
     * Genera varios diccionarios "diccionario_n.txt" solo con las palabras de longitud n. 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static void ordenarDiccionarioPorLongitud() throws FileNotFoundException, IOException{
        char[] word, sortedWord;
        char[][] generatedWords;
        int lengthWord;
        final int MAX_LETRAS = 50;
        FileWriter diccionarios[] = new FileWriter[MAX_LETRAS];
        BufferedReader dicOriginal = new BufferedReader(new FileReader("diccionarios/dic_ordenado.txt"));
        
        for (int i = 0; i < MAX_LETRAS; i++) {
            diccionarios[i] = new FileWriter("diccionarios/diccionariosPorLongitud/dic_longitud_"+(i+1)+".txt");
        }
        
        word = dicOriginal.readLine().toCharArray();
        lengthWord = (word.length-1)/2;
        while(word[0] != '.'){
            diccionarios[lengthWord-1].write(word);
            diccionarios[lengthWord-1].write(System.getProperty("line.separator"));
            
            word = dicOriginal.readLine().toCharArray();
            lengthWord = (word.length-1)/2;
        }
        
        for (int i = 0; i < MAX_LETRAS; i++) {
            diccionarios[i].write(new char[]{'.',',','.'});
            diccionarios[i].close();
        }
        dicOriginal.close();
    }
}
