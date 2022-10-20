/**
 * Classe que representa uma ave e herda a classe Animal
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 23/07/22
 */
public class Ave extends Animal {
    private boolean voaBem = false;

    /**
     * Construtor de Ave
     * @param nome
     * @param especie 
     * @param somEmitido
     * @param quantidadeDePatas
     * @param voaBem
     */
    public Ave(String nome, String especie, String somEmitido, int quantidadeDePatas, Boolean voaBem) {
        super(nome, especie, somEmitido, quantidadeDePatas);
        this.voaBem = voaBem;
    }

    /**
     * @return voaBem(True or false)
     */
    public boolean getVoaBem() {
        return voaBem;
    }

    /**
     * @return descriçao longa da ave
     */
    @Override
    public String getDescricaoLonga() {
        String descricao = super.getDescricaoLonga();
        if (!voaBem)
            descricao = descricao + "e não voa bem! ";
        else 
            descricao = descricao + "e voa bem! ";
        return descricao;
    }
}
