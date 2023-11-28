## Exercícios 05 – Parte 1

### Pesquise a respeito do Interface Segregation Principle (ISP)e responda as questões abaixo:

### 1. Qual a principal imagem relacionada ao princípio e qual a explicação sobre ela?

A imagem de um cabo USB ao lado de um hub com quatro portas, com a seguinte legenda:

> *"You Want Me To Plug This In, Where?"*

Serve de analogia para interfaces de propósito geral, que podem ser utilizadas por qualquer classe, mas que podem não ser necessárias para todas que a implementam.

### 2. Por que devemos segregar implementações através do uso de interfaces?

Para aumentar a coesão e, consequemente, reduzir o acoplamento, evitando que uma classe implemente ou dependa de métodos que não são utilizados.

### 3. Podemos dizer que esse princípio é correlato ao Single Responsability Principle pelo fato de que classes e interfaces devem ter um único “foco” (SRP) e que as interfaces com métodos não correlatos devem ser segregadas (ISP)?

Sim, pois apesar de atuarem em diferentes campos, os dois princípios possuem propósitos semelhantes: tornar as classes mais especializadas. O ISP trata de interfaces, enquanto o SRP trata de classes.

### 4. Comente as seguintes frases à luz do ISP:

### a. “Nenhum cliente deve ser forçado a depender de métodos que ele não usa”;

Quando uma classe implementa uma interface, ela se torna dependente de seu comportamento, ou seja, se uma classe não utiliza um método da interface, ela não deveria implementá-la.

### b. “Classes não devem ser forçadas a implementar interfaces que não usam”;

Se uma classe não utiliza um método que ela implementa de forma forçada, é um indício de que a interface deve ser segregada em outras.

### Pesquise a respeito do Dependency Invertion Principle (DIP) e responda as questões abaixo:

### 5. Qual a principal imagem relacionada ao princípio e qual a explicação sobre ela?

A imagem de um fio para solda com núcleo de resina ao lado de um ferro de solda e uma tomada conectada, com a seguinte legenda:

> *"Would You Solder A Lamp Directly To The Electrical Wiring In A Wall?"*

Serve de analogia para a dependência de um módulo de alto nível com outro de baixo nível, representados respectivamente por uma lâmpada e pela fiação elétrica. O contraponto aparece ao lado, com a tomada retratando a interface entre os dois módulos, tornando a dependência indireta.

### 6. O que você entende por programar para Interfaces?

Tornar os objetos mais genéricos em relação ao seu tipo e mais específicos em relação ao seu comportamento. Basicamente, é a utilização de interfaces para estabelecer contratos do que o objeto tem ou pode fazer.

### 7. Cite um exemplo em que uma mudança em uma dependência, por exemplo, banco de dados, ou mecanismo de autenticação ou conexão via sockets poderia impactar uma implementação de outros módulos.

Aproveitando o modelo de interface de comunicação entre processos, caso a conexão fosse implementada em um protocolo diretamente e precisasse ser alterada posteriormente (ex: de TCP para UDP), todos os módulos que dependessem dela precisariam ser alterados também.

### 8. Estude o conteúdo do link abaixo e explique como o DIP se aplicaria:

> https://pt.stackoverflow.com/questions/101692/como-funciona-o-padr%C3%A3o-repository

O padrão Repository é um exemplo de aplicação do DIP, pois toda a lógica de acesso a dados é abstraída. Apenas as especificações ficam à cargo das regras de negócio, respeitando sempre o contrato estabelecido pela interface.

### 9. Você acha que esse princípio deveria ser um dos primeiros em um eventual “check-list” de princípios SOLID a aplicarmos?

Sim. A utilização do DIP facilita a aplicação dos demais princípios, pois a dependência entre módulos é reduzida, o que possiblita o aumento da coesão do código.

### 10. Numa visão geral, considera que se começarmos pelos 4 primeiros princípios SOLID, fatalmente o DIP já estaria implementado?

Sim, se apenas os princípios OCP e LSP forem aplicados corretamente, o DIP já estaria sendo cumprido. Os demais princípios serviriam como complemento.