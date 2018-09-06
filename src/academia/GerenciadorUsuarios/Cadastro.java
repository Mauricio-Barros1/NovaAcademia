/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.GerenciadorUsuarios;

import academia.Model.Aluno;
import academia.Model.Funcionario;
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
    private static final String arquivoUsers = "src/academia/PersistenciaDados/dados.txt";
    private static final String arquivoTreinos = "src/academia/PersistenciaDados/treinos.txt";
   
    //Deve ler o cadastro da persitência
    public Cadastro() {
     /*/      try {
            usersArq = new BufferedReader(new FileReader(arquivoUsers));
            FileWriter f = new FileWriter(arquivoUsers, true);
            gravarArq = new BufferedWriter(f);
            usersArq = new BufferedReader(new FileReader(arquivoTreinos));
            FileWriter file = new FileWriter(arquivoTreinos, true);
            gravarArq = new BufferedWriter(file);
        }
        catch (IOException e)
            { System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro! Falha ao Encontrar arquivo de dados" + e);
            } /*/
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
                return user;
            }
        }
        return null;
        }
        catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }

    
    
    public static ArrayList<Aluno> getListAlunos()
    {
        ArrayList<Aluno> alunos = new ArrayList();
        String line;
        String[] user;
        try{
            usersArq = new BufferedReader(new FileReader(arquivoUsers));
            while ((line = usersArq.readLine()) != null){
                user = line.split(";");
                System.out.println(user[7]);
                if (user[8].equals("null"))
                {
                Aluno aluno = new Aluno(user[0], user[1], user[2], user[3],
                   user[4], Integer.parseInt(user[5]), 
                   user[6], Integer.parseInt(user[7]));
                alunos.add(aluno);
                }
            }
            usersArq.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        catch(java.lang.NumberFormatException e)
        {
            System.out.println(e);
        }
        return alunos;
    }
    
    public static ArrayList<Funcionario> getListFuncionarios()
    {
        ArrayList<Funcionario> funcionarios = new ArrayList();
        String line;
        String[] user;
        try{
            usersArq = new BufferedReader(new FileReader(arquivoUsers));

            while ((line = usersArq.readLine()) != null){
                user = line.split(";");
                if (user[8].equals("null"))
                {continue;}
                else
                {
                Funcionario funcionario = new Funcionario(user[0], user[1],user[2], 
                user[3], user[4], Integer.parseInt(user[5]) , user[6],   
                Integer.parseInt(user[7]), user[8], Float.parseFloat(user[9]));
                funcionarios.add(funcionario);
                }
            }
            usersArq.close();
        }
        catch(IOException e) {
        System.out.println(e);
        }
        return funcionarios;
    }

    
}