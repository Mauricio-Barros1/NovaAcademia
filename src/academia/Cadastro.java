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
public class Cadastro {
    
    private ArrayList<Usuario> userList = new ArrayList();
    
    public ArrayList<Usuario> getCadastro() {
        return this.userList;
        
    }
    
    
    //Deve ler o cadastro da persitência
    public Cadastro() {
        
        Funcionario admin = new Funcionario();
        admin.setUsuario("admin");
        admin.setSenha("admin");
        admin.setTipo(1);
        userList.add(admin);
        
    }
    
    public void criarUsuario(String nome, String sobrenome, int idade,
        String dataDeNascimento, int cpf, String usuario, String senha, int tipo) throws Exception {
        
        switch(tipo) {
            
            case 1:
                
            break;
            case 2:
                
            break;
            case 3:
                
                Ler ler = new Ler();
                ler.abrir();
                ler.ler();
                String texto = ler.getTexto();
                ler.fechar();
                
                int matricula = cpf;
                Aluno novo = new Aluno(nome, sobrenome, idade, matricula,dataDeNascimento, cpf, usuario, senha);
                userList.add(novo);
                texto = texto + "\n" + nome + "\n" + sobrenome + "\n" + idade + "\n" +
                        matricula + "\n" + dataDeNascimento + "\n" + cpf + "\n" +
                        usuario + "\n" + senha;
                Gravar gravar = new Gravar();
                gravar.setTexto(texto);
                gravar.abrir();
                gravar.escrever();
                gravar.fechar();
                
            break;
            default:
                
            break;
            
            
        }
        
    }
    
    
    
}
