package br.ufla.gac106.s2022_1.CacadaMortal;
import java.util.ArrayList;

import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;

/**
 * Essa é a classe principal da aplicacao "Cacada Mortal".
 * "Cacada Mortal" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E pegar itens que iram te ajudar
 * a sobreviver em uma ilha, repleta de perigos! Ele realmente é um jogo
 * de aventura baseado em texto.
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado)
 */

public class Jogo {
    
    // analisador de comandos do jogo
    private Analisador analisador;
    private Cacador umCacador;
    private int nmrComandos;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    private Ambiente ambienteFinal;
    private InterfaceUsuario iu;
    private Score score;
    private Jogador jogador;
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(InterfaceUsuario iu) {
        this.iu = iu;
        criarAmbientes();
        analisador = new Analisador(iu);
        nmrComandos = 0;
        score = Score.getInstancia();
        iniciaJogador();
        
    }
    private void iniciaJogador() {
        String nomeUsuario = iu.obterInformacao("Escolha nome de User: ");
        jogador = new Jogador(nomeUsuario);
    }
    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        umCacador = Cacador.getInstancia();
        Ambiente floresta, pantano, lago, caverna, aviao, cabana, ponte, montanha, deserto,poco;
        Item telefone, faca, arco, chaveBau, chavePorta,bau;
        Personagem p1, p2;
        Monstro m1, m2;

        //cria itens
        telefone = new ItemCarregavel("telefone","O telefone pode ser usado para chamar o resgate.",2, false,"imagens/celular.png");
        faca = new ItemCarregavel("faca","A faca pode ser usada para bater ou cortar um objeto.",2, true, "imagens/faca.png");
        arco = new ItemCarregavel("arco", "pode ser usado para atacar de longe", 2, true, "imagens/arco.png");
        chaveBau = new ItemCarregavel("chaveBau","A chave pode ser usada para abrir o baú encontrado.",2, false, "imagens/chave-bau.png");
        chavePorta = new ItemCarregavel("chavePorta","A chave pode ser usada para abrir uma porta.",2, false, "imagens/chave.png");
        //criando persogens
        p1 = new Personagem("Gaia", "você pode inserir no máximo 40 comandos (desde que o primeira palavra do comando seja valida) para terminar o jogo, por favor jogue com cuidado e atenção", null);
        p2 = new Personagem("Amymarie", "Você deve tomar cuidado para não encontrar um monstro, mas caso encontre vai precisar de algo para se defender", faca);
        //criando monstros
        m1 = new TubaraoGigante(arco);
        m2 = new GuardiaoPonte();

        //criando o bau
        bau = new Baú("bauMadeira", "um Bau de madeira.", chavePorta, "chaveBau", "imagens/bau.png");
        // cria os ambientes
        floresta = new Ambiente("floresta","em uma floresta densa e escura, cheia de plantas e bichos.","imagens/floresta.png");
        pantano = new Ambiente("pantano","em um pantano alagado com animais e plantas perigosas.","imagens/pantano.png");
        lago = new Ambiente("lago","em um Lago com muitos peixes.", "imagens/Lago.png");
        caverna = new Ambiente("caverna","em uma caverna escura com morcegos e um báu.", bau,"imagens/caverna.png");
        aviao = new Ambiente("aviao","dentro do aviao indo de volta para casa.","imagens/aviao.png");
        cabana = new Ambiente("cabana","em uma Casa velha e escura, com um telefone.",telefone,"imagens/cabana.png");
        ponte = new Ambiente("ponte","em uma ponte de madeira, ponte é velha atravesse antes que ela quebre.","imagens/ponte.png");
        montanha = new Ambiente("montanha","em uma montanha, com um monte de rochas.",chaveBau,"imagens/montanha.png");
        deserto = new Ambiente("deserto","em um deserto, cheio de areia e cobras.","imagens/deserto.png");
        poco = new Ambiente("poço","em um poço de agua com peixes e monstros no fundo.","imagens/poco.png");
        //adcionando personagens ao ambiente
        floresta.adcionarPersonagem(p1);
        lago.adcionarPersonagem(p2);
        //adcionando monstros
        floresta.adcionarMonstro(m2);
        poco.adcionarMonstro(m1);
        
        //atribuindo o ambiente final
        ambienteFinal = aviao;
        
        // adiciona os ambientes ao mapa

        
        // inicializa as saidas dos ambientes

        floresta.ajustarSaida("norte", pantano);
        floresta.ajustarSaida("escalar", montanha);
        floresta.monstroBloqueiaSaida("sul", ponte);
        pantano.ajustarSaida("sul",floresta);
        pantano.ajustarSaida("descer", caverna);
        caverna.ajustarSaida("subir",pantano);
        caverna.ajustarSaida("sul", poco);
        poco.ajustarSaida("norte", caverna);
        poco.monstroBloqueiaSaida("leste", floresta);
        poco.ajustarSaida("subir", lago);
        lago.ajustarSaida("mergulhar", poco);
        ponte.ajustarSaida("oeste", lago);
        ponte.ajustarSaidaBloqueada("sul", cabana, "chavePorta");
        ponte.ajustarSaida("norte", floresta);
        cabana.ajustarSaida("oeste", caverna);
        cabana.ajustarSaida("norte", ponte);
        cabana.ajustarSaida("leste", deserto);
        cabana.ajustarSaidaBloqueada("subir", aviao, "telefone");
        montanha.ajustarSaida("descer", floresta);
        montanha.ajustarSaida("sul", deserto);
        deserto.ajustarSaida("escalar", montanha);
        // inicializa o jogador no ambiente inicial
        
        ambienteAtual = floresta;  // o jogo comeca em uma Floresta
        iu.ambienteAtualMudou(ambienteAtual);
    }
    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        
        imprimirBoasVindas();
        score.getComeco();
        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        
        while (! terminado) {
            try{
                Comando comando = analisador.pegarComando();
                terminado = processarComando(comando);
                if(nmrComandos > 55){
                    terminado = true;
                }
                else if(umCacador.getVida() == 0){
                    terminado = true;
                }
            }catch(Exception err){
                iu.continuarMensagem("houve algum erro ao executar um comando");
                terminado = false;
                
            }
        }

        if(umCacador.getVida() == 0){
            iu.exibirMensagem("Você morreu!!!");
        }
        else if(nmrComandos > 55){
            iu.exibirMensagem("Você ultrapassou o número máximo de comandos e perdeu!!!");
        }
        else{
            iu.continuarMensagem("Obrigado por jogar. Ate mais!");
            
        }
        imprimeScore();
    }

    private void imprimeScore() {
        ArrayList<Jogador> x;
        x = score.mostrarScore();
        iu.continuarMensagem("Score dos jogadores:");
        iu.continuarMensagem("Nome\t\tPontos");
        for(int i = 0; i < x.size(); i++){
            iu.continuarMensagem(x.get(i).getNomeUsuario() + " - " + x.get(i).getTempoJogo());
        
        }
    }
    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        imprimirAmbiente();
        iu.continuarMensagem("Bem-vindo ao Caçada Mortal "+jogador.getNomeUsuario()+"!\n");
        iu.continuarMensagem("O seu novo jogo de aventura, incrivelmente maluco!\n");
        iu.continuarMensagem("Digite 'ajuda' se voce precisar de ajuda.\n");
        iu.continuarMensagem("");
    }

    public void imprimirLocalizacaoAtual(){
                
        iu.exibirMensagem(ambienteAtual.getDescricaoLonga());
   
    }
    public void imprimirAmbiente(){
                
        iu.exibirMensagem(ambienteAtual.getDescricao());
   
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            iu.continuarMensagem("Eu não entendi. O que disse?");
            return false;
        }

        nmrComandos++;
        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            querSair = irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("observar")) {
            observar(comando);
        }
        else if (palavraDeComando.equals("pegar")) {
            pegar(comando);
        }
        else if (palavraDeComando.equals("usar")){
            usar(comando);
        }
        else if (palavraDeComando.equals("abrir")){
            abrir(comando);
        }
        else if (palavraDeComando.equals("largar")){
            largar(comando);
        }
        else if (palavraDeComando.equals("chamar")){
            chamar(comando);
        }
        else if (palavraDeComando.equals("atacar")){
            atacar(comando);
        }

        return querSair;
    }

    private void pegar(Comando comando){
        // se não há segunda palavra, não sabemos oque pegar...
        if(!comando.temSegundaPalavra()) {            
            iu.continuarMensagem("Pegar? O que?");
            return;
        }

        String item = comando.getSegundaPalavra();
        boolean temItem = ambienteAtual.consultarExisteItem(item);
        // tenta pegar o item caso ele exista no ambiente
        if(temItem == true){
            if(umCacador.mochilaCheia()){
                iu.continuarMensagem("Item não adicionado. Mochila cheia."); 
            }
            else{ 
                Item itemX = ambienteAtual.removerItem(item);
                if(itemX == null){
                    iu.continuarMensagem("Você não pegou o item.");
                } else{
                    umCacador.addItem(itemX);
                    iu.jogadorPegouItem(itemX);
                    iu.continuarMensagem("Voce pegou o item " + item+"\n");
                }
            }
        }else
            iu.continuarMensagem("Esse item não está aqui.");
    }

    private void observar(Comando comando) {
        imprimirLocalizacaoAtual();
        iu.continuarMensagem("Itens na mochila:"+umCacador.listaItens());
    }
   
    private void usar(Comando comando) {
        // se não há segunda palavra, não sabemos oque usar...
        if(!comando.temSegundaPalavra()) {            
            iu.continuarMensagem("Usar oque?");
            return;
        }

        String item = comando.getSegundaPalavra();
        Item item_x = umCacador.temItem(item);
        
        if (item_x == null) {
            iu.continuarMensagem("Nao há esse item na mochila!");
        }
        else {
            if(ambienteAtual.usarItem(item_x)){
                iu.continuarMensagem("Usuario usou "+item+"\n");
                iu.continuarMensagem("Parabens! Passagem desbloqueada!"+"\n");
            }
            else{
                iu.continuarMensagem("Usuario não usou,"+item+" não desbloqueia a passagem. \n");
            }
        }
    }

    public void abrir(Comando comando){
        if(!comando.temSegundaPalavra()){
            iu.continuarMensagem("Abrir o que?");
            return;
        }
        String nomeBau = comando.getSegundaPalavra();
        String nomeItemDesbloqueia = ambienteAtual.consultarDesbloqueiaBau(nomeBau);
        Item item_x = umCacador.temItem(nomeItemDesbloqueia);
        AcaoBau acao = ambienteAtual.abrirBau(nomeBau, item_x);
        if(acao == AcaoBau.NAO_EXISTE){
            iu.continuarMensagem("Não existe esse bau no ambiente.");
        }else if(acao.equals(AcaoBau.NAO_EH_ITEMDESBLOQUEIA)){
            iu.continuarMensagem("Você não tem o item necessario para abrir o bau.");
        }else if(acao.equals(AcaoBau.JA_ABERTO)){
            iu.continuarMensagem("O bau ja foi aberto.\n");
        }else if(acao.equals(AcaoBau.LIBEROU_ITEM)){
            iu.continuarMensagem("Bau aberto com sucesso!\n");
            iu.continuarMensagem("Foi adicionada um item ao ambiente!\n");
        }else if(acao.equals(AcaoBau.NAO_EH_BAU)){
            iu.continuarMensagem("O item que você quer abrir nao é um bau\n");
        }
    }

    public void largar(Comando comando){
        if(!comando.temSegundaPalavra()){
            iu.continuarMensagem("Largar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();
        Item item_x = umCacador.removerItem(nomeItem);
        if(item_x != null){
            ambienteAtual.adicionaItem(item_x);
            iu.jogadorDescartouItem(item_x);
            iu.continuarMensagem("Você largou o item: " + nomeItem);
        }
        else{
            iu.continuarMensagem("Você não tem esse item");
        }
    }


    public void chamar(Comando comando){
        if(!comando.temSegundaPalavra()){
            iu.continuarMensagem("chamar quem ?");
            return;
        }
        if(comando.getSegundaPalavra().equals("personagem")){
            if (ambienteAtual.existePersonagem()){
                iu.continuarMensagem(ambienteAtual.getInformacaoPersonagem());
                if(ambienteAtual.personagemTemItem()){
                    iu.continuarMensagem("E gostaria de te entregar um item:");
                    Item item = ambienteAtual.entregarItem();
                    if(item == null){
                        iu.continuarMensagem("ops!! não consegui te entregar o item");
                    }
                    else if (umCacador.mochilaCheia()){
                        iu.continuarMensagem("mas infelizmente a sua mochila está cheia então deixarei o item aqui no ambiente");
                        ambienteAtual.adicionaItem(item);
                    }
                    else{
                        umCacador.addItem(item);
                        iu.jogadorPegouItem(item);
                        iu.continuarMensagem("você recebeu um novo item");
                    }
                }
            }
        }else{
            iu.continuarMensagem("você não quis dizer chamar personagem ?");
        }
    }


    public void atacar(Comando comando){
        if(!comando.temSegundaPalavra()){
            iu.continuarMensagem("atacar quem ?");
            return;
        }

        if(ambienteAtual.existeMonstro()){
            String nomeMonstro = ambienteAtual.getNomeMonstro();
            String nome = comando.getSegundaPalavra();
            if(nome.equals(nomeMonstro)){

                String nomeArma = iu.obterInformacao("com qual arma deseja atacar ?");
                if(umCacador.possuiArma(nomeArma)){
                    ambienteAtual.atacarMonstro(nomeArma);
                    iu.continuarMensagem("você atacou o monstro, vida atual dele: " + ambienteAtual.vidaMonstro());
                    if(ambienteAtual.vidaMonstro() > 0){
                        if(ambienteAtual.qtdAtaques() == 2){
                            umCacador.sofreuAtaque();
                            iu.continuarMensagem("o monstro " + ambienteAtual.getNomeMonstro() + " te atacou você perdeu vida, sua vida atual: " + umCacador.getVida());
                        }
                    }
                    else{
                        iu.continuarMensagem("o monstro " + ambienteAtual.getNomeMonstro() + " morreu!!");
                        if(ambienteAtual.monstroDeixaItem()){
                            Item item = ambienteAtual.monstroLargouItem();
                            ambienteAtual.adicionaItem(item);
                            iu.continuarMensagem("o monstro " + ambienteAtual.getNomeMonstro() + " largou um item" );
                            ambienteAtual.removerMonstro();
                        }
                        else{
                            ambienteAtual.removerMonstro();
                        }
                    }

                }else{
                    iu.continuarMensagem("você não possui essa arma ou item com o qual você quer atacar não é uma arma");
                }
            }
            else{
                iu.continuarMensagem("Não existe um monstro com esse nome neste ambiente");
            }
        
        
        }
        else{
            iu.continuarMensagem("Não existe monstro nesse ambiente!!");
        }


    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        iu.continuarMensagem("Você está perdido. Sozinho, você caminha.");
        iu.continuarMensagem("pela ilha.\n");
        iu.continuarMensagem("Suas palavras de comando são:");
        iu.continuarMensagem(analisador.listarComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private boolean irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            iu.continuarMensagem("Ir para onde?");
            return false;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);
        
        if (proximoAmbiente == null) {
            if (ambienteAtual.getSaidaBloqueada() != null && ambienteAtual.getSaidaBloqueada().equals(direcao)){
                iu.continuarMensagem("Nao pode passar! precisa usar " + ambienteAtual.getNomeItemDesbloqueia());
            }
            else if (ambienteAtual.getSaidaBloqueadaMonstro() != null && ambienteAtual.getSaidaBloqueadaMonstro().equals(direcao)){
                iu.continuarMensagem("Nao pode passar! precisa matar o monstro " + ambienteAtual.getNomeMonstro());
            }
            else{
                iu.continuarMensagem("Não há saída nessa direção.");
            }
            return false;
        }
        else if(proximoAmbiente == ambienteFinal){
            ambienteAtual = proximoAmbiente;
            iu.ambienteAtualMudou(ambienteAtual);
            imprimirAmbiente();
            iu.continuarMensagem("Parebéns você terminou o jogo");
            score.getFim();
            score.incluirNoScore(jogador);
            return true;
        }
        else {
            ambienteAtual = proximoAmbiente;
            iu.ambienteAtualMudou(ambienteAtual);
            imprimirAmbiente();
            return false;
        }
    }
    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            iu.continuarMensagem("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }
}
