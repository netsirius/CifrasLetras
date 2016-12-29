/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrasletras;

import java.util.Arrays;

/**
 *
 * @author Javier Triviño
 */
public class Palabra {
    Character[] palabra, palabraOrdenada;

    public Palabra(Character[] palabra) {
        this.palabra = palabra;
        this.palabraOrdenada = palabra.clone();
        Arrays.sort(this.palabraOrdenada);
    }
    public Palabra(Character[] palabra, Character[] palabraOrdenada) {
        this.palabra = palabra;
        this.palabraOrdenada = palabraOrdenada;
    }

    public Character[] getPalabra() {
        return palabra;
    }

    public Character[] getPalabraOrdenada() {
        return palabraOrdenada;
    }
    
    @Override
    public String toString(){
        String pal = "";
        
        for (Character letra : palabra) {
            pal += letra;
        }
        
        return pal;
    }
    
    public boolean equals(Palabra p){
        return Arrays.equals(this.getPalabraOrdenada(), p.getPalabraOrdenada());
    }
    
    public boolean esCentinela(){
        return Arrays.equals(this.getPalabra(), new Character[]{'.'});
    }
    
    
    
    
    
    
}
