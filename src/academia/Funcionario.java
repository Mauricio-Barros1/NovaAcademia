/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

public class Funcionario extends Usuario
{
    private String cargo; 
    private float salario; 
    private String senha;

    public void setCargo(String cargo){ this.cargo = cargo;}
    public void setSalario(float salario){this.salario = salario;}
    public void setSenha(String senha){this.senha = senha;}

    public String getCargo(){ return cargo;}
    public String getSenha(){return senha;}
    public float getSalario(){return salario;}
}