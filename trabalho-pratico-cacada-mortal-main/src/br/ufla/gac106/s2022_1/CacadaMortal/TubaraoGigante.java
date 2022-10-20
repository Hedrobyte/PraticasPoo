package br.ufla.gac106.s2022_1.CacadaMortal;

public class TubaraoGigante extends Monstro {
    private Item item;


    public TubaraoGigante(Item item){
        super("tutuba", "aquático", "faca", 6);
        this.item = item;
    }

    public boolean dropaItem(){
        return true;
    }

    public Item morreu(){
        Item aux = item;
        item = null;
        return aux;
    }

    public void nmrAtaques(){
    } 
    
    public int getNmrAtaques(){
        return 0;
    }
    
}
