/**
 * Classe que representa uma galinha e herda a classe Ave
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 24/07/22
 */
public class Galinha extends Ave {
    /**
     * Construtor de Galinha
     * @param nome 
     * @param especie 
     * @param somEmitido 
     * @param quantidadeDePatas 
     * @param voaBem 
     */
    public Galinha(String nome) {
        super(nome, "galinha", "cocórioco", 2, false);
    }
}
