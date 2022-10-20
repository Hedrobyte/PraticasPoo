package br.ufla.gac106.s2022_1.CacadaMortal;

import br.ufla.gac106.s2022_1.baseJogo.Tela;

public class AppGrafica {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Tela("Caçada Mortal"));	
		jogo.jogar();
    }
}
