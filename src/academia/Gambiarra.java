/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

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
    
    private void pegarDados(String nome, String sobrenome, int idade, String nascimento, int cpf, 
            String usuario, String senha) throws Exception{
        
        Cadastro cadastro = new Cadastro();
        try{
        cadastro.salvaUsuario(nome, sobrenome, idade,
       nascimento, cpf, usuario, senha, "aluno");
        }catch(Exception e){
            
        }
        
    }
    
    
}
