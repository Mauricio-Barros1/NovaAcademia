/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.Model;

import academia.Model.Aluno;

/**
 *
 * @author user
 */
public class Treino {
    
    int abdominais;
    int polichinelos;
    int agachamentos;
    int esteira;
    int corrida;
    int eliptico;
    Aluno aluno;
    
    public Treino(Aluno aluno, int abdominais, int polichinelos, int agachamentos,
            int esteira, int corrida, int eliptico)
    {
    this.abdominais = abdominais;
    this.polichinelos = polichinelos;
    this.agachamentos = agachamentos;
    this.esteira = esteira;
    this.esteira = corrida;
    this.eliptico = eliptico;
    this.aluno = aluno;
    }
    
    public String[] getExercicios()
    {
     return new String[]{"abdominais", "polichinelos", "agachamentos",
        "esteira", "esteira", "eliptico"};
    }
    
    public int[] getValores()
    {
     return new int[]{abdominais, polichinelos, agachamentos, 
        esteira, corrida, eliptico};
    }
    
    public Aluno getAluno()
    {
        return aluno;
    }
}
