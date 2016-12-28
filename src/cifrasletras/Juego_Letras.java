/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrasletras;

import combinaciones.Combinacion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Triviño
 */
public class Juego_Letras extends javax.swing.JFrame {

    final int MAX_PALABRA_SIZE = 9;
    Integer[][][] idxCombinaciones;
    /**
     * Creates new form Juego_Letras
     * @throws java.io.FileNotFoundException
     */
    public Juego_Letras() throws FileNotFoundException, Exception {
        initComponents();
        
        idxCombinaciones = new Integer[MAX_PALABRA_SIZE+1][][];
        for (int i = MAX_PALABRA_SIZE; i > 0; i--) {
            idxCombinaciones[i] = new Combinacion(new Integer[]{0,1,2,3,4,5,6,7,8}, i).getCombinaciones();
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        solution = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        letra0 = new javax.swing.JLabel();
        letra1 = new javax.swing.JLabel();
        letra2 = new javax.swing.JLabel();
        letra3 = new javax.swing.JLabel();
        letra4 = new javax.swing.JLabel();
        letra5 = new javax.swing.JLabel();
        letra6 = new javax.swing.JLabel();
        letra7 = new javax.swing.JLabel();
        letra8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        solution.setEditable(false);
        solution.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        solution.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        solution.setText("RESULTADO");
        solution.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Letras");

        letra0.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra0.setText("R");

        letra1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra1.setText("I");

        letra2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra2.setText("I");

        letra3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra3.setText("U");

        letra4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra4.setText("A");

        letra5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra5.setText("A");

        letra6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra6.setText("M");

        letra7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra7.setText("L");

        letra8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        letra8.setText("O");

        jButton1.setText("Resolver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(letra0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(letra1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(letra2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra8)))
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(solution)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(solution, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(letra0, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ejecutar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        generarLetras();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego_Letras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego_Letras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego_Letras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego_Letras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Juego_Letras().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Juego_Letras.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Juego_Letras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    private void ejecutar(){
        int longitud_de_palabra = MAX_PALABRA_SIZE;
        Character[][] combinaciones;
        Character[] palabra = getLetras(), combinacion;
        boolean found = false;
        jProgressBar1.setMaximum(9);
        
        try {
            while (longitud_de_palabra > 0 && !found) {
                combinaciones = getCombinaciones(longitud_de_palabra);
                for(int i = 0 ; i < combinaciones.length && !found ; i++){
                    combinacion = combinaciones[i];
                    found = buscarPalabra(abrirDiccionario(longitud_de_palabra), combinacion);
                }
                longitud_de_palabra--;
            }
        } catch (Exception ex) {
            Logger.getLogger(Juego_Letras.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(longitud_de_palabra > 0) longitud_de_palabra++;
        
        jProgressBar1.setValue(longitud_de_palabra);
    }
    private boolean buscarPalabra(BufferedReader dic, Character[] challengeWord){
        boolean found = false;
        try {
            
            Character[][] dicWords;
            Character[] originalDicWord, sortDicWord;
            String solutionString = "";
            
            dicWords = readWords(dic);
            
            while(dicWords[0][0] != '.'  && !found){
                sortDicWord = dicWords[0];
                originalDicWord = dicWords[1];
                
//                System.out.println("Comparando "+Arrays.toString(challengeWord)+" con "+Arrays.toString(sortDicWord));
                if(Arrays.equals(challengeWord, sortDicWord)){
                    for (Character letra : originalDicWord) {
                        solutionString += letra;
                    }
                    solution.setText(solutionString);
                    found = true;
                }
                dicWords = readWords(dic);
            }
            
            if(!found){
                solution.setText("No encontrado");
            }
            
            dic.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Juego_Letras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Juego_Letras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }
    
    
    private void generarLetras(){
        String letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra0.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra1.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra2.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra3.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra4.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra5.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra6.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra7.setText(letraAleatoria);
        
        letraAleatoria = "";
        letraAleatoria += (char) ((char) (new Random().nextInt(25))+65);
        letra8.setText(letraAleatoria);
        
        
//        letra0.setText("A");
//        letra1.setText("A");
//        letra2.setText("A");
//        letra3.setText("A");
//        letra4.setText("B");
//        letra5.setText("C");
//        letra6.setText("L");
//        letra7.setText("L");
//        letra8.setText("N");
    }
    private Character[] getLetras(){
        
        Character[] word = new Character[9];
        word[0] = letra0.getText().toCharArray()[0];
        word[1] = letra1.getText().toCharArray()[0];
        word[2] = letra2.getText().toCharArray()[0];
        word[3] = letra3.getText().toCharArray()[0];
        word[4] = letra4.getText().toCharArray()[0];
        word[5] = letra5.getText().toCharArray()[0];
        word[6] = letra6.getText().toCharArray()[0];
        word[7] = letra7.getText().toCharArray()[0];
        word[8] = letra8.getText().toCharArray()[0];
        
        Arrays.sort(word);
        return word;
    }
    
    private BufferedReader abrirDiccionario(int i) throws FileNotFoundException{
        return new BufferedReader(new FileReader("diccionarios/diccionariosPorLongitud/dic_longitud_"+i+".txt"));
    }
    private Character[][] readWords(BufferedReader diccionario) throws IOException{
        // TODO: REFACTORIZAR
        Character[][] words = new Character[2][];
        
        char[] word = diccionario.readLine().toCharArray();
        int wordLength = (word.length-1)/2;
        
        Character[] sortWord = new Character[wordLength];
        Character[] originalWord = new Character[wordLength];
       
        for (int i = 0 ; i < wordLength ; i++){
            sortWord[i] = word[i];
        }
        
        for (int i = 0 ; i < wordLength ; i++){
            originalWord[i] = word[i+wordLength+1];
        }
        
        words[0] = sortWord;
        words[1] = originalWord;
        
        return words;
    }
    
    private Character[][] getCombinaciones(int longitud_palabra){
        Integer[][] arrayIdx = idxCombinaciones[longitud_palabra];
        Character[][] combinaciones = new Character[arrayIdx.length][longitud_palabra];
        Character[] letras = getLetras();
        
        for (int i = 0; i < arrayIdx.length; i++) {
            for (int j = 0; j < arrayIdx[i].length; j++) {
                combinaciones[i][j] = letras[arrayIdx[i][j]];
            }
        }
        
        return combinaciones;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel letra0;
    private javax.swing.JLabel letra1;
    private javax.swing.JLabel letra2;
    private javax.swing.JLabel letra3;
    private javax.swing.JLabel letra4;
    private javax.swing.JLabel letra5;
    private javax.swing.JLabel letra6;
    private javax.swing.JLabel letra7;
    private javax.swing.JLabel letra8;
    private javax.swing.JTextField solution;
    // End of variables declaration//GEN-END:variables
}