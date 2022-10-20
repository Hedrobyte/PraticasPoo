/**
 * Classe que representa um gato e herda a classe mamifero
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 24/07/22
 */
public class Gato extends Mamifero {
    /**
     * Construtor de gato
     * @param nome 
     * @param especie 
     * @param somEmitido 
     * @param quantidadeDePatas 
     * @param corPelo
     */
    public Gato(String nome, String corPelo) {
        super(nome, "gato", "miau", 4, corPelo);
    }
}
