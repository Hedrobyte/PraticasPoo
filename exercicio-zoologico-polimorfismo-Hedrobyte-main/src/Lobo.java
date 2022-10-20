/**
 * Classe que representa um lobo e herda a classe mamifero
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 24/07/22
 */
public class Lobo extends Mamifero {
    /**
     * Construtor de Lobo
     * @param nome 
     * @param especie 
     * @param somEmitido 
     * @param quantidadeDePatas 
     * @param corPelo
     */
    public Lobo(String nome, String corPelo) {
        super(nome, "Lobo", "Auuu", 4, corPelo);
    }
}
