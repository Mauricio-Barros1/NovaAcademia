/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.Model;

import java.sql.Date;


public abstract class Usuario
{
    String nome;
    String sobrenome;
    int idade; 
    String dataDeNascimento;
    int RG;
    String cpf;
    int cep;
    int telefone;    
    int matricula;
    String usuario;
    String senha;
    int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public Usuario(){}

    public Usuario(String nome, String sobrenome, int idade,
        int matricula, String dataDeNascimento, String cpf, String usuario, String senha)
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

    public String getNome(){return nome + " " + sobrenome; }

    public int getIdade(){return idade;}

    public String getDataNascimento()    {return dataDeNascimento;}

    public int getCep() { return cep;}

    public int getTelefone() { return telefone;}
    
    public int getMatricula(){ return matricula;}

    public void setCep(int newCep){cep = newCep;}

    public void setTelefone(int telefone){this.telefone = telefone;}

    public boolean isAdmin() { return false;}
}
