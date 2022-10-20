package br.ufla.gac106.s2022_1.CacadaMortal;

/**
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 * 
 * Essa classe guarda uma enumeração de todos os comandos conhecidos do
 * jogo. Ela é usada no reconhecimento de comandos como eles são digitados.
 *
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

public class PalavrasComando {
    // um vetor constante que guarda todas as palavras de comandos válidas
    private static final String[] comandosValidos = {"ir", "sair", "ajuda", "observar", "pegar","usar", "abrir", "largar", "chamar", "atacar"};

    /**
     * Verifica se uma dada String é uma palavra de comando válida. 
     * @return true se a string dada é um comando valido, false se não é.
     */
    public boolean ehComando(String umaString) {
        for(int i = 0; i < comandosValidos.length; i++) {
            if(comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string não foi encontrada nos comandos.
        return false;
    }
   
    public String getComandoValido(){
        String comandos = "";
        for(int i = 0; i < comandosValidos.length; i++){
             if(i == comandosValidos.length-1){
                comandos +=comandosValidos[i]+".";
                continue;
            }comandos +=comandosValidos[i]+", ";
           
        }
        return comandos;

    }
}
