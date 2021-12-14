# Padrões utilizados

#### Aqui será realizada a descrição para cada padrão, contendo informações como: nome do padrão, a lista de classes e objetivo de uso do padrão no projeto.

### Strategy ou Policy: é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, coloque-os em classes separadas, e faça os objetos deles intercambiáveis.
- Objetivo de uso: A lógica condicional é uma das estruturas mais complexas e utilizadas no desenvolvimento de softwares corporativos. 
Lógicas condicionais tendem a crescer e tornar-se cada vez mais sofisticadas, maiores e mais difíceis de manter com o passar do tempo.  
O padrão Strategy ajuda a gerenciar toda essa complexidade imposta pelas lógicas condicionais. O Padrão Strategy sugere que se produza uma família de classes para cada variação do algoritmo e que se forneça para a classe hospedeira uma instância de Strategy para a qual ela delegará em tempo de execução. Um dos pré-requisitos para o Strategy é uma estrutura de herança onde cada subclasse específica contém uma variação do algoritmo. Assim, o padrão Strategy possui diversos benefícios como clarificar algoritmos ao diminuir ou remover lógica condicional, simplificar uma classe ao mover variações de um algoritmo para uma hierarquia, e habilitar um algoritmo para ser substituído por outro em tempo de execução.

- Aplicabilidade: Em resumo o padrão Strategy pode ser utilizado quando se tem as seguintes situações:

  1. Quando muitas classes relacionadas diferem apenas no seu comportamento;
  2. Quando necessita-se de variantes de um algoritmo;
  3. Quando se precisa ocultar do usuário a exposição das estruturas de dados complexas, específicas do algoritmo;
  4. Quando uma classe define muitos comportamentos e por sua vez eles aparecem como diversos “IFs”. Com isso esses comandos condicionais são movidos para sua própria classe Strategy.

- Lista de classes: OrderByStrategy.java, OrderByBirthDate.java, OrderByName.java, usados para facilitar as ordenações no Verbum app.

### Adapter: é um padrão de projeto estrutural que permite objetos com interfaces incompatíveis colaborarem entre si.
- Objetivo de uso: O Padrão Adapter é utilizado quando temos uma classe existente cuja interface não é adequada para as suas necessidades. Além disso, o adaptador consegue mudar a interface de um fornecedor para uma interface que o cliente espera encontrar. O Adapter é um padrão que utiliza boas praticas de orientação a objetos e a sua implementação fica mais complexa de acordo com a complexidade da interface do fornecedor.

- Aplicabilidade: O Padrão Adapter possui diversas boas práticas de programação orientada a objetos como o uso da composição de objetos, vinculação do cliente a uma interface e não a uma implementação e flexibilidade com o uso de diversos adaptadores.

- Lista de classes: UserItemAdapter.java, usada para realizar uma adptação dos usuários afim de facilitar a ordenação pelo feita pelo padrão Stategy.

### Memento: O Memento é um padrão de projeto comportamental que permite que você salve e restaure o estado anterior de um objeto sem revelar os detalhes de sua implementação..
- Objetivo de uso: Memento é um padrão usado para a criação de um 'histórico' da sua apricação. Ele é usado para salvar o estado de suas entidades. A forma como ele é usado para facilitar o processo, já que nem todas as aplicações que se utilizam de ferramentas de 'históricos' tem o padrão memento. O memento é idealizado com a ideia de as próprias entidades criarem 'prints' de sim mesmo, ao invés de ser nescessária a ação de um terceiro.

- Lista de classes:

### Command: O command é um padrao de projeto comportamental que permite encapsular e registrar ações.
- Objetivo de uso: O objetivo do Command consiste em encapsular ações, evitando, desta forma, que todas essas ações estejam emaranhadas e dependentes entre si, ocasionando códigos robustos e bastante suscetível a erros (por ser demasiadamente amarrado).

- Aplicabilidade: O encapsulamento das ações permite, desta forma, parametrizar e até enfileirar as ações, de forma que elas possam ser solicitadas e efetuadas de forma independente, reduzindo a robustes e a dependência entre eles.

- Lista de classes: Command (Interface), Switch, DoLoginCommand e DoRegisterCommand.

### Chair of Responsability: Mais um padrão comportamental, trata de encaminhar uma ação entre vários handlers até que um seja encontrado e encarregador de executar tal ação.
- Objetivo de uso: Uma sequência de ações adiciona muita ação e pode apresentar falta de segurança e consistência. Adicionalmente observa-se que é muito complicada a adição de novas funcionalidades em um fluxo de ação ou em uma sequência de ações, gerando uma verdadeira bagunça. Para tal, handle trata de encaminhar as ações, separando o fluxo entre handlers e os próprios se responsabilizando por repassar cada evento até encontrar o handle responsável por ela.

- Aplicabilidade: Através deste padrão observa-se que é possível criar uma sequência de ações de forma limpa e segura, além de ser fácil e aplicável criar uma nova ação, onde para tal seria necessária apenas a criação de um novo handle.

- Lista de classes: Handle, HtmlHandle e BaseHandle.

### Template Method: é um padrão de projeto comportamental que define o esqueleto de um algoritmo na superclasse mas deixa as subclasses sobrescreverem etapas específicas do algoritmo sem modificar sua estrutura.
- Objetivo de uso: O padrão do Template Method sugere que você quebre um algoritmo em uma série de etapas, transforme essas etapas em métodos, e coloque uma série de chamadas para esses métodos dentro de um único método padrão. As etapas podem ser tanto abstratas, ou ter alguma implementação padrão. Para usar o algoritmo, o cliente deve fornecer sua própria subclasse, implementar todas as etapas abstratas, e sobrescrever algumas das opcionais se necessário.

- Aplicabilidade: permite que você transforme um algoritmo monolítico em uma série de etapas individuais que podem facilmente ser estendidas por subclasses enquanto ainda mantém intacta a estrutura definida em uma superclasse.

- Lista de classes: GenerateReports, GenerateHTMLReport, GeneratePDFReport

### Factory Method: O padrão Factory Method encapsula a criação de objetos, deixando as subclasses decidirem quais objetos criar.
- Objetivo de uso: É muito comum termos classes que instanciam classes concretas e essa parte do código normalmente sofre diversas modificações, portanto nesses casos usamos um Factory Method que encapsula esse comportamento de instanciação.

- Aplicabilidade: Com o padrão Factory Method podemos encapsular o código que cria objetos. evitando assim a duplicação e além disso temos um local único para fazer manutenção. O padrão também nos dá um código flexível e extensível para o futuro.

- Lista de classes: Sex(interface), Man, Woman, SexFactory.

## Referências
1. https://refactoring.guru/pt-br/design-patterns/strategy
2. https://www.devmedia.com.br/estudo-e-aplicacao-do-padrao-de-projeto-strategy/25856
3. https://refactoring.guru/pt-br/design-patterns/adapter
4. https://www.devmedia.com.br/padrao-de-projeto-adapter-em-java/26467
5. https://www.devmedia.com.br/padrao-de-projeto-template-method-em-java/26656
6. https://refactoring.guru/pt-br/design-patterns/template-method
7. https://www.devmedia.com.br/padrao-de-projeto-factory-method-em-java/26348