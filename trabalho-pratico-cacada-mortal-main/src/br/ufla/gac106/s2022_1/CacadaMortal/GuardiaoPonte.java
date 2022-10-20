package br.ufla.gac106.s2022_1.CacadaMortal;

public class GuardiaoPonte extends Monstro{
    private int nmrAtaques;

    public GuardiaoPonte(){
        super("guardiao", "terrestre", "arco", 14);
        nmrAtaques = 0;
    }


    public boolean dropaItem(){
        return false;
    }
    public Item morreu(){
        return null;
    }
    public void nmrAtaques(){
        nmrAtaques++;
    }

    public int getNmrAtaques(){
        if(nmrAtaques == 2){
            int aux = nmrAtaques;
            nmrAtaques = 0;
            return aux;
        }
        return nmrAtaques;
    }
    
}
