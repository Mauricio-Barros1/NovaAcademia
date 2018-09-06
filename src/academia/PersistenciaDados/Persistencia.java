/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.PersistenciaDados;

import academia.Model.Treino;
import academia.Model.Treino;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Persistencia {
    
    private static BufferedReader usersArq;
    private static BufferedWriter gravarArq;
    private static FileOutputStream OutArq;
    private static final String arquivoUsers = "src/academia/PersistenciaDados/dados.txt";
    private static final String arquivoTreinos = "src/academia/PersistenciaDados/treinos.txt";
    
    
    
    
    public static void salvaUsuario(String nome, String sobrenome, int idade,
        String dataDeNascimento, String cpf, String usuario,
        String senha, int matricula, String cargo, float salario) {
        try{
        FileWriter f = new FileWriter(arquivoUsers, true);
        gravarArq = new BufferedWriter(f);
        gravarArq.write(nome + ";" + sobrenome + ";" + usuario + ";" 
                + senha + ";" + cpf + ";" + idade + ";" + dataDeNascimento 
                + ";" + matricula + ";" + cargo + ";" + salario + ";");
        gravarArq.newLine();
        gravarArq.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro! Falha ao salvar dados do usuário" + e);
        }
    }    
    
    public static void salvaUsuario(String nome, String sobrenome, int idade,
        String dataDeNascimento, String cpf, String usuario,
        String senha, int matricula)  {
        try {
        FileWriter f = new FileWriter(arquivoUsers, true);
        gravarArq = new BufferedWriter(f);
        gravarArq.write(nome + ";" + sobrenome + ";" + usuario + ";" 
                + senha + ";" + cpf + ";" + idade + ";" + dataDeNascimento + ";" + 
                matricula + ";" + null + ";" + null);
        gravarArq.newLine();
        System.out.println(nome + ";" + sobrenome + ";" + usuario + ";" 
                + senha + ";" + cpf + ";" + idade + ";" + dataDeNascimento 
                + ";" + matricula + ";"+ null + ";" + null);
        gravarArq.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro! Falha ao salvar dados do usuário" + e);
        }
    }
    
    
    public static void salvaTreino(Treino treino)  {
        try {
            FileWriter f = new FileWriter(arquivoTreinos, true);
            gravarArq = new BufferedWriter(f);
            int[] valores = treino.getValores();
            gravarArq.write(treino.getAluno().getUsuario() + ";" + valores[0] + ";" + valores[1] + ";" 
                    + valores[2] + ";" + valores[3] + ";" + valores[4] + ";" + valores[5] 
                    + ";");
            gravarArq.newLine();
            gravarArq.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro! Falha ao salvar usuário dados" + e);
        }
    }
    
    
    
}
