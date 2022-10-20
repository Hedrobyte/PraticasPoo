package covid;

public class DadosCaso extends SerieDadosCovid {

    public DadosCaso(String localidade, int diaInicial, int diaFinal) {
        super(localidade, diaInicial, diaFinal);
    }

    @Override
    public String obterIdentificacaoSerie() {
        String descricao = "Casos de covid em Lavras ";
        return descricao;
    }

}
