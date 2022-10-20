package br.ufla.gac106.s2022_1.CacadaMortal;

public class Jogador {
    private String nomeUsuario;
    private long tempoJogo;
    
    public Jogador(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
        this.tempoJogo = 0;
    }
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    
    public long getTempoJogo(){
        return tempoJogo;
    }
    
    public void setTempoJogo(long tempoJogo){
        this.tempoJogo = tempoJogo;
    }

}
