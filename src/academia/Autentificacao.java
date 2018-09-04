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
    
    
public boolean autentifica(String usuario, String senha){
    
    Cadastro cadastro = new Cadastro();
    System.out.println(usuario);
    String[] dados = Cadastro.getUserInfo(usuario);
    return dados[3].equals(senha);
    }
}
