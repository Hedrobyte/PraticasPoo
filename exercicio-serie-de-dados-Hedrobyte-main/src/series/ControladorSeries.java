package series;

import java.util.List;

/**
 * Interface para controladores de Séries de Dados.
 * Define uma interface para que possam ser buscadas/consultadas séries de dados.
 * 
 * @author Julio César Alves
 */
public interface ControladorSeries {
    /**
     * Retorna uma lista de séries de dados.
     * 
     * @return A lista de séries de dados.
     */
    List<SerieDados> obterSeriesDados();
}