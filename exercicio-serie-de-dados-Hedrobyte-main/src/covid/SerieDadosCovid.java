package covid;

import java.util.HashMap;
import java.util.ArrayList;
import series.SerieDados;

/**
 * Classe que representa serie de dados de COVID
 * 
 * @author Pedro Henrique Maciel Alves
 */
public abstract class SerieDadosCovid implements SerieDados {
    private ArrayList<Integer> diasDados;
    private HashMap<String, ArrayList> dados;
    private String localidade;
    private int diaInicial, diaFinal;

    public SerieDadosCovid(String localidade, int diaInicial, int diaFinal) {
        this.localidade = localidade;
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        this.diasDados = new ArrayList<>();
        this.dados = new HashMap<>();
    }

    @Override
    public abstract String obterIdentificacaoSerie();

    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }

    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }

    @Override
    public int obterDado(int dia) {
        return diasDados.get(dia);
    }

    public void setDado(Integer dado, int dia) {
        if (dia >= diaInicial && dia <= diaFinal)
            diasDados.add(dia, dado);
        dados.put(localidade, diasDados);
    }
}