package br.ufla.gac106.s2022_1.CacadaMortal;

public abstract class Monstro {
    private String nome;
    private String tipo;
    private String fraqueza;
    private int qtdVida;

    public Monstro(String nome, String tipo, String fraqueza, int qtdVida){
        this.nome = nome;
        this.tipo = tipo;
        this.fraqueza = fraqueza;
        this.qtdVida = qtdVida;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }
    
    public String getFraqueza(){
        return fraqueza;
    }
    

    public int getQtdVida(){
        if(qtdVida < 0){
            return 0;
        }
        return qtdVida;
    }


    public void sofreuAtaque(String arma){
        if (fraqueza.equals(arma)){
            qtdVida -= 2;
        }
        else{
            qtdVida -= 1;
        }
    }

    public abstract boolean dropaItem();
    public abstract Item morreu();
    public abstract void nmrAtaques();
    public abstract int getNmrAtaques();
    



    
}
