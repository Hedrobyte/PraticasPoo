package covid;
import java.util.ArrayList;
import java.util.List;

import series.ControladorSeries;
import series.SerieDados;

public class Controle implements ControladorSeries {
    private List<SerieDados> listaDadosCovid;

    public Controle () {
        listaDadosCovid = new ArrayList<>();
        DadosCaso dadosCaso = new DadosCaso("Lavras", 1, 4);
        DadosObito dadosObito = new DadosObito("Lavras", 1, 4);
        dadosCaso.setDado(10, 1);
        dadosCaso.setDado(12, 2);
        dadosCaso.setDado(16, 3);
        dadosCaso.setDado(18, 4);
        dadosObito.setDado(2, 1);
        dadosObito.setDado(4, 2);
        dadosObito.setDado(7, 3);
        dadosObito.setDado(10, 4);
        listaDadosCovid.add(dadosCaso);
        listaDadosCovid.add(dadosObito);
    }

    @Override
    public List<SerieDados> obterSeriesDados() {
        return listaDadosCovid;
    }
    
}
