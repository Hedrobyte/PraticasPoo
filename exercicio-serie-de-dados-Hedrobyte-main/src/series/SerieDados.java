package series;

/**
 * Interface para definir o que uma Série de Dados deve ter.
 * 
 * Uma série de dados tem um dia inicial e um dia final e valores inteiros correspondentes a cada dia.
 * 
 * Por questão de simplicidade os dias são representados por números inteiros.
 * Assim podemos ter dados, por exemplo, do dia 5 ao dia 30.
 * 
 * @author Julio César Alves
 */
public interface SerieDados {
    /**
     * Retorna uma string que representa o nome ou a identificação da série de
     * dados diários em questão.
     * 
     * @return Nome ou identificação da série de dados
     */
    String obterIdentificacaoSerie();
    
    /**
     * Retorna o primeiro dia para o qual a série tem dados. Exemplo: dia 5.
     * Considera-se que a série tem dados para todos os dias desde o dia inicial
     * até o dia final.
     * 
     * @return O primeiro dia que possui dados.
     */
    int obterDiaInicial();
    
    /**
     * Retorna o último dia para o qual a série tem dados. Exemplo: dia 21.
     * Considera-se que a série tem dados para todos os dias desde o dia inicial
     * até o dia final.
     * 
     * @return O último dia que possui dados.
     */
    int obterDiaFinal();
    
    /**
     * Retorna o dado correspondente a um dia da série de dados.
     * Obs: seria mais eficiente o retorno de um conjunto de dados, mas está
     * assim por motivos didáticos.
     * 
     * @param dia Dia para o qual se deseja obter o dado correspondente.
     */
    int obterDado(int dia);
}
