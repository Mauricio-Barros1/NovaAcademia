/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Ler {
    
    private Scanner input;
    private String texto;
    private String lixo;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    public void abrir() throws Exception{
        
        
        try {        
        
            File arqu = new File("/home/user/NetBeansProjects/Academia/src/academia/BD.txt");

            if (!arqu.exists()){

                //arqu.createNewFile();

                //input = new Scanner(new File("/home/user/NetBeansProjects/Academia/src/academia/BD.txt"));


            }else{


                input = new Scanner(new File("/home/user/NetBeansProjects/Academia/src/academia/BD.txt"));

            }
        
        }catch(FileNotFoundException e){
                    
                    JOptionPane.showMessageDialog(null, "Erro! Arquivo não encontrado - ler");
                    
            }
          
            
            
    }
    
    
    
    public void ler(){
        
        //FileWriter fw = new FileWriter(arqu.getAbsoluteFile());
        //BufferedWriter bw = new BufferedWriter(fw);
         
        
        while(input.hasNext()){
            
            if(input.equals("\n")) {
                lixo = input.nextLine();
            } else {
                texto = texto + "\n" + input.nextLine();
            }
        }         
        
    }
    
    
    
    public void fechar(){
        
        if(input != null){
            
            input.close();
            
        }
        
        
        
    }
    
    
    
    
}
