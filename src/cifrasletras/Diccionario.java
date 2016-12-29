/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrasletras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Triviño
 */
public class Diccionario {
    String ruta;
    BufferedReader diccionario;
    boolean abierto;

    public Diccionario(String ruta) throws FileNotFoundException {
        this.ruta = ruta;
        this.abierto = false;
    }
    
    private Palabra leerPalabra(){
        try {
            char[] line = diccionario.readLine().toCharArray();
            int wordLength = (line.length-1)/2;
            
            Character[] sortWord = new Character[wordLength];
            Character[] originalWord = new Character[wordLength];
            
            for (int i = 0 ; i < wordLength ; i++){
                sortWord[i] = line[i];
            }
            
            for (int i = 0 ; i < wordLength ; i++){
                originalWord[i] = line[i+wordLength+1];
            }
            
            return new Palabra(originalWord, sortWord);
        } catch (IOException ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Palabra buscarPalabra(Palabra palabraAbuscar){
        this.abrir();
        
        Palabra palabraDiccionario;
        
        palabraDiccionario = this.leerPalabra();
        while(!palabraDiccionario.esCentinela()){
            if(palabraDiccionario.equals(palabraAbuscar)){
                this.cerrar();
                return palabraDiccionario;
            }
            palabraDiccionario = this.leerPalabra();
        }
        
        this.cerrar();
        return null;
    }
    
    private void abrir(){
        try {
            this.diccionario = new BufferedReader(new FileReader(ruta));
            abierto = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cerrar(){
        try {
            diccionario.close();
            abierto = false;
        } catch (IOException ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}