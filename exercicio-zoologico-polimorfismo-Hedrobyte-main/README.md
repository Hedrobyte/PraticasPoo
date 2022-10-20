[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8134382&assignment_repo_type=AssignmentRepo)
# Exercício Zoológico - Polimorfismo

Este exercício é uma continuação do exercício anterior do Zoológico, no qual havíamos trabalhado o conceito de herança.

Nosso objetivo será entender melhor os conceitos relacionados ao polimorfismo e melhorar a modelagem de nossas classes, adotando tais conceitos.

## Passo 1 - Continuando a partir do exercício anterior

Baixe o repositório do exercício anterior do Zoológico, e copie os arquivos da pasta `src` para a pasta `src` deste projeto.

Execute o programa e teste para confirmar que não ficou faltando nenhum arquivo.

Faça um commit com essas alterações, usando a mensagem: "Código do exercício anterior".

## Passo 2 - Experimentando Polimorfismo 1

Vamos começar exercitando nosso entendimento sobre os conceitos de polimorfismo.
Para isso, crie uma classe `Teste` com um método `main` e, dentro dele, faça o seguinte:

- Declare uma variável chamada `animal` do tipo `Animal` e atribua a ela um objeto da classe `Lobo`.
- Chame o método `getNome` usando a variável `animal`.
- Agora, usando a mesma variável `animal`, atribua a ela um objeto da classe `Galinha`.
- Chame o método `getNome` usando a variável criada.

Explique abaixo como é possível que a mesma variável `animal` possa ser usada para chamar métodos de objetos de classes diferentes.

  ... escreva aqui a sua resposta ...
- RESPORTA:
  1 - A variável de um tipo, pode referenciar objetos de um subtipo.
  2 - O tipo estático de uma variável, é o tipo usado explicitamente no código ao declarar a variável.
  3 - O tipo dinâmico de uma variável, é o tipo do objeto que é atualmente referenciado na variável(pode mudar).
    - Nesse caso o tipo estático da variável 'animal' é 'Animal' e  
      as outras duas variáveis são do tipo dinâmico.
    - Portanto a variável 'animal' é uma variável polimórfica(pode referenciar objetos de tipos diferentes). 
 
Ao terminar, faça um commit com as alterações da classe `Teste` e as alterações neste arquivo README).

## Passo 3 - Experimentando Polimorfismo 2

Agora, altere o método `main` da classe `Teste` e faça o seguinte:
- Usando a mesma variável `animal` declarada no passo anterior, atribua a ela um objeto da classe `Lobo`.
- Chame o método `getDescricaoLonga` usando a variável `animal`.

O que é exibido?

  ... escreva aqui a sua resposta ...
- RESPOSTA:
  "lobo 1 é um(a) Lobo, que emite o som Auuu, e possui 4 patas  e tem pelo cinza"

O método chamado pertence a qual classe?

  ... escreva aqui a sua resposta ...
- RESPOSTA:
  "Mamifero"

Agora usando a mesma variável `animal`, atribua a ela um objeto da classe `Galinha`.
- Chame o método `getDescricaoLonga` usando a variável criada.

O que é exibido?

  ... escreva aqui a sua resposta ...
- RESPOSTA:
  "galinha 1 é um(a) galinha, que emite o som cocórioco, e possui 2 patas e não voa bem!"

O método chamado pertence a qual classe?

  ... escreva aqui a sua resposta ...
- RESPOSTA:
  "Ave"

Explique como a mesma linha de código `animal.getDescricaoLonga()` pode ser usada para chamar métodos de classes diferentes.

  ... escreva aqui a sua resposta ...
- RESPOSTA:
  - Durante a compilação, o compilador verificará se a classe Animal possui o método getDescricaoLonga, pois ele verifica o tipo ESTÁTICO da variável declarada.
  - Durante a execução, a máquina virtual vai procurar o método getDescricaoLonga na classe do objeto que realmente está na coleção, pois ela verifica o tipo DINÂMICO da variável declarada.

Ao terminar, faça um novo commit com as alterações (na classe Teste e neste arquivo README).

## Passo 4 - Usando Polimorfismo no Projeto Zoologico

Vamos agora perceber como o polimorfismo ajuda a reduzir a replicação de código. 

Para isso, você deve alterar a classe `Zoologico`:

- Substitua as listas de animais de cada espécie por uma única lista de animais.
- E, devido a essa modificação, implemente as alterações necessárias nos métodos da classe.

Do ponto de vista do usuário, seu programa deverá continuar funcionando da mesma forma que você havia feito no exercício da aula anterior, mas agora com um código melhor.

Teste suas alterações!

Ao final, faça um novo commit no seu repositório.

## Passo 5 - Identificando o uso de Polimorfismo

Para todas as perguntas abaixo, você deve indicar em qual classe e qual é o número da linha onde cada situação acontece.

1. Indique pelo menos uma variável polimórfica utilizada no seu código e explique porque ela é uma variável polimórfica.

Classe: Teste

Linha: 6

Variável: animal

Explicação: animal é uma variável polimórfica porque ela assume tipos dinâmicos diferentes em diferentes momentos. Ex: linha 8, linha 11.


2. Identifique algum ponto no código onde está sendo usado o princípio da substituição e explique o que é este princípio.

Classe: Teste

Linha: linha 9

Explicação: o princípio da substituição é a possibilidade de usar um objeto de uma subclasse onde um objeto da superclasse é esperado.
(Se Lobo é um subtipo de Animal, então os objetos do tipo Animal, em um programa, podem ser substituídos pelos objetos de tipo Lobo sem que seja necessário alterar as propriedades deste programa).



3. Identifique algum ponto no código onde uma variável tem tipo estático e tipo dinâmico diferentes (indique quais são os tipos estático e dinâmico da variável neste ponto).

Classe: Teste

Linha: linha 8

Variável: animal

Tipo estático: Animal

Tipo dinâmico: Lobo


4. Identifique onde ocorre uma chamada de método que utiliza o polimorfismo de método.

Classe: Zoologico

Linha: 76 "return animal.getDescricaoLonga();"

