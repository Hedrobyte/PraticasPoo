import java.util.ArrayList;
import java.util.List;

import covid.Controle;
import series.ControladorSeries;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        ControladorSeries controle = new Controle();
        List<SerieDados> series = new ArrayList<>();
        series = controle.obterSeriesDados();

        VisualizadorSeries visualizadorSeries = new VisualizadorSeries(series);
        visualizadorSeries.exibir();
        
        int i=1;
        /*Por algum motivo não consegui executar o for*/
        for(SerieDados serie: series) {
            System.out.println("Dia " + i + serie.obterDado(i));
        i++;
        }
    }
}
