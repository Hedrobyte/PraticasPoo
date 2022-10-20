/**
 * Classe que representa Cliente do banco
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 25/06/2022
 */

public class Cliente {
    private String nome;
    private String cpf;

    /**
     * Construtor da classe Cliente
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Método que retorna o nome do usuário
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que retorna o CPF do usuário
     */
    public String getCpf() {
        return this.cpf;
    }
}
