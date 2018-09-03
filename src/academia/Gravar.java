/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Gravar {
    
    private Formatter arquivo;
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
    
    public void abrir() {
        
        
                
        try{
                    
            arquivo = new Formatter("/home/user/NetBeansProjects/Academia/src/academia/BD.txt");
                    
        }catch(SecurityException e){
                    
            JOptionPane.showMessageDialog(null, "Erro! Arquivo sem acesso");
                    
        }catch(FileNotFoundException e){
                    
            JOptionPane.showMessageDialog(null, "Erro! Arquivo não encontrado - gravar");
                    
        }
                
             
        
    }
    
    
    public void escrever() {
        
        
        try{
            
            arquivo.format(texto);
            
        }catch(FormatterClosedException e){
            
             JOptionPane.showMessageDialog(null, "Erro! Formatador está fechado");
            
        }
        
        
        
    }
    
    
    public void fechar(){
        
        arquivo.close();
        
        
    }
    
    
    
    
}

