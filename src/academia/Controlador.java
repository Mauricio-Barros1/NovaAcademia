/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;




public class Controlador {
    
    
    public void init() {
        
        new Cadastro();
        JFrameLogin tela = new JFrameLogin();
        tela.open();
        
       
        
    }
    
    public boolean AutorizaAutenticacao(String usuario, String senha){
        
        Autentificacao autentificador = new Autentificacao();
        return autentificador.autentifica(usuario, senha);
        
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, int idade, String nascimento, int cpf, String usuario, String senha, String tipo) throws Exception{
        Cadastro cadastro = new Cadastro();
        cadastro.salvaUsuario(nome, sobrenome, idade,
       nascimento, cpf, usuario, senha, tipo);
        
    }
    
    public void listarUsuarios() {
        
        BufferedReader usersArq;
        String arquivo = "src/academia/dados.txt";       
        
        try{
            
            usersArq = new BufferedReader(new FileReader(arquivo));
            
            String[] user;
            String line;
            String texto = "";
            
            
            while ((line = usersArq.readLine()) != null){
                System.out.println(line);
                user = line.split(";");
                
                texto = texto + "\n" + "Nome: " + user[0] + " " + user[1] +
                        "\nMatrícula " + user[4] + "\nIdade: " + user[5] +
                                "\nVínculo: " + user[7] + "\n\n";
            
            }
            
            JOptionPane.showMessageDialog(null, texto);
            //JFrameListaUsuario lista = new JFrameListaUsuario();
            //lista.open();
            usersArq.close();
        
        }
        catch(IOException e) {
            System.out.println(e);
            
        }
        
    }
    
    
    
}
