import java.util.ArrayList;

/**
 * Classe que representa um zoologico
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 24/07/22
 */
public class Zoologico {
    private ArrayList<Animal> animais;
    

    /**
     * Construtor do Zoologico
     */
    public Zoologico() {
        animais = new ArrayList<Animal>();
    }

    /**
     * Metodo para cadastrar Aguia
     * 
     * @param nome
     */
    public void cadastrarAguia(String nome) {
        this.animais.add(new Aguia(nome));
    }

    /**
     * Metodo para cadastrar galinha
     * @param nome
     */
    public void cadastrarGalinha(String nome) {
        this.animais.add(new Galinha(nome));
    }

    /**
     *  Metodo para cadastrar gato
     * @param nome
     * @param corPelo
     */
    public void cadastrarGato(String nome, String corPelo) {
        this.animais.add(new Gato(nome, corPelo));
    }

    /**
     * Metodo para cadastrar lobo
     * @param nome
     * @param corPelo
     */
    public void cadastrarLobo(String nome, String corPelo) {
        this.animais.add(new Lobo(nome, corPelo));
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
        for (Animal animal : animais) {
            if (animal.getNome().equals(nome))
                return animal.getDescricaoLonga();
        }
        return null;
    }

    /**
     * metodo para listar a descricao dos animais do zoologico
     */
    public String listarAnimais() {
        String lista = "";

        for (Animal animal : animais) {
            lista = lista + animal.getDescricao() + "\n";
        }
        return lista;
    }

    /**
     * metodo para listar a descricao longa dos animais do zoologico
     */
    public String listarAnimaisCompleto() {
        String listaCompleta = "";
        for (Animal animal : animais) {
            listaCompleta = listaCompleta + animal.getDescricaoLonga() + "\n";
        }
        return listaCompleta;
    }
}
