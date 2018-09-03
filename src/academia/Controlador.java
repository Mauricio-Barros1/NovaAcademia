/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;




public class Controlador {
    
    
    public void init() {
        
        JFrameLogin tela = new JFrameLogin();
        tela.open();
       
        
    }
    
    public Usuario autenticar(String usuario, String senha) throws Exception{
        
        Autentificacao autenti = new Autentificacao();
        return autenti.autentica(usuario, senha);
        
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, int idade, String nascimento, int cpf, String usuario, String senha) throws Exception{
        Cadastro cadastro = new Cadastro();
        cadastro.criarUsuario(nome, sobrenome, idade,
       nascimento, cpf, usuario, senha, 3);
        
    }
    
    
    
    
    
    
}
