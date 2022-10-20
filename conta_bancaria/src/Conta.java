
/**
 * Classe que representa uma conta bancaria
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 03/07/2022
 */
public class Conta {
    // Variável que guarda o número da conta
    private int numConta;

    // Variável que guarda o número da última conta criada
    private static int geraNumConta = 1000;

    // Variável que guarda o saldo
    private double saldo;

    // Variável que guarda o valor limite
    private double valorLimite;

    // Variável que guarda o cliente
    private Cliente cliente;

    /**
     * Construtor para objetos da classe Conta
     */
    public Conta(Cliente cliente, double valorlimite) {
        this.cliente = cliente;
        this.valorLimite = - valorlimite;
        this.saldo = 0.0;
        this.numConta = geraNumConta;
        this.geraNumConta += 1;
    }

    /**
     * Método que retorna o numero da conta
     */
    public int getNumConta() {
        return numConta;
    }

    /**
     * Método que retorna o valor do saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método que retorna o nome do cliente
     */
    public String getNomeCliente() {
        return cliente.getNome();
    }

    /**
     * Método que saca valores da conta
     */
    public boolean saque(double valor) {
        if (trataSaque(valor)) {
            this.saldo -= valor;
            return true;
        } else 
            return false;
    }

    /**
     * Método de tratamento para saques de valores na conta
     * 
     * trata:
     * - (saldo - valor de saque) < limite)
     */
    private boolean trataSaque(double valor) {
        if ((this.saldo - valor) < valorLimite) {
            return false;
        } else
            return true;
    }

    /**
     * Método que deposita de valores na conta
     */
    public boolean deposito(double valor) {
        if (trataDeposito(valor)) {
            this.saldo = this.saldo + valor;
            return true;
        } else
            return false;
    }

    /**
     * Método de tratamento para depósitos de valores na conta
     * 
     * trata:
     * - (valor de deposito + saldo em conta) > valor Máximo permitido
     * - valore de deposito <= 0
     */
    private boolean trataDeposito(double valor) {
        if (valor <= 0) {
            return false;
        } else
            return true;
    }

    /**
     * Método que trasfere valor de uma conta para outra
     * 
     */
    public boolean trasfere(double valor, Conta conta) {

        if (this.saque(valor)) {
            conta.deposito(valor);
            return true;
        }
        else 
            return false;
    }
}       
