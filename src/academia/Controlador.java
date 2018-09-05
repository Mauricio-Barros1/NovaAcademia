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
    
    public Controlador(String nome, String senha) {
        
        if(this.AutorizaAutenticacao(nome, senha)) {
                JFrameAdmin tela = new JFrameAdmin();
                tela.open();
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Usuário e/ou senha incorretos");
                JFrameLogin tela = new JFrameLogin();
                tela.open();
            }
        
        
    }
    
    public Controlador(String nome, String sobrenome, int idade, String nascimento, int cpf, 
            String usuario, String senha, String tipo) {
        
        try {
            
            Cadastro cadastro = new Cadastro();
            cadastro.salvaUsuario(nome, sobrenome, idade,
            nascimento, cpf, usuario, senha, tipo);
            
        }catch(Exception e) {
                
        }
            
            
    }
    
    public Controlador() {
        
    }
    
    
    public void init() {
<<<<<<< HEAD
        new JFramelogin().setVisible(true);
    }
    
     public void setUsuarioAtual(String nomeUsuario)
    {
        String[] dados = Cadastro.getUserInfo(nomeUsuario);
        if (!dados[8].equals("null"))
        {
           usuarioAtual = new Funcionario(dados[0], dados[1], dados[2], dados[3],
                   Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]), dados[8]);
        }
        else{ 
            usuarioAtual = new Aluno(dados[0], dados[1], dados[2], dados[3],
                   Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), 
                   dados[6], Integer.parseInt(dados[7]));}
    }
    
     
    public Usuario getUsuarioAtual()
    {return usuarioAtual;}
    
    
    public boolean autorizaAutenticacao(String usuario, String senha){
        boolean autenticou = Autentificacao.autentifica(usuario, senha);
        System.out.println(autenticou);
        return autenticou;
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, String usuario, 
        String senha, int cpf, int idade, String dataDeNascimento,   
        int matricula, String cargo) {
        Cadastro.salvaUsuario(nome, sobrenome, idade, dataDeNascimento, cpf, usuario,
        senha, cargo);
=======
        
        //new Cadastro();
        JFrameLogin tela = new JFrameLogin();
        tela.open();
               
    }
    
    private boolean AutorizaAutenticacao(String usuario, String senha){
        
        Autentificacao autentificador = new Autentificacao();
        return autentificador.autentifica(usuario, senha);
>>>>>>> de7ca2eadb7edcf52e151da92ef3c0feda39f088
        
    }
    
    public void cadastrarUsuario(String nome, String sobrenome, String usuario, 
        String senha, int cpf, int idade, String dataDeNascimento,   
        int matricula) {
        Cadastro.salvaUsuario(nome, sobrenome, idade, dataDeNascimento, cpf, usuario,
        senha);
        
    }
    
    JFrame getProximaTela()
    {
        if (usuarioAtual instanceof Aluno)
            { return new JFrameCadastroUsuario();} 
        if (usuarioAtual.isAdmin())
        { return new JFrameAdmin();}
        else 
        { return new JFrameFuncionario();}
    }
    
     public boolean login(String usuario, String senha) {
        try{
            if(this.autorizaAutenticacao(usuario, senha)) {
               setUsuarioAtual(usuario);
               System.out.println(usuarioAtual.getNome());
               System.out.println(usuarioAtual.getDataNascimento());
               return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Usuário e/ou senha incorretos");
                return false;
            }
        
        }catch(Exception e) {
            return false;
        }
    }
     
   
    public void listarUsuarios() {
        
        BufferedReader usersArq;
        String arquivo = "src/academia/dados.txt";       
        
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
            
            JOptionPane.showMessageDialog(null, texto);
            //JFrameListaUsuario lista = new JFrameListaUsuario();
            //lista.open();
            usersArq.close();
        
        }
        catch(IOException e) {
            System.out.println(e);
            
        }
        
    }
      
    
}
