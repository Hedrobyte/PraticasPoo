import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe que representa uma conta de banco
 * 
 * @author Pedro Henrique Maciel Alves
 * @version 03/07/2022
 */
public class Banco {
    // Variável de ArrayList para armazenar contas
    private ArrayList<Conta> contas = new ArrayList<>();

    // Variável para guardar dados do cliente
    private Cliente cliente;

    // Variável para receber nome do usuário
    private String nomeCliente;

    // Variável para receber o cpf do usuário
    private String cpfCliente;

    // Scanner para obter dados do usuário
    private Scanner entrada;

    // Variável para receber valores
    private double valor = 0;

    // Variável para receber valores limites
    private double valorLimite = 0;

    // Variável para controle de opcões
    private int opcao = 0;

    /**
     * Método construtor da classe Banco
     */
    public Banco() {
        entrada = new Scanner(System.in);
        // Lista de contas
        contas = new ArrayList<Conta>();
    }

    /**
     * Método que trata o loop do menu
     */
    public void executarMenu() {
        while (opcao != 8) {
            exibirMenu();

            System.out.println("- Insira a opção desejada: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);
        }
        entrada.close();
    }

    /**
     * Método que exibe as opções do menu
     */
    public void exibirMenu() {
        System.out.println("   *MENU PRÍNCIPAL* \n");
        System.out.println("1) Criar conta ");
        System.out.println("2) Consultar saldo ");
        System.out.println("3) Depositar ");
        System.out.println("4) Sacar ");
        System.out.println("5) Tranferência entre contas ");
        System.out.println("6) Listar contas existentes ");
        System.out.println("7) Remover contas ");
        System.out.println("8) Sair ");
    }

    /**
     * Método que trata a opção do menu escolhida pelo úsuario
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                consultarSaldo();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                transferencia();
                break;
            case 6:
                getContasCasdastradas();
                break;
            case 7:
                removeConta();
                break;
            case 8:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida! \n");
                break;
        }
        // Se o usuário não estiver saindo do programa, pede para ele digitar ENTER
        // antes de exibir o menu novamente
        if (opcao != 8) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /**
     * Método para criar cliente
     */
    private void criarCliente() {
        System.out.println("Insira o nome do Cliente: ");
        nomeCliente = entrada.nextLine();

        System.out.println("Insira o CPF do Cliente: ");
        cpfCliente = entrada.nextLine();

        // Cria Cliente
        cliente = new Cliente(nomeCliente, cpfCliente);
    }

    /**
     * Método para criar conta no banco
     */
    private void criarConta() {
        System.out.println("   MENU DE CRIAÇÃO DE CONTA \n");

        criarCliente();

        // Variável auxiliar para manipular contas
        Conta contaAux;

        System.out.println("Insira o valor limite da conta: ");
        valorLimite = Double.parseDouble(entrada.nextLine());

        // Cria conta do cliente
        contaAux = new Conta(cliente, valorLimite);
        System.out.println("O NÚMERO DA CONTA criada é " + contaAux.getNumConta());

        // Adiciona conta do cliente ao final da lista
        contas.add(contaAux);

        System.out.println("");
    }

    /**
     * Método que trata a verificação da existencia de uma conta no sistema
     *
     */
    private boolean existeConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumConta() == numeroConta)
                return true;
        }
        return false;
    }

    /**
     * Método que consulta index da conta procurada
     */
    private int consultaIndexConta(int numeroConta) {
        int i = 0;
        for (Conta conta : contas) {
            if (conta.getNumConta() == numeroConta)
                i = contas.lastIndexOf(conta);
        }
        return i;
    }

    /**
     * Método para consultar saldo em conta
     */
    private void consultarSaldo() {
        System.out.println("   *MENU DE CONSULTA DO SALDO* \n");
        tratarConsultaSaldo();
    }

    /**
     * Método para tratar consulta de saldo em conta
     */
    private void tratarConsultaSaldo() {
        // Áuxiliar para manipular número de conta
        int numConta = numeroContaProcurada();

        // Caso o Número da conta esteja no cadastrado no sistema
        if (existeConta(numConta)) {
            // Consulta o index da conta procurada
            int indexConta = consultaIndexConta(numConta);
            System.out.println("Número da conta: " + numConta);
            System.out.println("Cliente: " + contas.get(indexConta).getNomeCliente());
            System.out.println("Saldo  : " + contas.get(indexConta).getSaldo());
            System.out.println("");
        } else
            System.out.println("CONTA NÃO ENCONTRADA! \n");
    }

    /**
     * Método para depositar valores na conta
     */
    private void depositar() {
        System.out.println("   *DEPOSITO DE VALORES* \n");
        tratarDepositar();
    }

    /**
     * Método de tratamento para deposito
     */
    private void tratarDepositar() {
        // Áuxiliar para manipular número de conta
        int numConta = numeroContaProcurada();

        // Caso o Número da conta esteja no cadastrado no sistema
        if (existeConta(numConta)) {

            // Retorna a posicão do índice da conta
            int indexConta = consultaIndexConta(numConta);

            System.out.println("Digite o valor de depósito: ");
            valor = Double.parseDouble(entrada.nextLine());

            // Deposita o valor na conta
            if (contas.get(indexConta).deposito(valor))
                System.out.println("VALOR DE " + valor + "$ FOI DEPOSITADO COM SUCESSO! \n");

        } else
            System.out.println("CONTA NÃO ENCONTRADA! \n");
    }

    /**
     * Método para sacar valores da conta
     */
    private void sacar() {
        System.out.println("   *SAQUE DE VALORES* \n");
        tratarSaque();
    }

    /**
     * Método de tratamento para saque e limite de saque
     */
    private void tratarSaque() {

        // Áuxiliar para manipular número de conta
        int numConta = numeroContaProcurada();

        // Caso o Número da conta esteja no cadastrado no sistema
        if (existeConta(numConta)) {

            // Retorna a posicão do índice da conta
            int indexConta = consultaIndexConta(numConta);

            System.out.println("Digite o valor de saque: ");
            valor = Double.parseDouble(entrada.nextLine());

            // Procura a conta na lista do sistema e faz o saque

            if (contas.get(indexConta).deposito(valor)) {
                System.out.println("VALOR DE " + valor + "$ FOI SACADO COM SUCESSO! \n");
            } else
                System.out.println("LIMITE DE SAQUE EXEDIDO! (Verifique seu limite e tente novamente.) \n");
        } else
            System.out.println("CONTA NÃO ENCONTRADA! \n");

    }

    /**
     * Método de para inserir e retornar o número da conta desejada
     */
    private int numeroContaProcurada() {
        System.out.println("Insira o número da conta: ");
        return Integer.parseInt(entrada.nextLine());
    }

    /**
     * Método que faz transferência entre duas contas
     */
    public void transferencia() {
        System.out.println("   *MENU PARA TRANSFERÊNCIA ENTRE CONTAS* \n");

        System.out.println("Inserir conta de origem ");

        // Variável para procurar o número da conta origem
        int numeroConta = numeroContaProcurada();

        System.out.println("Inserir conta de destino ");

        // Variável para procurar o número da conta destino
        int numeroConta2 = numeroContaProcurada();

        tratarTranferencia(numeroConta, numeroConta2);
    }

    /**
     * Método para tratar a transferência entre duas contas
     */
    private void tratarTranferencia(int numConta, int numConta2) {
        if (tratarErroTransferencia(numConta, numConta2)) {
            System.out.println("Insira o valor de tranferência pra conta " + numConta2 + ": ");
            valor = Double.parseDouble(entrada.nextLine());

            if (tratarErroTransferencia(numConta, numConta2)) {
                // Retorna a posicão do índice da conta de origem
                int indexConta = consultaIndexConta(numConta);
                // Retorna a posicão do índice da conta de de destino
                int indexConta2 = consultaIndexConta(numConta2);

                // Realiza transferência
                if (contas.get(indexConta).trasfere(valor, contas.get(indexConta2))) {
                    System.out.println("VALOR DE " + valor + "$ TRANSFERIDO COM SUCESSO! \n");
                } else
                    System.out.println(
                            "LIMITE DE SAQUE EXEDIDO! (Verifique seu limite e tente novamente.) \n");
            }
        }
    }

    /**
     * Método para tratar erros do tratamento de tranferência
     */
    private boolean tratarErroTransferencia(int numConta, int numConta2) {
        // Verifica se conta de origem e conta de destino inseridas não são iguais
        if ((numConta != numConta2)) {
            // Verifica se conta de origem inserida existe no sistema
            if (existeConta(numConta)) {
                // Verifica se conta de destino inserida existe no sistema
                if (existeConta(numConta2)) {
                    return true;
                } else {
                    System.out.println("!(NÚMERO DA CONTA DE DESTINO NÃO ENCONTRADO) \n");
                    return false;
                }
            } else {
                System.out.println("!(NÚMERO DA CONTA DE ORIGEM NÃO ENCONTRADO) \n");
                return false;
            }
        } else {
            System.out.println("!(CONTA DE ORIGEM E CONTA DE DESTINO SÃO IGUAIS) \n");
            return false;
        }
    }

    /**
     * Método que exibe contas já cadastradas
     */
    private void getContasCasdastradas() {
        for (int i = 0; i < contas.size(); i++) {
            System.out.print(contas.get(i).getNumConta() + " ");
            System.out.println(contas.get(i).getNomeCliente());
        }
    }

    /**
     * Método para remoção de contas
     */
    private void removeConta() {
        System.out.println("   *MENU REMOÇÃO DE CONTAS* \n");
        System.out.println("Insira o numero da conta que deseja remover: ");
        int numConta = Integer.parseInt(entrada.nextLine());
        if (existeConta(numConta))
            tratarRemocaoConta(numConta);
        else 
            System.out.println("CONTA NÃO ENCONTRADA! \n");
    }

    /**
     * Método que trata remoção de conta
     */
    private void tratarRemocaoConta(int numeroConta) {
        int indexConta = consultaIndexConta(numeroConta);
        // Verifica se o saldo esta zerado
        if (verificaSaldo(indexConta)) {
            contas.remove(indexConta);
            System.out.println("CONTA EXCLUÍDA COM SUCESSO! \n");
        }
    }

    /**
     * Método que verifica se saldo em conta é positivo, negativo, ou nulo
     */
    private boolean verificaSaldo(int index) {
        // Caso o saldo em conta seja igual que $0.0
        if (contas.get(index).getSaldo() == 0.0) {
            return true;
        }
        // Caso o saldo em conta seja maior que $0.0
        else if (contas.get(index).getSaldo() < 0.0) {
            System.out.println("NÃO É POSSÍVEL EXCLUIR CONTA COM SALDO EM CONTA! ");
            return false;
        }
        // Caso o saldo em conta seja menor que $0.0
        else {
            System.out.println("NÃO É POSSÍVEL EXCLUIR CONTA COM SALDO NEGATIVO! ");
            return false;
        }
    }
}