[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8248570&assignment_repo_type=AssignmentRepo)
# Corrida Multitarefa

Este projeto é um exercício para a aula de Multitarefas de disciplinas de Programação Orientada a Objetos.

O projeto possui uma interface chamada `Competidor` que define um contrato para um competidor de corridas.
Ele traz também uma classe chamada `Tela` que implementa uma interface gráfica para configurar, inicializar e acompanhar uma corrida.

Mas esta versão inicial ainda não trata uma corrida propriamente dita, pois não há nenhuma implementação de competidores.
Sua missão é implementar uma classe de competidores e usar threads para simular a corrida.

## Passo 1 - Classe Corredor

Crie uma classe chamada `Corredor` que implemente a interface `Competidor`.
Cada corredor deve ter um nome, uma velocidade (em metros por segundo), uma distância a ser percorrida (distância da corrida), a distância já percorrida e um booleano indicando se o corredor está correndo ou não.
O construtor da classe deve receber o nome e a velocidade do corredor, pois a ideia é que tenhamos diferentes corredores com diferentes velocidades.

Além dos métodos de acesso (_gets_), a classe deve sobrescrever também o método `prepararParaNovaCorrida` de modo que o corredor possa participar de diversas corridas.

Repare que a interface `Competidor` estende a interface `Runnable` e, portanto, a sua classe deverá implementar tanto os métodos da interface `Competidor` quanto o método `run` da interface `Runnable`.
Por causa deste último método, sua classe poderá ser usada como uma tarefa de uma thread.

O método `run` deve simular uma única corrida feita pelo corredor.
Ou seja, enquando a distância já percorrida for menor que a distância da corrida:
1. faz o corredor correr mais um metro,
2. e suspende a thread pelo tempo necessário que simule a velocidade do corredor.
  - Por exemplo: se a velocidade do corredor for de 4 metros por segundo, significa que ele corre um metro a cada 1/4 segundo (ou 250 milissegundos).
  Logo, este é o tempo que a thread deveria ser suspensa neste caso.

## Passo 2 - Criar os competidores

Tendo a classe `Corredor`, podemos agora criar os competidores da nossa corrida.

Para isso, altere o método `criarCompetidores` da classe `Tela`, acrescentando objetos da classe `Corredor` à lista de competidores.

Crie pelo menos três competidores (mas quanto mais melhor).
E lembre-se de criar competidores com nomes e velocidades diferentes.

## Passo 3 - Criar a thread de cada competidor

Para simular a corrida, nós vamos criar uma thread para cada competidor.
Como o método `run` da classe `Corredor` simula a velocidade de corrida de um corredor, se iniciarmos as threads ao mesmo tempo, conseguiremos simular a corrida de forma adequada.

Para fazer isso, altere o método `iniciarCorrida` da classe `Tela` para que cada corredor seja colocado em uma thread separada. Basicamente, você precisa percorrer a lista de competidores e, para cada um:
- prepará-lo para uma nova corrida, 
- e acrescentar uma thread para o competidor na lista de threads já existente.

Depois fazer um loop iniciando todas as threads criadas.

Execute o programa e teste sua implementação.
Note que após iniciar a corrida, você precisa ficar clicando no botão `Atualizar` para conseguir ver o status da corrida.

## Passo 4 - Visualização automática da corrida

Usar o botão `Atualizar` não é nada prático, certo?
Vamos então criar uma thread para que a atualização seja feita de forma automática.
Para isso altere o método `iniciarCorrida` da classe `Tela`:

1. Após o início das threads dos corredores, crie uma nova thread usando uma classe anônima (de forma similar ao que fazemos para tratar eventos de clique de botão).
2. No método `run` da classe anônima, enquanto ainda houver corredores correndo, a corrida deve ser atualizada e a thread suspensa por 100 milissegundos.
  - Obs.: crie um método na classe `Tela` que retorne se ainda existe algum corredor correndo.
3. Não se esqueça de iniciar a thread criada.

Execute o programa e teste sua implementação.
