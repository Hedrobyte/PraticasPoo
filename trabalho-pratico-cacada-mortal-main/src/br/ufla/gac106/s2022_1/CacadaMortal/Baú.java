package br.ufla.gac106.s2022_1.CacadaMortal;

public class Baú  extends Item{
    
    private Item itemDoBau;
    private String nomeItemDesbloqueia;
    
    public Baú(String nome, String descricao, Item itemDoBau,String nomeItemDesbloqueia,String caminhoImagem) {
        super(nome, descricao, 10, false,caminhoImagem);
        this.itemDoBau = itemDoBau;
        this.nomeItemDesbloqueia = nomeItemDesbloqueia;
    }
   
    @Override
    public Item abrir(){
        Item itemDentroDoBau = itemDoBau;
        itemDoBau = null;
        return itemDentroDoBau;
    }
    
    @Override
    public String getNomeItemDesbloqueia(){
        return nomeItemDesbloqueia;
    }
   
    @Override
    public boolean ehUmBau(){
        return true;
    }
   
    @Override
    public boolean ehCarregavel(){
        return false;
    }
}
