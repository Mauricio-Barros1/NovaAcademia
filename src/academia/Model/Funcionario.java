/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.Model;

import academia.Model.Usuario;

public class Funcionario extends Usuario
{
    public String cargo; 
    private float salario; 
    private String senha;

        public Funcionario(String nome, String sobrenome, String usuario, 
        String senha, String cpf, int idade, String dataDeNascimento,   
        int matricula, String cargo, float salario)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento; 
        this.cpf = cpf;
        this.usuario = usuario;
        this.salario = salario;
        this.senha = senha;
        this.cargo = cargo;
    }
    
    public void setCargo(String cargo){ this.cargo = cargo;}
    public void setSalario(float salario){this.salario = salario;}
    public void setSenha(String senha){this.senha = senha;}

    public String getCargo(){ return cargo;}
    public String getSenha(){return senha;}
    public float getSalario(){return salario;}
    public boolean isAdmin() { return this.cargo.equals("admin");}
    
}