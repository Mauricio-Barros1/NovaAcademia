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

/**
 *
 * @author user
 */
public class Cadastro {
    
    private static BufferedReader usersArq;
    private static BufferedWriter gravarArq;
    private static FileOutputStream OutArq;
    private static String arquivo = "src/academia/dados.txt";
   
    //Deve ler o cadastro da persitência
    public Cadastro() {
        Funcionario admin = new Funcionario("nome",  "sobrenome", 1,
        1234, "dataDeNascimento", 90909, "admin", "admin", "admin");

        try {
        usersArq = new BufferedReader(new FileReader(arquivo));
        FileWriter f = new FileWriter(arquivo, true);
        gravarArq = new BufferedWriter(f);
        }
        catch (IOException e)
        { System.out.println(e);}
    }
    
    public static String[] getUserInfo(String usuario)
    {
        try{
        String[] user;
        String line;
        while ((line = usersArq.readLine()) != null){
            System.out.println(line);
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


    public static void salvaUsuario(String nome, String sobrenome, int idade,
        String dataDeNascimento, int cpf, String usuario,
        String senha, String cargo) throws Exception {
        
        gravarArq.write(nome + ";" + sobrenome + ";" + usuario + ";" 
                + senha + ";" + cpf + ";" + idade + ";" + dataDeNascimento 
                + ";" + cargo + ";");
        gravarArq.newLine();
        gravarArq.close();
    }    
}