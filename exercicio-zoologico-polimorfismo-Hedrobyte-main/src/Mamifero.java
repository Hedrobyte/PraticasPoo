/**
 * Classe que representa um mamifero e herda a classe Animal
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 23/07/22
 */
public class Mamifero extends Animal {
    private String corPelo;

    /**
     * Construtor de mamifero
     * @param nome
     * @param especie
     * @param somEmitido 
     * @param quantidadeDePatas 
     * @param corPelo 
     */
    public Mamifero(String nome, String especie, String somEmitido, int quantidadeDePatas, String corPelo) {
        super(nome, especie, somEmitido, quantidadeDePatas);
        this.corPelo = corPelo;
    }

    /**
     * @return corPelo do mamifero
     */
    public String getcorPelo() {
        return corPelo;
    }

    /**
     * @return descriçao longa do mamifero
     */
    @Override
    public String getDescricaoLonga() {
        String descricao = super.getDescricaoLonga();
        descricao = descricao + " e tem pelo " + corPelo; 
        return descricao;
    }
}
