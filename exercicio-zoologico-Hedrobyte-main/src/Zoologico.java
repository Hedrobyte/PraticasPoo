import java.util.ArrayList;

/**
 * Classe que representa um zoologico
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 24/07/22
 */
public class Zoologico {
    private ArrayList<Aguia> aguias;
    private ArrayList<Galinha> galinhas;
    private ArrayList<Gato> gatos;
    private ArrayList<Lobo> lobos;

    /**
     * Construtor do Zoologico
     */
    public Zoologico() {
        aguias = new ArrayList<Aguia>();
        galinhas = new ArrayList<Galinha>();
        gatos = new ArrayList<Gato>();
        lobos = new ArrayList<Lobo>();
    }

    /**
     * Metodo para cadastrar Aguia
     * 
     * @param nome
     */
    public void cadastrarAguia(String nome) {
        this.aguias.add(new Aguia(nome));
    }

    /**
     * Metodo para cadastrar galinha
     * @param nome
     */
    public void cadastrarGalinha(String nome) {
        this.galinhas.add(new Galinha(nome));
    }

    /**
     *  Metodo para cadastrar gato
     * @param nome
     * @param corPelo
     */
    public void cadastrarGato(String nome, String corPelo) {
        this.gatos.add(new Gato(nome, corPelo));
    }

    /**
     * Metodo para cadastrar lobo
     * @param nome
     * @param corPelo
     */
    public void cadastrarLobo(String nome, String corPelo) {
        this.lobos.add(new Lobo(nome, corPelo));
    }

    /**
     * Metodo que retorna a descricao longa de um determinado animal
     * 
     * @param nome
     * @return descricaoLoga
     */
    public String descreverAnimal(String nome) {
        String descricaoLonga;
        descricaoLonga = buscarAnimal(nome);
        return descricaoLonga;
    }

    /**
     * Metodo para buscar animal pelo nome e retornar sua descricao longa
     * 
     * @param nome
     * @return descricaoLonga do animal procurado
     */
    private String buscarAnimal(String nome) {
        for (Animal aguia : aguias) {
            if (aguia.getNome().equals(nome))
                return aguia.getDescricaoLonga();
        }

        for (Animal galinha : galinhas) {
            if (galinha.getNome().equals(nome))
                return galinha.getDescricaoLonga();
        }

        for (Animal gato : gatos) {
            if (gato.getNome().equals(nome))
                return gato.getDescricaoLonga();
        }

        for (Animal lobo : lobos) {
            if (lobo.getNome().equals(nome))
                return lobo.getDescricaoLonga();
        }

        return null;
    }

    /**
     * metodo para listar a descricao dos animais do zoologico
     */
    public String listarAnimais() {
        String lista = "";

        for (Animal aguia : aguias) {
            lista = lista + aguia.getDescricao() + "\n";
        }
        for (Animal galinha : galinhas) {
            lista = lista + galinha.getDescricao() + "\n";
        }
        for (Animal gato : gatos) {
            lista = lista + gato.getDescricao() + "\n";
        }
        for (Animal lobo : lobos) {
            lista = lista + lobo.getDescricao() + "\n";
        }
        return lista;
    }

    /**
     * metodo para listar a descricao longa dos animais do zoologico
     */
    public String listarAnimaisCompleto() {
        String listaCompleta = "";
        for (Animal aguia : aguias) {
            listaCompleta = listaCompleta + aguia.getDescricaoLonga() + "\n";
        }
        for (Animal galinha : galinhas) {
            listaCompleta = listaCompleta + galinha.getDescricaoLonga() + "\n";
        }
        for (Animal gato : gatos) {
            listaCompleta = listaCompleta + gato.getDescricaoLonga() + "\n";
        }
        for (Animal lobo : lobos) {
            listaCompleta = listaCompleta + lobo.getDescricaoLonga() + "\n";
        }
        return listaCompleta;
    }
}
