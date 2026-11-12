# Cadastro de Móveis

Projeto feito para a disciplina de APS II. É um programa simples em Java (Maven) que roda no terminal e permite cadastrar, listar, buscar e remover móveis.

## Sobre o projeto

O sistema trabalha com três tipos de móveis: **Cadeira**, **Mesa** e **Sofá**. Todos herdam da classe abstrata `Movel`, que tem os atributos em comum (id, nome, material e preço). Cada tipo tem um atributo próprio (cadeira tem rodinhas ou não, mesa tem quantidade de lugares e sofá é retrátil ou não).

Os dados ficam salvos em memória, então quando o programa fecha eles são perdidos.

### Estrutura

```
src/main/java/br/unipe/cadastromoveis
├── Main.java                         -> menu no terminal
├── model
│   ├── Movel.java                    -> classe abstrata
│   ├── Cadeira.java
│   ├── Mesa.java
│   └── Sofa.java
├── repository
│   ├── MovelRepository.java          -> interface
│   └── MovelRepositoryMemoria.java   -> implementação (Singleton)
└── service
    └── MovelService.java             -> regras de negócio
```

### Como executar

Precisa ter o Java 17+ e o Maven instalados. Dentro da pasta `CadastroMoveis`:

```
mvn compile exec:java
```

Ou abrir o projeto no NetBeans/IntelliJ e rodar a classe `Main`.

## Princípios SOLID aplicados

- **S (Responsabilidade Única):** cada classe tem uma função só. O `Main` cuida do menu, o `MovelService` das validações e o repositório de guardar os dados.
- **O (Aberto/Fechado):** para criar um novo tipo de móvel basta criar uma classe que estende `Movel`, sem precisar mexer nas outras.
- **L (Substituição de Liskov):** `Cadeira`, `Mesa` e `Sofa` podem ser usadas em qualquer lugar onde se espera um `Movel`.
- **I (Segregação de Interface):** a interface `MovelRepository` é pequena e só tem os métodos que realmente são usados.
- **D (Inversão de Dependência):** o `MovelService` depende da interface `MovelRepository` e não da classe concreta. A implementação é passada pelo construtor.

## Padrão de projeto escolhido: Singleton

O Singleton garante que uma classe tenha **apenas uma instância** durante toda a execução e fornece um ponto de acesso global a ela.

No projeto ele foi aplicado na classe `MovelRepositoryMemoria`:

- o construtor é `private`, então ninguém consegue dar `new` nela de fora;
- existe um atributo `static` que guarda a única instância;
- o método `getInstancia()` cria o objeto na primeira chamada e depois sempre devolve o mesmo.

### Por que ele é adequado?

Como os móveis ficam guardados em uma lista na memória, é importante que exista **uma única lista** para o sistema todo. Se fosse possível criar vários repositórios, cada um teria sua própria lista e os dados ficariam espalhados (um móvel cadastrado em um repositório não apareceria no outro). Com o Singleton, qualquer parte do programa que pedir o repositório vai acessar sempre os mesmos dados. O contador de IDs também fica centralizado, evitando IDs repetidos.

Esse é um uso comum do Singleton: controlar o acesso a um recurso compartilhado, como uma "base de dados", uma conexão com banco ou uma configuração.

### Outros padrões que poderiam ser usados

- **Factory Method:** poderia ser usado para criar os móveis (`Cadeira`, `Mesa`, `Sofa`) a partir do tipo escolhido no menu, tirando essa responsabilidade do `Main`.
- **Repository / DAO:** o projeto já usa a ideia de repositório para separar o acesso aos dados das regras de negócio. Se depois fosse usado um banco de dados de verdade, bastaria criar outra implementação da interface.
- **Strategy:** poderia ser usado se o sistema precisasse, por exemplo, de formas diferentes de calcular desconto no preço dos móveis.

Mesmo assim, para o problema principal deste projeto (ter um único local de armazenamento compartilhado), o Singleton é o mais direto e simples.
