## Exercícios 04 - Parte 1

<details>
<summary> Questão 01 </summary>

### 1. Em um sistema bancário temos as seguintes classes:

```java
public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) { saldo += valor; }

    public void sacar(double valor) { saldo -= valor; }
}

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 1000) {
            throw new RuntimeException("Não pode sacar mais de 1000 em uma poupança");
        }
        super.sacar(valor);
    }
}
```

### Explique por que motivo a herança entre as classes não é justificada e proponha uma solução.

O método sacar da classe ContaPoupanca não se comporta da mesma forma que o método sacar da classe ContaBancaria, pois o método sacar da classe ContaPoupanca lança uma exceção caso o valor a ser sacado seja maior que 1000, enquanto o método sacar da classe ContaBancaria não lança exceção.

#### Solução:

```java
public class ContaPoupanca {
    private ContaBancaria contaBancaria;

    public ContaPoupanca(double saldoInicial) {
        this.contaBancaria = new ContaBancaria(saldoInicial);
    }

    public void sacar(double valor) {
        if (valor > 1000) {
            throw new RuntimeException("Não pode sacar mais de 1000 em uma poupança");
        }
        this.contaBancaria.sacar(valor);
    }
}
```
</details>

<details>
<summary> Questão 02 </summary>

### 2. Proponha uma solução que evite o uso da herança no código abaixo:

```java
public class Conta {
    private double saldo;
    private String numeroConta;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    // Outros métodos relevantes...
}

public class ContaCliente extends Conta {
    private String nome;
    private String cpf;
    private String endereco;

    public ContaCliente(String numeroConta, double saldoInicial, String nome, String cpf, String endereco) {
        super(numeroConta, saldoInicial);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Métodos específicos do cliente...
}
```
#### Solução:

```java
public class Conta {
    private double saldo;
    private String numeroConta;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    // Outros métodos relevantes...
}

public class ContaCliente {
    private Conta conta;
    private String nome;
    private String cpf;
    private String endereco;

    public ContaCliente(String numeroConta, double saldoInicial, String nome, String cpf, String endereco) {
        this.conta = new Conta(numeroConta, saldoInicial);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void depositar(double valor) {
        conta.depositar(valor);
    }

    public void sacar(double valor) {
        conta.sacar(valor);
    }

    // Métodos específicos do cliente...
}
```
</details>

<details>
<summary> Questão 03 </summary>

### 3. Aplique o princípio LSP à implementação abaixo de forma que persistência seja um atributo da segunda classe. Crie um exemplo real com o resultado da refatoração.

```java
import java.io.*;

public class Persistencia {
    public void salvar(String dados, String arquivo) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
        writer.write(dados);
        }
    }
}

public class PersistenciaJSON extends Persistencia {
    @Override
    public void salvar(String dados, String arquivo) throws IOException {
        if (!dados.startsWith("{")) {
            throw new IllegalArgumentException("Dados não estão em formato JSON.");
        }
        super.salvar(dados, arquivo);
    }
}
```

#### Solução:

```java
import java.io.*;

public class Persistencia {
    public void salvar(String dados, String arquivo) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
        writer.write(dados);
        }
    }
}

public class PersistenciaJSON {
    public Persistencia persistencia;

    public PersistenciaJSON() {
        this.persistencia = new Persistencia();
    }

    public void salvar(String dados, String arquivo) throws IOException {
        if (!dados.startsWith("{")) {
            throw new IllegalArgumentException("Dados não estão em formato JSON.");
        }
        this.persistencia.salvar(dados, arquivo);
    }

    public static void main(String[] args) throws IOException{
        PersistenciaJSON pJson = new PersistenciaJSON();
        try {
            pJson.salvar("Nota: Entregar atividade...", "notas.json");
            System.out.println("Arquivo salvo.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```
</details>

<details>
<summary> Questão 04 </summary>

### 4. Entenda o problema da herança entre patos e suas capacidades presentes no exemplo do link:

https://www.quora.com/What-are-some-Java-examples-for-the-OOP-principle-of-favoring-object-composition-over-inheritance

### Proponha um exemplo que também viola o LSP e exiba sua solução.

#### Exemplo de violação do LSP:

```java
class Retangulo {
    private int largura, altura;

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getArea() {
        return largura * altura;
    }
}

class Quadrado extends Retangulo {
    public void setLargura(int largura) {
        super.setLargura(largura);
        super.setAltura(largura);
    }

    public void setAltura(int altura) {
        super.setLargura(altura);
        super.setAltura(altura);
    }
}
```

#### Solução:

```java
interface Forma {
    public int getArea();
}

class Retangulo implements Forma {
    protected int largura, altura;

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getArea() {
        return largura * altura;
    }
}

class Quadrado implements Forma {
    private int lado;

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public int getArea() {
        return lado * lado;
    }
}
```

</details>

<details>
<summary> Questão 05 </summary>

### 5. As classes Postagem, Reacao e Comentario possuem uma herança apenas para aproveitar alguns atributos e reescrever o método exibir().

```java
public class Perfil {
    private int id;
    private String nomeUsuario;

    public Perfil(int id, String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.id = id;
    }

    // Outros métodos
}

public class Postagem {
    private String id;
    private Perfil autor;
    private String conteudo;

    public Postagem(String id, Perfil autor, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
    }

    public void exibir() {
        System.out.println("Postagem [" + id + "] de " + autor.getNomeUsuario() +": " + conteudo);
    }

    // outros métodos
}

public class Reacao extends Postagem {
    private String tipoReacao;

    public Reacao(String id, Perfil autor, String tipoReacao) {
        super(id, autor, null);
        this.tipoReacao = tipoReacao;
    }

    @Override
    public void exibir() {
        System.out.println("Reação [" + tipoReacao + "] de " +
        getAutor().getNomeUsuario() + " na postagem " + getId();
    }

    // outros métodos
}

public class Comentario extends Postagem {
    private Postagem postagemOriginal;

    public Comentario(String id, Perfil autor, String conteudo, Postagem
    postagemOriginal) {
        super(id, autor, conteudo);
        this.postagemOriginal = postagemOriginal;
    }

    @Override
    public void exibir() {
        System.out.println("Comentário de " + getAutor().getNomeUsuario() + " em resposta a postagem [" + postagemOriginal.getId() + "]: " + conteudo);
    }

    // outros métodos
}
```

### Refatore as classes de forma a:
    a. Reacao tenha uma composição com postagem;

    b. Comentário também tenha uma composição com postagem;

    c. Postagem tenha uma coleção de reações e comentários;

    d. Todos implementem a interface abaixo:

```java	
public interface Publicavel {
    void exibir();
    Perfil getAutor();
}
```

#### Solução:

```java
import java.util.List;
import java.util.ArrayList;

public interface Publicavel {
    void exibir();
    Perfil getAutor();
}

public class Perfil {
    private int id;
    private String nomeUsuario;

    public Perfil(int id, String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    // Outros métodos
}

public class Postagem implements Publicavel {
    private String id;
    private Perfil autor;
    private String conteudo;
    private List<Reacao> reacoes;
    private List<Comentario> comentarios;

    public Postagem(String id, Perfil autor, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.reacoes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    @Override
    public Perfil getAutor() {
        return autor;
    }

    @Override
    public void exibir() {
        System.out.println("Postagem [" + getId() + "] de " + getAutor().getNomeUsuario() + ": " + conteudo);
    }

    public void addReacao(Reacao reacao) {
        this.reacoes.add(reacao);
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    // Outros métodos
}


public class Reacao implements Publicavel {
    private String id;
    private Perfil autor;
    private String tipoReacao;
    private Postagem postagem;

    public Reacao(String id, Perfil autor, String tipoReacao, Postagem postagem) {
        this.id = id;
        this.autor = autor;
        this.tipoReacao = tipoReacao;
        this.postagem = postagem;
    }

    public String getId() {
        return postagem.getId();
    }

    @Override
    public Perfil getAutor() {
        return postagem.getAutor();
    }

    @Override
    public void exibir() {
        System.out.println("Reação [" + tipoReacao + "] de " + getAutor().getNomeUsuario() + " na postagem "
                + postagem.getId());
    }

    // Outros métodos
}

public class Comentario implements Publicavel {
    private String id;
    private Perfil autor;
    private String conteudo;
    private Postagem postagemOriginal;

    public Comentario(String id, Perfil autor, String conteudo, Postagem postagemOriginal) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.postagemOriginal = postagemOriginal;
    }

    @Override
    public Perfil getAutor() {
        return autor;
    }

    @Override
    public void exibir() {
        System.out.println("Comentário de " + getAutor().getNomeUsuario() + " em resposta a postagem [" + postagemOriginal.getId()
                + "]: " + conteudo);
    }

    // Outros métodos
}
```
</details>