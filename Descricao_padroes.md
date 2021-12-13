# Neste arquivo será realizada a descrição para cada padrão, contendo informações como: nome do padrão, a lista de classes e objetivo de uso do padrão no projeto.

### Strategy ou Policy: é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, coloque-os em classes separadas, e faça os objetos deles intercambiáveis.
- Objetivo de uso: A lógica condicional é uma das estruturas mais complexas e utilizadas no desenvolvimento de softwares corporativos. 
Lógicas condicionais tendem a crescer e tornar-se cada vez mais sofisticadas, maiores e mais difíceis de manter com o passar do tempo. 
O padrão Strategy ajuda a gerenciar toda essa complexidade imposta pelas lógicas condicionais. O Padrão Strategy sugere que se produza uma família de classes para cada variação 
do algoritmo e que se forneça para a classe hospedeira uma instância de Strategy para a qual ela delegará em tempo de execução. Um dos pré-requisitos para o Strategy é uma 
estrutura de herança onde cada subclasse específica contém uma variação do algoritmo. Assim, o padrão Strategy possui diversos benefícios como clarificar 
algoritmos ao diminuir ou remover lógica condicional, simplificar uma classe ao mover variações de um algoritmo para uma hierarquia, e habilitar um algoritmo 
para ser substituído por outro em tempo de execução.

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

### NOME DO PADRÃO: descrição.
- Objetivo de uso:
- Aplicabilidade:
- Lista de classes:

### NOME DO PADRÃO: descrição.
- Objetivo de uso:
- Aplicabilidade:
- Lista de classes:

### NOME DO PADRÃO: descrição.
- Objetivo de uso:
- Aplicabilidade:
- Lista de classes:

### NOME DO PADRÃO: descrição.
- Objetivo de uso:
- Aplicabilidade:
- Lista de classes:

## Referências
1. https://refactoring.guru/pt-br/design-patterns/strategy
2. https://www.devmedia.com.br/estudo-e-aplicacao-do-padrao-de-projeto-strategy/25856
3. https://refactoring.guru/pt-br/design-patterns/adapter
4. https://www.devmedia.com.br/padrao-de-projeto-adapter-em-java/26467
