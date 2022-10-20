[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8252359&assignment_repo_type=AssignmentRepo)
# Rede Social Gráfica

Este projeto é usado para exercitar os conceitos de *GUI* (Interfaces Gráficas de Usuário) e Tratamento de Exceção.

A implementação usa como base uma versão traduzida do exemplo do livro *Programacao Orientada a Objetos com Java - uma introducao pratica utilizando BlueJ*, de **Barnes e Kolling**.

## Sobre o Projeto

Em relação ao projeto de exemplo `RedeSocial`, usado anteriormente nas aulas de Polimorfismo, este projeto acrescenta:

- Um atributo ID (identificador) para cada mensagem.
- A implementação das operações de curtir e comentar na classe `FeedNoticias`.
- Uma interface chamada `Publicacao` que é implementada pela classe Mensagem.
- Uma classe chamada `TelaRedeSocial` que implementa a interface gráfica para a Rede Social.

## Exercícios - Parte 1 - Interfaces Gráficas

Faça os passos abaixo.
Não esqueça de:
- Testar sua implementação a cada passo.
- Fazer `commit` e sincronizar as alterações após cada passo terminado.

### Passo 1.0

Execute o programa e veja como ele funciona (o que faz e o que ainda não faz).

Em seguida avalie o código do programa.
Veja que a interface `Publicacao` foi criada para que a classe `TelaRedeSocial` tivesse acesso às publicações, mas sem poder alterá-las (diminuindo o acoplamento).

### Passo 1.1

Você deve ter notado que o botão `Comentar` não está fazendo nada. 
Faça as implementações necessárias para que ele passe a funcionar (dica: veja o tratamento do botão `Curtir` como exemplo).

### Passo 1.2

Acrescente na tela um botão `Atualizar` que recarregue o Feed de Notícias.

### Passo 1.3

O Feed de Notícias da Rede Social tem tamanho fixo.
Se as mensagens não couberem na tela, elas simplesmente não aparecem.
Vamos melhorar isso colocando o componente que mostra o feed de notícias dentro de um `JScrollPane` (um painel que mostra barras de rolagem quando necessário).

Para fazer isso, basta:
- Criar um `JScrollPane` passando o componente do feed como parâmetro do construtor.
- E então adicionar o `JScrollPane` na janela (ao invés do componente do feed).

### Passo 1.4

Que tal mudarmos a fonte do nosso Feed de Notícias?

A classe `JTextArea` tem um método chamado `setFont` que muda a fonte utilizada.
Ele espera um objeto da classe `Font` que pode ser criado passando-se o nome da fonte, um estilo e o tamanho da fonte (ex: `new Font("Serif", Font.ITALIC, 16)`).
Fique à vontade para escolher a fonte que prefere utilizar.

### Passo 1.5

Nossa Rede Social mostra no Feed de Notícias as mensagens de todos os autores. 
Suponha que queiramos uma forma mais simples de encontrar as mensagens de um determinado autor.
Podemos, por exemplo, criar uma caixa de seleção para selecionar um autor, e exibir no Feed de Notícias apenas as mensagens daquele autor.
Para isso, faça o seguinte:

1. Altere a classe `FeedNoticias` para que ela tenha uma lista com os autores das mensagens.
   Uma das formas de fazer isso é: toda vez que uma nova mensagem for adicionada, se o autor ainda não está na lista, ele é incluído.
   Crie também um método para retornar a lista com todos os autores (cuidado com o encapsulamento!).
   Faça as alterações necessárias e teste o programa.

2. Na classe `FeedNoticias`, crie uma sobrecarga do método `getPublicacoes` que recebe um autor por parâmetro e retorna  apenas as mensagens dele.
   Teste sua implementação.

3. Vamos agora acrescentar à nossa tela uma caixa para o usuário selecionar o autor das mensagens que ele quer ver.
   Uma caixa de seleção é um objeto da classe `JComboBox` que possui uma lista de objetos (e cada objeto se torna uma opção na caixa de seleção).
   Vamos então:

    - Criar a caixa de seleção (obs.: um `JComboBox<T>` depende de um segundo tipo `T`, assim como um `ArrayList`).
    - Colocar a caixa de seleção dentro de um painel que esteja na área superior (`NORTH`) do `BorderLayout`.
    - Criar um método que recarrega a caixa de seleção com os autores. 
      Para isso, use os métodos `removeAllItems` e `addItem` da classe `JComboBox`.
      Você deve sempre adicionar primeiro a string `"Todos"` e, depois, cada um dos autores retornados pelo feed de notícias.
      O método criado deve ser chamado logo após a criação da caixa de seleção, e também toda vez que uma nova mensagem for postada.
    - Alterar o método `atualizarAreaTextoFeed` para que ele carregue o feed de acordo com a escolha do usuário na caixa de seleção (dica: você pode obter a opção escolhida pelo usuário usando os métodos `getItemAt`e `getSelectedIndex` da classe `JComboBox`)
    - Tratar o evento de clique da caixa de seleção da mesma forma que fazemos para os botões e atualizar o feed de notícias de acordo com o autor escolhido. **Importante**: quando os itens da caixa de seleção são alterados, um evento de clique é gerado automaticamente; então, para evitar erros, é necessário garantir que a atualização do feed não será feita enquanto os itens estão sendo recarregados (dica: use um atributo `boolean` para isso).
    - Dica: seria interessante acrescentar também um rótulo (`JLabel`) para informar o autor que a caixa de seleção serve para filtrar as mensagens pelo autor.

Teste suas implementações.

### (Opcional) Passo 1.6

Vamos criar um menu com as opções: `Postar Mensagem`, `Curtir`, `Comentar` e `Sair`.
Crie os menus e trate os eventos conforme necessário.

Dica: use os slides da aula de Interfaces Gráficas para ver exemplos de criação dos menus.

### (Opcional) Passo 1.7

Vamos agora fazer com que um menu *popup* apareça quando clicamos na área de texto do feed de notícias.
Para isso, você precisará tratar os eventos de mouse da área de texto (use o método `addMouseListener`).
No evento de clique do mouse você exibirá um menu *popup* criado conforme descrição abaixo.

Um menu *popup* (classe `JPopupMenu`) funciona como um menu normal, ou seja, ele é formado por objetos do tipo `JMenuItem`.
Nosso menu *popup* deverá ter os ítens de menu: `Atualizar` e `Limpar`. 
O primeiro recarrega o feed (como o botão do Passo 1.2), já o segundo deve limpar o feed de notícias.

Obs: a classe `JPopupMenu` possui um método `show` que espera um componente e a posição `x`, `y` onde o menu deve aparecer (obtenha essas informações do objeto `MouseEvent`, que vem por parâmetro no tratamento do clique do mouse).

## Exercícios - Parte 2 - Tratamentos de Exceção

Faça os passos abaixo.
Assim como na primeira parte, não se esqueça de:
- Testar sua implementação a cada passo.
- Fazer `commit` e sincronizar as alterações após cada passo terminado.

### Passo 2.1

O botão `Curtir` e o botão `Comentar` pedem para o usuário o identificador da mensagem.
Mas se o usuário informar um identificador de uma mensagem que não existe, ocorre um erro na aplicação (você pode ver a mensagem de erro no terminal da IDE).
O que poderia ser feito para evitar este tipo de problema?
O método no Feed de Notícias poderia alterar seu tipo de retorno, por exemplo?
Quais seriam as vantagens e desvantagens dessa abordagem?

*... escreva aqui sua resposta ...*
. Poderia ser feito um tratamento de excessão
. sim
. a vantagem é a possibilidade de retornar ao erro para corrigilo


### Passo 2.2:

Altere o método que trata as curtidas no Feed de Notícias para que ele lance uma exceção caso o identificador da mensagem não exista (use exceção do tipo `RuntimeException`).

Teste sua aplicação sem ainda tratar a exceção.
Veja que a mensagem de erro que aparece é a que você usou ao criar o objeto da exceção.

Agora faça o tratamento da exceção na classe `TelaRedeSocial`.
Por enquanto, apenas exiba a mensagem tratada para o usuário

Dica: você pode usar a classe `JOptionPane` para exibir uma mensagem como no exemplo abaixo:

```java
JOptionPane.showMessageDialog(janela, "Uma mensagem de erro", "Um titulo", JOptionPane.ERROR_MESSAGE);
```

### Passo 2.3:

Como podemos nos recuperar da exceção em nosso caso?
Poderíamos pedir para o usuário que informasse o identificador da mensagem novamente, certo?

Altere então o código de forma que o programa continue pedindo o identificador para o usuário até ele digitar um identificador válido.

### Passo 2.4:

Depois da alteração anterior, o que acontece com seu programa caso o usuário tente curtir uma mensagem antes de existir qualquer publicação?
Caso não tenha tratado esse caso, faça o tratamento adequado agora.

### Passo 2.5:

Do jeito que fizemos até agora, o programa apenas exibe a mesma mensagem de erro da exceção.
Mas pode ser que queiramos exibir uma mensagem mais amigável para o usuário.
A mensagem do lançamento da exceção é escrita para outros programadores e nem sempre faz sentido para um usuário.
Dessa forma, pode ser interessante capturar a exceção e usar os dados disponíveis nela para montar uma mensagem mais apropriada.

Crie então um classe `MensagemNaoEncontradaException` que herda da classe `NoSuchElementException` (escolhemos herdar dela pois ela representa a situação do erro que estamos tratando).
A classe deverá ter como atributo o identificador utilizado.
Veja que o construtor pode receber apenas o identificador e não precisa, necessariamente, montar uma mensagem da exceção. 
Dessa forma, ao lançarmos uma exceção com essa classe, não precisamos nos preocupar a mensagem.

Faça com que seja lançada uma exceção da classe criada.
Altere a classe `TelaRedeSocial` para que capture uma exceção desse tipo e defina sua própria mensagem para o usuário buscando o identificador da mensagem a partir do objeto da exceção.
(Obs.: nesse exemplo específico, não seria necessário obter o id da classe de exceção, pois provavelmente temos como pegar isso de uma variável no método onde ocorre o erro; mas é apenas uma maneira didática de exercitarmos o conceito).

### (Opcional) Passo 2.6:

Altere o tratamento da exceção na classe de `TelaRedeSocial` para que o tratamento funcione apenas caso seja uma exceção do tipo que lançamos.
Acrescente um tratamento genérico (`Exception`) que apenas mostra a mensagem de erro para os demais casos.

Execute o programa para confirmar que do ponto de vista do usuário nada mudou (teste com identificadores válidos e inválidos).

Apenas como forma de testar nossa última alteração, acrescente dentro do método `Curtir` da classe `Mensagem` uma divisão por zero qualquer.
Isso terá um efeito de provocar uma exceção que não é do tipo `MensagemNaoEncontradaException`. 
Dessa forma, o tratamento deverá cair no caso geral de apenas mostrar a mensagem de erro.

