/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Autentificacao {
    

public Usuario autentica(String usuario, String senha) {
    
    Cadastro cadastro = new Cadastro();
    ArrayList<Usuario> lista = cadastro.getCadastro();
     
    for(int i = 0; i < lista.size(); i ++) {
        
        if(usuario.equals(lista.get(i).getUsuario()) && senha.equals(lista.get(i).getSenha())) {
            
            return lista.get(i);
            
        }
        
    }
    return null;
    
    
}




}
