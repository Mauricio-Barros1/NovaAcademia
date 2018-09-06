/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.Controle;

import academia.Model.Aluno;
import academia.Autenticador.Autentificacao;
import academia.GerenciadorUsuarios.Cadastro;
import academia.Model.Funcionario;
import academia.Model.Treino;
import academia.Model.Usuario;
import academia.View.JFrameFuncionario;
import academia.View.JFrameLogin;
import academia.View.JFrameAdmin;
import academia.View.JFrameAluno;
import academia.PersistenciaDados.Persistencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.ArrayList;



public class Controlador {
    private static Usuario usuarioAtual;
    
    public Controlador() {
        Cadastro cadastro = new Cadastro();
    }
    
    
    public void init() {
        new JFrameLogin().setVisible(true);
    }
    
     public void setUsuarioAtual(String nomeUsuario)
    {
        usuarioAtual = getUsuario(nomeUsuario);
    }
    

     
    public Usuario getUsuarioAtual()
    {return usuarioAtual;}
    
    
    public boolean autorizaAutenticacao(String usuario, String senha){
        boolean autenticou = Autentificacao.autentifica(usuario, senha);
        System.out.println(autenticou);
        return autenticou;
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, String usuario, 
        String senha, String cpf, int idade, String dataDeNascimento,   
        int matricula, String cargo, float salario) {
        Persistencia.salvaUsuario(nome, sobrenome, idade, dataDeNascimento, cpf, usuario,
        senha, matricula, cargo, salario); 
        new JFrameAdmin().setVisible(true);
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, String usuario, 
        String senha, String cpf, int idade, String dataDeNascimento,   
        int matricula) {
        Persistencia.salvaUsuario(nome, sobrenome, idade, dataDeNascimento, cpf, usuario,
        senha, matricula);
        new JFrameAdmin().setVisible(true);
    }
    
    public void getProximaTela_esquece()
    {
        System.out.println(usuarioAtual.isAdmin());
        if (usuarioAtual.isAdmin())
        { new JFrameAdmin().setVisible(true);}
        else{
            if (usuarioAtual instanceof Aluno)
            { new JFrameAluno().setVisible(true);} 
            else
                { new JFrameFuncionario().setVisible(true, usuarioAtual);}
        }
    }
    
    public JFrame getProximaTela()
    {
        if (usuarioAtual instanceof Aluno)
            { return new JFrameAluno();} 
        if (usuarioAtual.isAdmin())
        { return new JFrameAdmin();}
        else 
        { return new JFrameFuncionario();}
    }
    
     public boolean login(String usuario, String senha) {
            if(this.autorizaAutenticacao(usuario, senha)) {
               setUsuarioAtual(usuario);
               return true;
                }
            else 
                {
                JOptionPane.showMessageDialog(null, "Erro! Usuário e/ou senha incorretos");
                return false;
                }
    }
     
   public Usuario getUsuario(String nomeUsuario)
   {
        String[] dados = Cadastro.getUserInfo(nomeUsuario);
        if (!dados[8].equals("null"))
        {
         System.out.println("to retornando");
         return new Funcionario(dados[0], dados[1],dados[2], 
        dados[3], dados[4], Integer.parseInt(dados[5]) , dados[6],   
        Integer.parseInt(dados[7]), dados[8], Float.parseFloat(dados[9]));
        }
        else{ 
            return new Aluno(dados[0], dados[1], dados[2], dados[3],
                   dados[4], Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]));}
   }
     
   public Aluno getAluno(String nomeUsuario)
   {
       String[] dados = Cadastro.getUserInfo(nomeUsuario);
       return new Aluno(dados[0], dados[1], dados[2], dados[3],
                   dados[4], Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]));
   }
   
    public Funcionario getFuncionario(String nomeUsuario)
    {
      String[] dados = Cadastro.getUserInfo(nomeUsuario);
      return new Funcionario(dados[0], dados[1],dados[2], 
        dados[3], dados[4], Integer.parseInt(dados[5]) , dados[6],   
        Integer.parseInt(dados[7]), dados[8], Float.parseFloat(dados[9]));
    }
   
   
    public boolean salvaTreino(String aluno, int abdominais, int polichinelos, int agachamentos,
            int esteira, int corrida, int eliptico)
    {
        if (aluno != null){
        Aluno realAluno = getAluno(aluno.split(" ")[0]);
        Treino treinoASalvar = new Treino(realAluno, abdominais, polichinelos, agachamentos,
            esteira, corrida, eliptico);
        Persistencia.salvaTreino(treinoASalvar);
        new JFrameFuncionario().setVisible(true, usuarioAtual);
        return true;
        }
        else{JOptionPane.showMessageDialog(null, "É necessario escolher um aluno para relacionar ao treino!");
        return false;}
    }
     
   
    public static ArrayList<Aluno> getListAlunos() {
        return Cadastro.getListAlunos();
    }
    
    public static ArrayList<Funcionario> getListFuncionarios() {
        return Cadastro.getListFuncionarios();
    }
     
    public static String[] getListNameAlunos()
    {
        ArrayList<Aluno> alunos = getListAlunos();
        String[] names = new String[alunos.size()];
        int i=0;
        for (Aluno aluno : alunos)
            { names[i] = aluno.getNome(); i++; }
        return names;
    }
    
    public static String[] getListNameFuncionarios()
    {
        ArrayList<Funcionario> funcionarios = getListFuncionarios();
        String[] names = new String[funcionarios.size()];
        int i=0;
        for (Funcionario func : funcionarios)
            { names[i] = func.getNome(); i++; }
        return names;
    }
    
}
