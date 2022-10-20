package br.ufla.gac106.s2022_1.CacadaMortal;

import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;

public abstract class Item extends EntidadeGrafica {

    private String nome;
    private String descricao;
    private int peso;
    private boolean ehArma;

    public Item (String nome, String descricao, int peso, boolean ehArma, String caminhoImagem) {
        super(caminhoImagem);
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.ehArma = ehArma;
    }
    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }
    public int getPeso() {
        return peso;
    }

    public boolean ehArma(){
        return ehArma;
    }
    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    abstract public boolean ehUmBau();
    abstract public boolean ehCarregavel();
    abstract public String getNomeItemDesbloqueia();
    abstract public Item abrir();

}
