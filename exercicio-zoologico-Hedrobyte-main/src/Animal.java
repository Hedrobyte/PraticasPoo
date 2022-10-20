
/**
 * Classe que representa um animal
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 18/07/22
 */
public class Animal {
    private String nome;
    private String especie;
    private String somEmitido;
    private int quantidadeDePatas;

    Animal(String nome, String especie, String somEmitido, int quantidadeDePatas) {
        this.nome = nome;
        this.especie = especie;
        this.somEmitido = somEmitido;
        this.quantidadeDePatas = quantidadeDePatas;
    }

    /**
     * 
     * @return nome do animal
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return especie do animal
    */
    public String getEspecie() {
        return especie;
    }

    /**
     * 
     * @return som emitido pelo animal
    */
    public String somEmitido() {
        return somEmitido;
    }

    /**
     * 
     * @return quantidade de patas do animal
     */
    public int quantidadeDePatas() {
        return quantidadeDePatas;
    }

    /**
     * 
     * @return descrição simples do animal
     */
    public String getDescricao() {
        String descricao = nome + " é um(a) " + especie + "";
        return descricao;
    }

     /**
     * 
     * @return descrição completa do animal
     */
    public String getDescricaoLonga() {
        String descricao = nome 
                        + " é um(a) " + especie 
                        + ", que emite o som " + somEmitido
                        + ", e possui " + quantidadeDePatas + " patas ";
        return descricao;
    }
}