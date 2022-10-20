/**
 * Classe que representa uma Aguia e herda a classe Ave
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 24/07/22
 */
public class Aguia extends Ave {
    /**
     * Construtor de Ave
     * @param nome 
     * @param especie 
     * @param somEmitido 
     * @param quantidadeDePatas 
     * @param voaBem 
     */
    public Aguia(String nome) {
        super(nome, "aguia", "croac", 2, true);
    }
}
