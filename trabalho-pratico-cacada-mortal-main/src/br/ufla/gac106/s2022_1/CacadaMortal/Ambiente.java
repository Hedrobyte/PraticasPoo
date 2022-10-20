package br.ufla.gac106.s2022_1.CacadaMortal;
import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Cacada Mortal".
 * "Cacada Mortal" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado)
 */
public class Ambiente extends EntidadeGrafica {
    // descrição do ambiente
    private String nome;
    private String descricao;
    // ambientes visinhos de acordo com a direção
    private HashMap<String, Ambiente>saidas;
    // itens que estao no ambiente
    private ArrayList<Item> itens;
    private Personagem personagem;
    private Monstro monstro;
    // Saida bloqueada
    private String saidaBloqueada;
    private String saidaBloqueadaMonstro;
    // nome do item que desbloqueia a saida
    private String NomeItemDesbloqueia;


    /**
     * @param descricao
     * @param umItem
     */
    public Ambiente(String nome, String descricao, String caminhoImagem) {
        super(caminhoImagem);
        this.nome = nome;
        this.descricao = descricao;
        saidas = new HashMap<String,Ambiente>();
        itens = new ArrayList<Item>();
    }
    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String nome, String descricao,Item umItem, String caminhoImagem)  {
        this(nome,descricao, caminhoImagem);
        adicionaItem(umItem);
    }

    public void adicionaItem(Item umItem) {
        if(umItem != null) {
            itens.add(umItem);
        }
    }

    public boolean getExisteItem(){
        if(itens.size() > 0){
            return true;
        }
        return false;
    }

    public boolean getExisteBau(){
        if(itens.size() > 0){
            for(Item i: itens){
                if(i.ehUmBau()){
                    return true;
                }
            }
        }
        return false;
    }

    public String getDescricaoItens() {
        if(getExisteItem()){
            String descricao =" ";
            for(Item item : itens){
                descricao += item.getNome() + " -" + item.getDescricao()+"\n\t";
            }
            return descricao;
        }
        return "Ops! Não há nada aqui.";
    }


    public boolean consultarExisteItem(String nomeItem){
        if(getExisteItem()){
             for(Item item : itens){
                 if(item.getNome().equals(nomeItem)){
                     return true;
                 }
             }
        }
        return false;
    }

    // retorna o item que desbloqueia o bau
    //Revisar.
    public String consultarDesbloqueiaBau(String nomeItem){
        if(getExisteBau()){
             for(Item item : itens){
                 if(item.ehUmBau()){
                     if(item.getNome().equals(nomeItem)){
                         return item.getNomeItemDesbloqueia();
                     }
                 }
             }
        }
        return null;
    }
    
    public Item pegarItem(String nomeItem){
        if(getExisteItem()){
             for(Item item : itens){
                 if(item.getNome().equals(nomeItem)){
                     return item;
                 }
             }
        }
        return null;
    }


    public boolean usarItem(Item item){
        if(item.getNome().equals(NomeItemDesbloqueia)){
            saidaBloqueada = null;
            return true;
        }
        return false;
    }
    /**
     * Adiciona uma saida para o ambiente.
     * @param direcao A direção para onde a saida é para o ambiente.
     * @param ambiente O ambiente para o qual a saida é para.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return "Você está " + descricao;
    }

    public String getSaidaBloqueada(){
        return saidaBloqueada;
    }

    public String getSaidaBloqueadaMonstro(){
        return saidaBloqueadaMonstro;
    }
    
    public String getDescricaoLonga() {
        String descricao = "";
        descricao += getDescricao() + "\n";
        if(existePersonagem()){
            descricao += "Parece ter um personagem aqui" + "\n";
        }
        if(existeMonstro()){
            descricao += "Parece ter um monstro chamado " + getNomeMonstro() + " neste ambiente" + "\n";
        }

        descricao += "Saidas: "+ getSaidas()+
        "\n"+"Item: "+ getDescricaoItens();
        
        return descricao;
        
        /*+"\n"+"Saidas: "+ getSaidas()+
        "\n"+"Item: "+ getDescricaoItens();*/
    }
    
    public Ambiente getSaida(String direcao) {
        if(direcao.equals(saidaBloqueada)){
            return null;
        }
        if(direcao.equals(saidaBloqueadaMonstro)){
            return null;
        }
        return saidas.get(direcao);
    }
    
    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + "-" + direcao + "\n" + "           ";
        }
        return textoSaidas;
    }
    /**
     * @return A lista de saidas do ambiente.
     */
    public void ajustarSaidaBloqueada(String direcao, Ambiente ambiente  , String nomeItemDesbloqueia) {
        ajustarSaida(direcao, ambiente);
        saidaBloqueada = direcao;
        NomeItemDesbloqueia = nomeItemDesbloqueia;
    }

    public void monstroBloqueiaSaida(String direcao, Ambiente ambiente) {
        ajustarSaida(direcao, ambiente);
        saidaBloqueadaMonstro = direcao;
      
    }

    public String getNomeItemDesbloqueia(){
        return NomeItemDesbloqueia;
    }
    //abre o bau]
    //Enum 
    public AcaoBau abrirBau(String item, Item desbloqueia){
        if(consultarExisteItem(item)){
            for(Item i : itens){
                if(i.ehUmBau()){
                    if(i.getNome().equals(item)){
                        if(desbloqueia != null){ 
                            if(desbloqueia.getNome().equals(consultarDesbloqueiaBau(item))){
                                Item dentroDoBau = i.abrir();
                                if(dentroDoBau != null){
                                    itens.add(dentroDoBau);
                                    return AcaoBau.LIBEROU_ITEM;
                                }else{
                                    return AcaoBau.JA_ABERTO;
                                }
                            }
                        }return AcaoBau.NAO_EH_ITEMDESBLOQUEIA;
                    }
                }
            }return AcaoBau.NAO_EH_BAU;
        }return AcaoBau.NAO_EXISTE;
    }
    //revisar
    public Item removerItem(String Item){
        for (Item i : itens) {
            if(i.ehCarregavel()){
                if(i.getNome().equals(Item)){
                    itens.remove(i);
                    return i;
                }
            }
        }return null;
    }
    @Override
    public String getNome() {
        return nome;
    }


    public void adcionarPersonagem(Personagem personagem){
        this.personagem = personagem;
    }

    public boolean existePersonagem(){
        if(personagem != null){
            return true;
        }
        return false;
    }

    public boolean personagemTemItem(){
        if(personagem.getItem()){
            return true;
        }
        return false;
    }

    public String getInformacaoPersonagem(){
        String descricao = "olá meu nome é " + personagem.getNome() + "\n";
        descricao += "gostaria de te passar uma mensagem: " + personagem.getInformacao();
        return descricao;
    }

    public Item entregarItem(){
        if(personagem.getItem()){
            Item item = personagem.entregarItem();
            return item;
        }
        return null;
    }



    public void adcionarMonstro(Monstro monstro){
        this.monstro = monstro;
    }

    public void removerMonstro(){
        saidaBloqueadaMonstro = null;
        monstro = null;
    }

    public boolean existeMonstro(){
        if(monstro != null){
            return true;
        }
        return false;
    }

    public String getNomeMonstro(){
        return monstro.getNome();
    }

    public void atacarMonstro(String arma){
        monstro.nmrAtaques();
        monstro.sofreuAtaque(arma);
    }
    public int vidaMonstro(){
        return monstro.getQtdVida();
    }

    public int qtdAtaques(){
        return monstro.getNmrAtaques();
    }

    public boolean monstroDeixaItem(){
        return monstro.dropaItem();
    }

    public Item monstroLargouItem(){
        return monstro.morreu();
    }

}
