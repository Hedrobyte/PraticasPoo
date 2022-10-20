package covid;

public class DadosObito extends SerieDadosCovid {

    public DadosObito(String localidade, int diaInicial, int diaFinal) {
        super(localidade, diaInicial, diaFinal);
    }

    @Override
    public String obterIdentificacaoSerie() {
        String descricao = "Casos de óbito por covid em Lavras ";
        return descricao;
    }
    
}
