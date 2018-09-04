/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Gambiarra {
    
    public Gambiarra(String nome, String sobrenome, int idade, String nascimento, int cpf, 
            String usuario, String senha){
            
        try{
            this.pegarDados(nome, sobrenome, idade,
            nascimento, cpf, usuario, senha);
        }catch(Exception e){
            
        }
    }
    
    public Gambiarra(String usuario, String senha) {
        
        try{
            
            
            if(this.login(usuario, senha)) {
                JFrameAdmin tela = new JFrameAdmin();
                tela.open();
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Usuário e/ou senha incorretos");
                JFrameLogin tela = new JFrameLogin();
                tela.open();
            }
        
        }catch(Exception e) {
            
        }
        
    }
    
    private boolean login(String usuario, String senha) throws Exception {
        
        Controlador controlador = new Controlador();
        
        try{
            if(controlador.autenticar(usuario, senha) != null) {
                return true;
            }
        }catch(Exception e) {
            
        }
        return false;
    }
    
    
    
    private void pegarDados(String nome, String sobrenome, int idade, String nascimento, int cpf, 
            String usuario, String senha) throws Exception{
        
        Cadastro cadastro = new Cadastro();
        try{
        cadastro.criarUsuario(nome, sobrenome, idade,
       nascimento, cpf, usuario, senha, 3);
        }catch(Exception e){
            
        }
        
    }
    
    
}
