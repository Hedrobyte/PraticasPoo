package interfaceGrafica;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import corredores.Competidor;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.FilteredImageSource;
import java.awt.Toolkit;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tela {
    // janela que define a tela
    private JFrame janela;
    // caixa de texto para definir a distância da corrida
    private JTextField caixaTextoDistancia;
    // botão para iniciar a corrida
    private JButton botaoIniciarCorrida;
    // botão para interromper a corrida
    private JButton botaoInterromperCorrida;
    // botão para atualizar o status a corrida
    private JButton botaoAtualizarCorrida;

    // painel para desenho da corrida (usa uma classe interna)
    private PainelDeDesenho painelDeDesenho;

    // lista dos competidores da corrida
    List<Competidor> competidores;
    // lista de threads para cada corredor;
    List<Thread> threads;
    // distância da corrida
    int distanciaDaCorrida;

    /**
     * Cria a tela e deixa pronta para uso
     */
    public Tela() {
        // cria os competidores da corrida
        criarCompetidores();
        // cria os componentes da janela
        criarComponentes();  
        // trata a inscrição em eventos
        tratarEventos();        
        // monta a janela
        montarJanela();
    }

    /*
     * Cria a lista de competidores
     */
    private void criarCompetidores() {
        // cria a lista de competidores
        competidores = new ArrayList<>();
        threads = new ArrayList<>();

        // COMPLETE AQUI A CRIAÇÃO DOS COMPETIDORES

    }

    /**
     * Cria os componentes da tela
     */
    private void criarComponentes() {
        janela = new JFrame("Corrida usando threads!");
        
        caixaTextoDistancia = new JTextField("50");
        
        botaoIniciarCorrida = new JButton("Iniciar Corrida");
        botaoInterromperCorrida = new JButton("Interromper Corrida");
        botaoAtualizarCorrida = new JButton("Atualizar");
        
        painelDeDesenho = new PainelDeDesenho();
    }

    /**
     * Trata a inscrição nos eventos de clique e de mouse
     */
    private void tratarEventos() {
        botaoIniciarCorrida.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    iniciarCorrida();
                }
            }
        );
        
        botaoInterromperCorrida.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interromperCorrida();
                }
            }
        ); 
        
        botaoAtualizarCorrida.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    atualizarCorrida();
                }
            }
        ); 
    }

    /**
     * Monta a janela (define tamanho, layout, coloca os componentes, etc.)
     */
    private void montarJanela() {
        // define que ao fechar a janela, a aplicação será fechada
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // define que a janela usará o BorderLayout
        janela.setLayout(new BorderLayout());

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.add(new JLabel("Distância da corrida (em metros):"));
        caixaTextoDistancia.setColumns(10);
        caixaTextoDistancia.setHorizontalAlignment(JTextField.RIGHT);
        painelSuperior.add(caixaTextoDistancia);
        painelSuperior.add(botaoIniciarCorrida);
        painelSuperior.add(botaoInterromperCorrida);
        painelSuperior.add(botaoAtualizarCorrida);
        janela.add(painelSuperior, BorderLayout.NORTH);
        
        janela.add(painelDeDesenho, BorderLayout.CENTER);

        janela.pack();
    }

    /*
     * Exibe a janela maximizada
     */
    public void exibir() {
        janela.setVisible(true);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /*
     * Inicia uma nova corrida com a distância escolhida
     */
    private void iniciarCorrida() {
        distanciaDaCorrida = 0;
        try {
            distanciaDaCorrida = Integer.parseInt(caixaTextoDistancia.getText());
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(janela, "A distância da corrida deve ser um valor inteiro", "Ops...", JOptionPane.ERROR_MESSAGE);
        }

        if (distanciaDaCorrida > 0) {
            threads.clear();

            // COLOQUE AQUI AS THREADS DE CADA COMPETIDOR
            
            
            painelDeDesenho.repaint();

            // COLOQUE AQUI A THREAD DE VISUALIZAÇÃO AUTOMÁTICA


        }
    }
        
    /*
     * Interrompe uma corrida em execução
     */
    private void interromperCorrida() {
        // interrompe as threads dos competidores
        for (Thread thread : threads) {
            thread.interrupt();
        }
        painelDeDesenho.repaint();
    }

    /*
     * Atualiza o status da corrida na tela
     */
    private void atualizarCorrida() {
        painelDeDesenho.repaint();
    }

    /**
     * Classe interna para a area de desenho na janela
     */
    private class PainelDeDesenho extends JPanel { 
        // largura para o nome do corredor
        private final int larguraNome = 100;
        // altura da faixa de cada corredor em pixels
        private final int alturaFaixaCorredor = 60;
        // fator de escala (1 metro na corrida significa x pixels)
        private final int fatorDeEscala = 10;
        // fonte usada para o nome do corredor
        private final Font fonteNome = new Font("Monospaced", Font.BOLD, 18);
        // pasta onde se encontram os recursos
        private final String pastaRecursos = "resources/";
        // objetos para as imagens usadas no jogo
        private List<BufferedImage> imgSpritesCompetidores;
        // índice atual do sprite de cada competidor
        private HashMap<String, Integer> indiceSpriteCompetidores;

        /*
         * Constrói o painel de desenho
         */
        public PainelDeDesenho() {                        
            imgSpritesCompetidores = new ArrayList<>();
            indiceSpriteCompetidores = new HashMap<>();
            for (Competidor competidor : competidores) {
                indiceSpriteCompetidores.put(competidor.getNome(), 0);
            }
            try {
                // carrega as imagens usadas na corrida
                // As imagens são do autor chipmunk, disponíveis em: https://opengameart.org/content/runner-sprite
                imgSpritesCompetidores.add(ImageIO.read(new File(pastaRecursos + "runner.png")));
                for (int i = 1; i <= 8; i++) {
                    imgSpritesCompetidores.add(ImageIO.read(new File(pastaRecursos + "runner" + i + ".png")));
                }                
            } catch(Exception e) {	
                JOptionPane.showMessageDialog(painelDeDesenho, "Houve algum erro ao carregar os recursos", "Ops...", JOptionPane.ERROR_MESSAGE);
            }

            tornarImagensTransparentes();
        }

        /**
         * Método chamado para desenhar o painel de desenho
         */
        @Override
        public void paintComponent(Graphics g) {                        
            super.paintComponent(g);

            // desenha o fundo da corrida
            desenharFundo(g);

            // desenha os competidores
            desenharCompetidores(g);
        }

        /**
         * Desenha a área de fundo da corrida
         * 
         * @param g componente grafico de desenho
         */
        private void desenharFundo(Graphics g) {
            Dimension tamanho = getSize();                        
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, (int)tamanho.getWidth(), (int)tamanho.getHeight());            
        }

        /**
         * Desenha os competidores
         * 
         * @param g componente grafico de desenho
         */
        private void desenharCompetidores(Graphics g) {           
            int posX = 20;
            int posY = 20;

            g.setColor(Color.WHITE);
            g.setFont(fonteNome);

            for (Competidor competidor : competidores) {
                // desenha o nome do competidor                    
                g.drawString(competidor.getNome(), posX, posY+alturaFaixaCorredor/2);

                // desenha a área de corrida
                g.fillRect(posX+larguraNome, posY+alturaFaixaCorredor/2, fatorDeEscala*distanciaDaCorrida+imgSpritesCompetidores.get(0).getWidth(), 1);

                // desenha o sprite do competidor
                int posXCorredor = posX+larguraNome+fatorDeEscala*competidor.getDistanciaPercorrida();
                if (!competidor.estaCorrendo()) {
                    g.drawImage(imgSpritesCompetidores.get(0), posXCorredor, posY, null);
                }
                else {
                    int indiceSprite = indiceSpriteCompetidores.get(competidor.getNome());
                    g.drawImage(imgSpritesCompetidores.get(indiceSprite), posXCorredor, posY, null);
                    indiceSpriteCompetidores.put(competidor.getNome(), (indiceSprite % 8) + 1);
                }                
                posY += alturaFaixaCorredor;
            }
        }

        /*
         * Torna as imagens dos sprites transparentes
         */
        private void tornarImagensTransparentes() {
            // Assume que o pixel na posição (0,0) contém a cor que define a transparência
            if (imgSpritesCompetidores.size() > 0) {
                Color corTransparente = new Color(imgSpritesCompetidores.get(0).getRGB(0,0));

                for (int i = 0; i < imgSpritesCompetidores.size(); i++) {
                    imgSpritesCompetidores.set(i,  converterParaBufferedImage(
                                                        tornarImagemTransparente(imgSpritesCompetidores.get(i), corTransparente))
                                              );
                }                
            }
        }

        /*
         * Retorna uma nova imagem criada a partir da imagem passada, mas com a cor informada se
         * tornando transparente.
         * Fonte: https://stackoverflow.com/a/22720434/8603373
         */
        private Image tornarImagemTransparente(Image imagem, final Color cor) {
            // cria um objeto de uma nova classe de filtro
            ImageFilter filtro = new RGBImageFilter() {        
                // Esse trecho garante que a cor passada é opaca (sem tranparência)
                public int corAProcurar = cor.getRGB() | 0xFF000000;

                public final int filterRGB(int x, int y, int rgb) {
                    // Se a cor passada, tornada opaca, for igual a cor transparente
                    if ((rgb | 0xFF000000) == corAProcurar) {
                        // Define os bits alpha como zero (ou seja, torna a cor transparente)
                        return 0x00FFFFFF & rgb;
                    } else { // se não for a cor procurada
                        // retorna a própria cor recebida
                        return rgb;
                    }
                }
            };
        
            ImageProducer ip = new FilteredImageSource(imagem.getSource(), filtro);
            return Toolkit.getDefaultToolkit().createImage(ip);
        }

        /**
         * Converte um objeto Image em um BufferedImage.
         * Fonte: https://stackoverflow.com/a/13605411/8603373
         *
         * @param imagem A imagem a ser convertida
         * @return O objeto BufferedImage gerado
         */
        private BufferedImage converterParaBufferedImage(Image imagem) {
            if (imagem instanceof BufferedImage) {
                return (BufferedImage) imagem;
            }

            // Cria uma imagem bufferizada com transparência
            BufferedImage imagemBufferizada = new BufferedImage(imagem.getWidth(null), imagem.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            // Desenha a imagem na imagem bufferizada
            Graphics2D bGr = imagemBufferizada.createGraphics();
            bGr.drawImage(imagem, 0, 0, null);
            bGr.dispose();

            // Retorna a imagem bufferizada
            return imagemBufferizada;
        }
    }
}
