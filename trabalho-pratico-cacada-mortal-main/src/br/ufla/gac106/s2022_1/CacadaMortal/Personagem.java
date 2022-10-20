package br.ufla.gac106.s2022_1.CacadaMortal;

public class Personagem {
    private String nome;
    private Item item;
    private String informacao;

    public Personagem(String nome, String informacao, Item item){
        this.nome = nome;
        this.informacao = informacao;
        this.item = item; 
    }

    public String getNome(){
        return nome;
    }

    public String getInformacao(){
        return informacao;
    }

    public boolean getItem(){
        if(item != null){
            return true;
        }
        return false;
    }

    public Item entregarItem(){
        if(getItem()){
            Item aux = item;
            item = null;
            return aux;
        }
        return null;
    }
    
}
