package br.ufla.gac106.s2022_1.CacadaMortal;

public class ItemCarregavel extends Item {


    public ItemCarregavel(String nome, String descricao, int peso, boolean ehArma, String caminhoImagem) {
        super(nome, descricao, peso, ehArma, caminhoImagem);
    }

    @Override
    public String getNomeItemDesbloqueia() {
        return null;
    }

    @Override
    public Item abrir(){
        return null;
    }
    @Override
    public boolean ehUmBau(){
        return false;
    }
    @Override
    public boolean ehCarregavel(){
        return true;
    }
    
}
