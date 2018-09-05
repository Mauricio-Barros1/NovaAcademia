/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Cadastro {
    
    private static BufferedReader usersArq;
    private static BufferedWriter gravarArq;
    private static FileOutputStream OutArq;
    private static final String arquivoUsers = "src/academia/dados.txt";
    private static final String arquivoTreinos = "src/academia/treinos.txt";
   
    //Deve ler o cadastro da persitência
    public Cadastro() {
        try {
        usersArq = new BufferedReader(new FileReader(arquivoUsers));
        FileWriter f = new FileWriter(arquivoUsers, true);
        gravarArq = new BufferedWriter(f);
        }
        catch (IOException e)
        { System.out.println(e);
        JOptionPane.showMessageDialog(null, "Erro! Falha ao Encontrar arquivo de dados" + e);
        }
    }
    
    public static String[] getUserInfo(String usuario)
    {
        try{
        usersArq = new BufferedReader(new FileReader(arquivoUsers));
        String[] user;
        String line;
        while ((line = usersArq.readLine()) != null){
            user = line.split(";");
            if (user[2].equals(usuario))    
            {   
                usersArq.close();
                return user;
            }
        }
        usersArq.close();
        return null;
        }
        catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }

    public static void salvaTreino(Treino treino)  {
        try {
            FileWriter f = new FileWriter(arquivoTreinos, true);
            BufferedWriter gravaTreino = new BufferedWriter(f);
        int[] valores = treino.getValores();
        gravaTreino.write(treino.getAluno().getUsuario() + ";" + valores[0] + ";" + valores[1] + ";" 
                + valores[2] + ";" + valores[3] + ";" + valores[4] + ";" + valores[5] 
                + ";");
        gravaTreino.newLine();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro! Falha ao salvar usuário dados" + e);
        }
    }
    
    

    public static void salvaUsuario(String nome, String sobrenome, int idade,
        String dataDeNascimento, String cpf, String usuario,
        String senha, String cargo, float salario) {
        try{
        gravarArq.write(nome + ";" + sobrenome + ";" + usuario + ";" 
                + senha + ";" + cpf + ";" + idade + ";" + dataDeNascimento 
                + ";" + cargo + ";" + salario + ";");
        gravarArq.newLine();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro! Falha ao salvar dados do usuário" + e);
        }
    }    
    
    public static void salvaUsuario(String nome, String sobrenome, int idade,
        String dataDeNascimento, String cpf, String usuario,
        String senha)  {
        try {
        gravarArq.write(nome + ";" + sobrenome + ";" + usuario + ";" 
                + senha + ";" + cpf + ";" + idade + ";" + dataDeNascimento 
                + ";" + null + ";" + null);
        gravarArq.newLine();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro! Falha ao salvar dados do usuário" + e);
        }
    }
}