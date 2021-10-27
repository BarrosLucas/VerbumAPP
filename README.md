# Aplicativo VERBUM :books:

## Sobre o Aplicativo :star_struck:
Pensando na dificuldade para encontrar fontes de qualidade e confiança dentro do ambiente acadêmico, um grupo de alunos entusiastas pensou na implementação de um sistema que possa reunir alunos que incluem fontes confiáveis para as diversas áreas de conhecimentos abordadas em sala de aula. Para tal, esse sistema será projetado dentro da disciplina de Métodos de Projetos de Software, sob tutoria do professor Raoni Kulesza.

## Como este repositório esta organizado :pushpin:
Este repositório conta um documento de requisitos do aplicativo que pode ser consultado no diretório principal e duas pastas contendo diferentes entregas da disciplina de Métodos de Projeto de Software (MPS).

:open_file_folder: Batalha de Grupos(entrega 3), que contém um controle de versão em que os participantes do projeto desenpenharam as seguintes funções:

####Integrantes e seus respectivos papéis
- __Lucas Barros__: Mantenedor do repositório GIT
- __Rebeca Raab__: Colaborador A1
- __Júlio Leite__: Colaborador A2
- __Everaldo Mendes__: Colaborador B1

####Fazendo as seguintes tarefas:
1. O mantenedor1 cria um repositório no Github e colocar no readme os papéis do grupo.
2. O mantenedor1 adiciona 2 commits e pushes.
3. Contribuidores A e Contribuidores B fork e clonam (e adicionam upstream).
4. Contribuidores A e Contribuidores B criam uma feature branch chamada de "will_need_split_a_x" ou "will_need_split_b_x" .
5. Contribuidores A e Contribuidores B adicionam 2 commits de 2 arquivos em "will_need_split_a_x" ou "will_need_split_b_x"
6. O Contribuidores A e o Contribuidores B criam uma solicitação pull para upstream de seu branch will_need_split (incluindo todos os 2 commits).
7. O mantenedor 2 rejeita a solicitação de pull, fechando-a e comentando "por favor, divida isso em 2 pull request" (e direciona quais arquivos vão no 1 e quais vão no 2 em cada branch will_need_split).
8. O Contribuidores A e o Contribuidores B seguem o procedimento acima para terminar com duas novas branchs split_branch_a_x e split_branch_b_x enviadas por meio de solicitações pull separadas com apenas os commits / arquivos corretos neles.
9. O mantenedor 2 aceita cada uma das 8 solicitações pull divididas.

:open_file_folder: Laboratório 1, que se trata de realizar as seguintes tarefas:

1. Crie um projeto de um programa em O.O e divida-o em três pacotes:
a) camada que lida com a interface com o usuário (view);
b) camada de negócio (business) com dois pacotes;
b.1) subcamada que possui regras (gerente de usuário) de negócio (control)
b.2) subcamada que possui entidades do negócio (model)
c) camada que lida com a persistência/comunicação externa/etc (infra).

2. Implemente a ADIÇÃO DE USUÁRIOS. Implemente as validações de campos seguindo as regras abaixo:
- Login: máximo 12 caracteres; não pode ser vazio; não pode ter números;
- Senha: máximo 20 caracteres; mínimo de 8 caracteres; deve possuir letras e números e ao menos 2 números.

3. Armazene os usuários numa coleção (deve ser atributo da classe que gerencia os usuários na camada “control”) e implemente a persistencia da lista utilizando arquivos binários na camada “infra”.

4. Implementar "LISTAR TODO OS USUÁRIOS" exibindo login e senha;

5. Implemente a EXCLUSÃO DE UM USUÁRIO dado seu login.

:iphone: O apk para testes também se encontra na pasta. :iphone:

###Para rodar os códigos é necessário: :gear:
1. Baixar/clonar o projeto;
2. Abrir o terminal;
3. Executar o comando: ./gradlew assembleRelease


