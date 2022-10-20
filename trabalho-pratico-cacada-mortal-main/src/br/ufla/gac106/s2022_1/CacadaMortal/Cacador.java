package br.ufla.gac106.s2022_1.CacadaMortal;

import java.util.ArrayList;

public class Cacador {
    private static Cacador instanciaUnica;
    private String nome;
    private int vida;
    private ArrayList<Item> mochila;
    
    private Cacador(String nome) {
        this.nome = nome;
        this.vida = 18;
        mochila = new ArrayList<Item>();
    }

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    public int getVida(){
        return vida;
    }

    public void sofreuAtaque(){
        vida -= 2;
    }

    /**
     * @param item
     */
    public void addItem(Item item) {
        mochila.add(item);
    }

    public Item removerItem(String item){
        for (Item i: mochila){
            if((i.getNome()).equals(item)){
                mochila.remove(i);
                return i;
            }
        }
        return null;
    }

    public String listaItens(){
        String texto="";
        for (Item i: mochila){
            texto+=" -"+i.getNome();
        }
        return texto;
    }

    public boolean possuiArma(String arma){
        for(Item i: mochila){
            if(i.getNome().equals(arma)){
                if (i.ehArma()){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public Item temItem(String item){
        for (Item i: mochila){
            if((i.getNome()).equals(item)){
                return i;
            }
        }
        return null;
    }

    /**
     * @return pesoTotal da mochila
     */
    public int verificaPesoMochila() {
        int pesoTotal=0;
        for (Item i: mochila){
            pesoTotal+=i.getPeso();
        }
        return pesoTotal;
    }
    public boolean mochilaCheia(){
        return verificaPesoMochila()>=4;
    }

    public static Cacador getInstancia(){
        if(instanciaUnica == null){
            instanciaUnica = new Cacador("Jhon");

        }

        return instanciaUnica;
    }

}
