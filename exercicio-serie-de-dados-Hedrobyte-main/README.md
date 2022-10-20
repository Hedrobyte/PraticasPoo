[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8132492&assignment_repo_type=AssignmentRepo)
# Séries de Dados

Este projeto é um código inicial de um exercício usado para praticar os conceitos de Classes Abstratas e Interfaces.

## Passo 1 - Contexto e Definição do Tema

As atividades de hoje têm por objetivo exemplificar a importância do uso dos conceitos de **Classes Abstratas e Interfaces**.

Este projeto tem um pasta (pacote) chamada `series` com duas interfaces e uma classe. 
Uma Série de Dados é um conjunto de dados que tem um dia inicial, um dia final e um valor inteiro correspondente para cada dia.
Séries de dados podem ser, por exemplo:

- Das temperaturas de uma cidade, do dia 1 ao dia 5.
- Das vendas de uma loja, do dia 4 ao dia 10.

As interfaces fornecidas são genéricas e servem para qualquer tipo de série de dados diários.
A ideia é que você trate algum tipo de série de dados usando essas interfaces.

Neste passo você deve definir quais séries de dados vai tratar.
Você precisa definir necessariamente duas séries de dados que estejam de certa forma relacionados.
Abaixo estão alguns exemplos, mas você pode escolher outros.
Ao escolher valide com o professor, pois a ideia é cada aluno tenha temas diferentes.

1. Dados de clima: temperatura e umidade relativa do ar.
2. Dados de acidentes: fatais e não fatais
3. Dados da balança comercial de um país: importações e exportações.
4. Dados de ações de duas empresas: valores da ação da Vale e da Petrobrás.
5. Dados de COVID de uma cidade: número de casos e número de óbitos.

Você deve escrever abaixo quais são as séries de dados que você vai tratar e, em seguida, fazer commit com essa alteração.

... digite sua resposta aqui ...
Dados de COVID da cidade de Lavras: número de casos e número de óbitos.

## Passo 2 - Criação do Pacote

Este projeto utiliza o conceito de **Pacotes**.
Para saber mais sobre o uso de Pacotes em Java, você pode acessar o material disponibilizado na seção de Estudos Autônomos.

Crie um pacote para colocar as classes das suas séries de dados.
As classes dos três passos seguintes devem pertencer a esse pacote.
Escolha um nome para o pacote que tenha relação com o tema que escolheu.

Para criar um pacote no VS Code, basta criar uma pasta dentro da pasta `src`.

Obs: para facilitar o entendimento, os passos seguintes citarão séries de dados de clima, lembre-se de adaptar as instruções para o seu tema escolhido.

## Passo 3 - Criação de classe para série de dados

Crie, dentro do pacote do Passo 2, **uma classe para representar as suas séries de dados**.

No caso dos dados de clima, por exemplo, a classe poderia se chamar `SerieDadosClima`.
A ideia é que ela tenha depois duas subclasses para representar os dois tipos diferentes de dados de clima (temperatura e umidade relativa do ar, por exemplo).

A classe deverá implementar a interface fornecida `SeriesDados`.
Ela deverá sobrescrever todos os métodos da interface, exceto o método `obterIdentificacaoSerie` (que será sobrescrito depois nas subclasses).
A classe deverá ter um atributo `localidade` para identificar a que local os dados se referem.
No caso dos dados de clima, por exemplo, poderia ser uma cidade.

O construtor da classe deverá receber por parâmetro a localidade, o dia inicial e o dia final e deve criar uma estrutura de dados que guardará os dados da série.

Por fim, a classe deverá ter um método para adicionar um dado para um determinado dia.

Obs.: lembre-se que como a classe `SerieDados` está em outro pacote, você precisará importá-la usando: `import series.SerieDados`;

Ao terminar, faça um commit.

## Passo 4 - Subclasses de séries diárias

Crie, dentro do pacote do Passo 2, **duas subclasses** para a classe que você criou no passo anterior.
As subclasses **representarão tipos de dados diferentes das suas séries de dados**.

Por exemplo, no caso de dados de clima, uma classe será para dados de temperatura e outra para dados de umidade.

Cada subclasse deve sobrescrever o método `getIdentificação` para retornar que tipo de dado ela guarda e acrescentar também a localidade.
Exemplo: "Temperaturas em Lavras".

Obs. 1: a classe não precisa ter nenhum atributo.

Obs. 2: essas classes não fazem quase nada, mas estão sendo pedidas por motivos didáticos.

Como de costume, ao terminar, faça um novo commit.

## Passo 5 - Classe de controle

Crie, dentro do pacote do Passo 2, **uma classe de controle que implemente a interface fornecida `ControladorSeries`**.

A classe deve ter uma lista com pelo menos dois objetos, um de cada subclasse que você criou no passo anterior.
Ela deve implementar o método da interface `ControladorSeries`.

Por fim, no construtor, ela deverá criar os dados das suas séries diretamente no código (*hard coded*).

Obs: *num programa normal poderíamos ter um menu para o usuário informar os dados ou poderíamos obter essas informações de um arquivo. Mas vamos fazer “na mão” para não gastar muito tempo.*

Faça o commit de suas alterações.

## Passo 6 - Classe principal

**Altere o código do método `executar` classe `Principal`** que foi fornecida neste projeto.

Você deve instanciar a classe controladora, criada no passo anterior, e obter a lista de séries guardando em uma variável com o tipo `List<SerieDados>`.

Para testar se está tudo certo, implemente um loop que mostre os dados das séries conforme o exemplo abaixo:

```
Dados da Serie Temperaturas em Lavras
Dia 1: 23
Dia 2: 25
...
Dados da Serie Umidade relativa do ar em Lavras
Dia 1: 76
Dia 2: 82
...
```

Teste o seu programa e, estando tudo certo, faça um novo commit.

## Passo 7 - Visualização dos dados

Altere o método `executar` da classe `Principal`, **criando um objeto da classe `VisualizadorSeries`** passando a lista de séries como parâmetro.

Em seguida, **chame o método `exibir`** do objeto criado. 

Teste seu programa e veja o que acontece.

Obs.: a classe `VisualizadorSeries` utiliza bibliotecas que não fazem parte do Java Padrão.
Elas se encontram na pasta `lib` desse projeto.

Advinha o que precisa fazer agora? Isso mesmo, um novo commit.

## Passo 8 - Reflexão sobre a atividade

Você chegou a **refletir sobre o que acabamos de fazer**?
Se não, vamos pensar nisso agora respondendo às perguntas abaixo.

1. Quando a classe de `VisualizadorSeries` foi implementada, quem a criou conhecia algum código que você desenvolveu?

... digite aqui sua resposta ...
Não.

2. Como então a classe `VisualizadorSeries` conseguiu mostrar os dados das suas séries mesmo sem conhecer a sua implementação?

... digite aqui sua resposta ...
recebendo como parametro um dado que foi criado levando em consideração a interface antes estipulada.  

3. O que o polimorfismo tem a ver com o que foi feito?

... digite aqui sua resposta ...
O polimorfismo permitiu que as classes abstratas consiguisem receber comportamentos através de classes concretas. Oque ajuda na 'herança múltipla'

4. Para que então servem as interfaces (como tipo de dado)?

... digite aqui sua resposta ...
um contrato que quando assumido por uma classe deve ser implementado.

Ao terminar, faça um novo commit e sincronize suas alterações com o GitHub Classroom.
