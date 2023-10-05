## Exercícios 02 - Respostas

### 1. Qual a relação que coesão possui com as responsabilidades de uma classe?

> Coesão é a relação harmônica entre elementos que formam uma unidade lógica. No caso das classes, refere-se ao alinhamento de sentido entre suas atribuições, ou seja, quanto mais coesa uma classe, mais restritas são suas responsabilidades.

### 2. Contextualize o conceito de coesão de acordo com as fontes abaixo:

* a. Livro Clean Code: páginas de 140 a 151;

> O autor estabelece que as classes devem possuir um número pequeno de variáveis, e quanto mais dessas variáveis um método manipular, mais coeso ele é para a classe.

* b. Artigo Coesão e Acoplamento em Sistemas Orientados a Objetos disponível em https://www.researchgate.net/publication/261026207_Coesao_e_Acoplamento_em_Sistemas_OO;

> O autor explica que é a relação entre os métodos de uma classe e suas responsabilidades. Assim, uma classe altamente coesa possui métodos que têm responsabilidades bem definidas e relacionadas, enquanto uma classe com baixa coesão tem métodos com responsabilidades diversas e pouco relacionadas.

* c. Livro Orientação a Objetos e SOLID para Ninjas Projetando classes flexíveis - Casa do Codigo. Princípio da responsabilidade única. Página 5 em diante.

> O autor define que uma classe coesa é aquela que possui apenas uma responsabilidade, ou seja, ela toma conta de apenas um conceito no sistema.

### 3. A classe abaixo possui problemas de coesão:

<details>
<summary> Cliente </summary>

```java
public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private double valorCompra;
    private String numeroConta;
    private double saldo;

    public void exibirInformacoes() {
    // exibir informações do cliente
    }
    public void realizarCompra() {
    // lógica de compra
    }
    public void atualizarSaldo() {

    // atualizar saldo do cliente
    }
}
```
</details>

#### Refatore o código criando classes Conta, Compra e Cliente de forma que cada uma fique coesa.

```java
public class Conta {
    private String numeroConta;
    private double saldo;

    // construtor

    public void atualizarSaldo() {
        // atualizar saldo do cliente
    }
}

public class Compra {
    private double valorCompra;

    // construtor

    public void realizarCompra() {
        // lógica de compra
    }
}

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private Conta conta;

    // construtor

    public void exibirInformacoes() {
        // exibir informações do cliente
    }
}
```

### 4. Classes utilitárias são muito comuns, pois elas agregam funcionalidades usadas por outras classes para centralizar códigos de utilidade geral. A classe abaixo entretanto possui problemas de coesão por ter diferentes aspectos de utilidades. Refatore-a criando classes necessárias de forma a deixar as classes resultantes coesas. Implemente os métodos e além disso, modifique os métodos para acessarem atributos e não usar os parâmetros passados.

<details>
<summary> Utilitários </summary>

```java
public class Utilitarios {
    public void ordenar(int[] array) {
    // lógica de ordenação
    }
    public void embaralhar(int[] array) {
    // lógica de ordenação
    }

    public String removerEspacos(String texto) {
    // lógica de remoção de espaços
    }
    public String[] quebrarEmPalavras(String texto) {
    // lógica de remoção de espaços
    }
    public double calcularMedia(double[] numeros) {
    // lógica de cálculo de média
    }
    public double calcularDesvioPadrão(double[] numeros) {
    // lógica de cálculo de média
    }
}
```
</details>

####
```java
import java.util.Arrays;

public class Ordenacao {
    private int[] array;

    public Ordenacao(int[] array) {
        this.array = array;
    }

    public void ordenar() {
        Arrays.sort(array);
    }

    public void embaralhar() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

public class Texto {
    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public String removerEspacos() {
        return texto.replaceAll("\\s", "");
    }

    public String[] quebrarEmPalavras() {
        return texto.split("\\s+");
    }
}

public class Calculo {
    private double[] numeros;

    public Calculo(double[] numeros) {
        this.numeros = numeros;
    }

    public double calcularMedia() {
        if (numeros.length == 0) {
            return 0;
        }

        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }

        return soma / numeros.length;
    }

    public double calcularDesvioPadrao() {
        if (numeros.length == 0) {
            return 0;
        }

        double media = calcularMedia();
        double quadrados = 0;

        for (double numero : numeros) {
            quadrados += Math.pow(numero - media, 2);
        }

        double variancia = quadrados / numeros.length;
        return Math.sqrt(variancia);
    }
}
```

### 5. Demonstre com Classes os principais tipos de coesão presentes no artigo Acoplamento e Coesão, disponível em https://www.facom.ufu.br/~ronaldooliveira/PDS-2019-1/Aula10-Complemento-AcoplamentoCoesao.pdf

<details>
<summary> Coesão Coincidental </summary>

```java
class Aleatoria {
    // atributos

    public void calcularArea() {
        // lógica
    }

    public void gerarBoleto() {
        // lógica
    }

    public void salvarDados() {
        // lógica
    }
}
```
</details>

<details>
<summary> Coesão Lógica </summary>

```java
class Calculadora {
    private double num1;
    private double num2;

    public Calculo(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double calcular(String op) {
        switch(op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
```
</details>

<details>
<summary> Coesão Temporal </summary>

```java
class Execucao {
    private int estado = 1;

    public void executar() {
        switch(estado) {
            case 1:
                System.out.println("Estado 1");
            case 2:
                System.out.println("Estado 2");
            case 3:
                System.out.println("Estado 3");
            case 4:
                System.out.println("Estado 4");
            // continua...
        }
        estado++;
    }
}
```
</details>

<details>
<summary> Coesão Procedural </summary>

```java
class Array {
    private int[] array;

    public void ordenarArray() {
        // lógica
    }

    public void buscarElemento(int elemento) {
        // lógica
    }
}
```
</details>

<details>
<summary> Coesão de Comunicação </summary>

```java
class Mensagem {
    private int mensagem;

    public void setValor(int novaMsg) {
        mensagem = novaMsg;
    }

    public void enviarEmail() {
        // Lógica
    }

    public void enviarSMS() {
        // Lógica
    }

    public void enviarFax() {
        // Lógica
    }
}
```
</details>

<details>
<summary> Coesão Sequencial </summary>

```java
class Equacao {
    private float a;
    private float b;
    private float c;
    float delta;
    float x1;
    float x2;

    public Calculo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void resultado() {
        if (a == 0) {
            return;
        }
        calcular();

        System.out.printf("x1 = %.0f e x2 = %.0f", x1, x2);
    }

    public void calcular() {
        calcularDelta();
        calcularBhaskara();
    }

    private void calcularDelta() {
        delta = Math.pow(b, 2) - (4 * a * c);
        delta = (float) Math.sqrt(delta);
    }

    private void calcularBhaskara() {
        x1 = (-b + delta) / (2 * a);
        x2 = (-b - delta) / (2 * a);
    }
}
```
</details>

<details>
<summary> Coesão Funcional </summary>

```java
class Operacoes {
    public static int calcularSoma(int a, int b) {
        return a + b;
    }

    public static int calcularDiferenca(int a, int b) {
        return a - b;
    }

    public static int calcularProduto(int a, int b) {
        return a * b;
    }

    public static float calcularQuociente(int a, int b) {
        return a / b;
    }
}
```
</details>

### 6. Explique com suas palavras o que é o acoplamento entre classes.

> É a relação de interdependência entre classes. Quanto mais uma classe possui conhecimento e dependência de outra, mais forte o acoplamento entre elas.

### 7. Crie e exemplifique uma classe com alto acoplamento e refatore-a para ter o acoplamento reduzido.

<details>
<summary> Alto acoplamento </summary>

```java
class Mostrar {
    public Print saldar() {
        Printar mensagem = new Printar();
        return mensagem;
    }
}

class Printar {
    public void hello() {
        System.out.println("Hello World!");
    }
}
```
</details>

<details>
<summary> Baixo acoplamento </summary>

```java
class Mostrar {
    public void saldar(Printar mensagem) {
        mensagem.hello();
    }
}

class Printar {
    public void hello() {
        System.out.println("Hello World!");
    }
}
```
</details>

### 8. Por que dizemos que o princípio ”Tell, don’t ask” mitiga problema de acoplamento? Demonstre.

> A prática "Tell, don't ask" promove o conceito de encapsulamento, que instrui a ocultar o funcionamento do código a fim de limitar o acesso aos seus dados.

### 9. É possivel zerar o acoplamento em um software simples ou complexo? Justifique.

> Não, pois os artefatos de um sistema precisam se conectar, consequentemente gerando algum nível de dependência entre eles, o que torna praticamente impossível um software sem acoplamento.

### 10. O encapsulamento também mitiga o acoplamento alto? Discuta o exemplo da página 7 do artigo Coesão e Acoplamento em Sistemas Orientados a Objetos.

> Sim, pois o princípio de encapsulamento orienta a restringir o acesso ao estado do código. 

> No exemplo apresentado, os atributos da classe principal não estavam encapsulados, o que possiblitou as instâncias definirem seus atributos diretamente. Esse cenário destaca um forte acoplamento entre a classe "Evento" e suas classes derivadas.
