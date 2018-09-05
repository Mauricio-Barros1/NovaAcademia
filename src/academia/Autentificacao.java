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
public class Autentificacao {
    
    
public static boolean autentifica(String usuario, String senha){
    
    Cadastro cadastro = new Cadastro();
    System.out.println(usuario);
    String[] dados = Cadastro.getUserInfo(usuario);
    return dados[3].equals(senha);
    }

    public static boolean verificaPermissao(Usuario nomeUsuario, String tela)
    {
        if (nomeUsuario instanceof Funcionario){
            if (nomeUsuario.isAdmin())
            {return true;}
            if (!tela.equals("cadastro"))
            {return true;}
            }
        else
        { if (tela.equals("treino"))
              {return true;}
        }
        return false;
    }

}
