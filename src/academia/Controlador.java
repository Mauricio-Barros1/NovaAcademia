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
public class Controlador {
    
    
    public void init() {
        
        JFrameLogin tela = new JFrameLogin();
        tela.open();
       
        
    }
    
    public Usuario autenticar(String usuario, String senha) {
        
        Autentificacao autenti = new Autentificacao();
        return autenti.autentica(usuario, senha);
        
    }
    
    public void cadastrarUsuario() {
        
        
    }
    
    
    
    
    
    
}
