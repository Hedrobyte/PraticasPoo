package br.ufla.gac106.s2022_1.CacadaMortal;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Score
{
    //atributos
    private ArrayList<Jogador> jogadores;
    private long comeco;
    private long fim;
    private static Score instancia;
    
    public Score(){
        jogadores = new ArrayList<Jogador>();
    }   
    
    public static Score getInstancia(){
        if(instancia == null){
            instancia = new Score();
        }
        return instancia;
    }
    public long getComeco(){
        return comeco = System.currentTimeMillis();
    }
    public long getFim(){
        fim = System.currentTimeMillis();
        return fim;
    }
    
    public void incluirNoScore(Jogador usuario){
      
      usuario.setTempoJogo(tempoJogo());
      
      try {
            FileWriter fw = new FileWriter("score.txt", true);
            fw.write(usuario.getNomeUsuario() + ";" + usuario.getTempoJogo() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        }
    }
    
    private long tempoJogo() {
        long tempo = (fim - comeco)/1000;
        return tempo;
    }

    public ArrayList<Jogador> mostrarScore(){
            //Leitura do arquivo txt 
            try {
                BufferedReader arq = new BufferedReader(new FileReader("Score.txt"));
                String linha = arq.readLine();
                while (linha != null) {
                    String[] dados = linha.split(";");
                    Jogador jogador = new Jogador(dados[0]);
                    jogador.setTempoJogo(Long.parseLong(dados[1]));
                    jogadores.add(jogador);
                    linha = arq.readLine();
                }
                arq.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    
        return jogadores;
    }
}