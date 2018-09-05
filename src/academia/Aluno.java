/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.sql.Date;


public class Aluno extends Usuario{

    public Aluno(String nome, String sobrenome, String usuario, 
        String senha, int cpf, int idade, String dataDeNascimento,   
        int matricula)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento; 
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    private Treino treino; 
    private String usuario; 
    private String senha;

    public void setTreino(Treino treino){this.treino = treino;}
    
    public void setSenha(String senha){this.senha = senha;}

    public Treino getTreino(){return treino;}
}
