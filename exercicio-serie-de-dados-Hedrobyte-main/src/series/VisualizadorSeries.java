package series;

import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * Tela para visualização de séries de dados diários.
 * 
 * Para usar a classe crie um objeto da mesma passando uma lista de séries a serem
 * exibidas e, em seguida, chame o método exibir().
 * 
 * Usa a biblioteca JFreeChart para exibir um gráfico de linha mostrando os dados
 * da série. Obs: a janela é posicionada aleatoriamente na tela.
 * 
 * @author Julio César Alves
 * @version 2022-03-18
 */
public class VisualizadorSeries {
    
    // janela da apliacação que contém o gráfico
    private ApplicationFrame janela;
    
    /**
     * Constrói a visualização dos dados. Cria a janela e o gráfico de barras a ser exibido
     * nela.
     * 
     * @param series A lista de séries de dados que terão seus dados exibidos em um gráfico
     */
    public VisualizadorSeries(List<SerieDados> series) {
        // cria a janela
        janela = new ApplicationFrame("Visualizador Series Diarias");
        janela.setDefaultCloseOperation(ApplicationFrame.EXIT_ON_CLOSE);
        
        // cria o gráfico que contém os dados da série
        JFreeChart graficoLinha = ChartFactory.createBarChart(
                null,     // Título do gráfico
                "Dia",    // Nome do eixo X
                "Valor",  // Nome do eixo Y
                criarDataset(series),     // método que cria os dados do gráfico
                PlotOrientation.VERTICAL, // Orientação do gráfico
                true,true,false);         // legenda, tooltips, urls
        
        // adiciona o gráfico na janela
        ChartPanel painelGrafico = new ChartPanel(graficoLinha);
        painelGrafico.setPreferredSize(new Dimension(600, 400));        
        janela.setContentPane(painelGrafico);      
        janela.pack();
        
        // posiciona a janela aleatoriamente na tela
        RefineryUtilities.positionFrameRandomly(janela);
    }
    
    /**
     * Exibe a janela com o gráfico
     */
    public void exibir() {
        janela.setVisible(true);
    }

    
    /**
     * Método interno que cria o conjunto de dados do gráfico
     * 
     * @param series Lista com as séries de dados que serão exibidas no gráfico.
     * @return Retorna o conjunto de dados (dataset) do gráfico.
     */
    private DefaultCategoryDataset criarDataset(List<SerieDados> series) {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
       // Para cada série de dados
       for (SerieDados serie : series) {
           // para cada dia do gráfico adiciona um valor no conjunto de dados       
           for(int dia = serie.obterDiaInicial(); dia <= serie.obterDiaFinal(); dia++) {      
         
               dataset.addValue(
                   serie.obterDado(dia), 
                   serie.obterIdentificacaoSerie(),
                   Integer.toString(dia));
           }
        }
      
       return dataset;
    }
}

