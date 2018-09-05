/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;




public class Controlador {
    private Usuario usuarioAtual;
    
    public Controlador() {
        
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
        Cadastro.salvaUsuario(nome, sobrenome, idade, dataDeNascimento, cpf, usuario,
        senha, cargo, salario); 
        new JFrameAdmin().setVisible(true);
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, String usuario, 
        String senha, String cpf, int idade, String dataDeNascimento,   
        int matricula) {
        Cadastro.salvaUsuario(nome, sobrenome, idade, dataDeNascimento, cpf, usuario,
        senha);
        new JFrameAdmin().setVisible(true);
    }
    
    void getProximaTela()
    {
        if (usuarioAtual instanceof Aluno)
            { new JFrameEscolhaUsuario().setVisible(true);} 
        if (usuarioAtual.isAdmin())
        { new JFrameAdmin().setVisible(true);}
        else 
        { new JFrameFuncionario().setVisible(true, usuarioAtual);}
    }
    
     public boolean login(String usuario, String senha) {
        try{
            if(this.autorizaAutenticacao(usuario, senha)) {
               setUsuarioAtual(usuario);
               return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Usuário e/ou senha incorretos");
                return false;
            }
        
        }catch(Exception e) {
            return false;
        }
    }
     
   public Usuario getUsuario(String nomeUsuario)
   {
      String[] dados = Cadastro.getUserInfo(nomeUsuario);
        if (!dados[8].equals("null"))
        {
           return new Funcionario(dados[0], dados[1], dados[2], dados[3],
                   Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]), dados[8]);
        }
        else{ 
            return new Aluno(dados[0], dados[1], dados[2], dados[3],
                   Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]));}
   }
     
   public Aluno getAluno(String nomeUsuario)
   {
       String[] dados = Cadastro.getUserInfo(nomeUsuario);
       return new Aluno(dados[0], dados[1], dados[2], dados[3],
                   Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]));
   }
   
    public Funcionario getFuncionario(String nomeUsuario)
    {
      String[] dados = Cadastro.getUserInfo(nomeUsuario);
      return new Funcionario(dados[0], dados[1], dados[2], dados[3],
                   Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]), dados[8]);
    }
   
   
    public void salvaTreino(String aluno, int abdominais, int polichinelos, int agachamentos,
            int esteira, int corrida, int eliptico)
    {
        Aluno realAluno = getAluno(aluno);
        Treino treinoASalvar = new Treino(realAluno, abdominais, polichinelos, agachamentos,
            esteira, corrida, eliptico);
        Cadastro.salvaTreino(treinoASalvar);
        new JFrameFuncionario().setVisible(true, usuarioAtual);
    }
     
   
    public String listarUsuarios(int quem) {
        
        BufferedReader usersArq;
        String arquivo = "src/academia/dados.txt";       
        
        switch(quem) {
            
            case 1:
                try{

                    usersArq = new BufferedReader(new FileReader(arquivo));
                    String[] user;
                    String line;
                    String texto = "";

                    while ((line = usersArq.readLine()) != null){
                        System.out.println(line);
                        user = line.split(";");

                        texto = texto + "\n" + "Nome: " + user[0] + " " + user[1] +
                                "\nMatrícula " + user[4] + "\nIdade: " + user[5] +
                                        "\nVínculo: " + user[7] + "\n\n";

                    }
                    
                    usersArq.close();
                    return texto;

                }
                catch(IOException e) {
                    System.out.println(e);

                }
            
            break;
            
            case 2:
                
                try{

                    usersArq = new BufferedReader(new FileReader(arquivo));
                    String[] user;
                    String line;
                    String texto = "";

                    while ((line = usersArq.readLine()) != null){
                        System.out.println(line);
                        user = line.split(";");
                        
                        if(user[7].equals("null")) {
                        texto = texto + "\n" + "Nome: " + user[0] + " " + user[1] +
                                "\nMatrícula " + user[4] + "\nIdade: " + user[5] +
                                        /**"\nVínculo: " + user[7] +*/ "\n\n";
                        }
                    }

                    
                    usersArq.close();
                    return texto;

                }
                catch(IOException e) {
                    System.out.println(e);

                }
                
            break;
            
            case 3:
                
                try{

                    usersArq = new BufferedReader(new FileReader(arquivo));

                    String[] user;
                    String line;
                    String texto = "";

                    while ((line = usersArq.readLine()) != null){
                        System.out.println(line);
                        user = line.split(";");
                        
                        if(!user[8].equals("null")) {
                        texto = texto + "\n" + "Nome: " + user[0] + " " + user[1] +
                                "\nCargo " + user[7] + "\nIdade: " + user[5] +
                                        /**"\nVínculo: " + user[7] +*/ "\n\n";
                        }
                    }

                    
                    usersArq.close();
                    return texto;

                }
                catch(IOException e) {
                    System.out.println(e);

                }
                
            break;
        
        }
        
        return null;
        
    }
      
    
}
