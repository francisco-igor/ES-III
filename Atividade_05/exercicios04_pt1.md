## Exercícios 04 - Parte 1

### Pesquise a respeito do Liskov Substitution Principle e responda as questões abaixo:

### 1. Por que o uso do nome próprio Liskov?

O Princípio de Substituição de Liskov leva esse nome por ter sido criado por Barbara Liskov, em 1988. O princícpio diz:

> *“Em um programa de computador, se S é um subtipo de T, então objetos do tipo T podem ser substituídos por objetos do tipo S (ou seja, objetos do tipo S podem substituir objetos do tipo T) sem alterar qualquer uma das propriedades desejáveis ​​desse programa (correção, tarefa executada, etc.)".*

### 2. Qual a principal imagem relacionada ao princípio e qual a explicação sobre ela?

É a imagem de um pato real e de um pato de borracha com a legenda: "Se parece com um pato, grasna como um pato, mas precisa de baterias — Provavelmente você está usando a abstração de forma incorreta". A imagem é usada para explicar que, mesmo que os dois sejam patos, eles não são iguais.

### 3. Cite um exemplo onde a herança pode ser usada de forma conveniente, porém deixa uma impressão de que está sendo mal aplicada.

Uma classe "Animal" e subclasses "Cão" e "Pássaro". Se a classe "Animal" tiver um método "voar", isso não faria sentido para a subclasse "Cão".

### 4. Cite um exemplo onde a herança pode ser usada de forma conveniente, porém deixa futuras expansões comprometidas ou com problemas de design.

Uma classe "Produto" e subclasses "Livro" e "Alimento". Se a classe "Produto" tiver um método "getValidade", isso não faria sentido para a subclasse "Livro". Isso pode levar a problemas de design se quisermos adicionar mais subclasses de "Produto" no futuro.

### 5. Nos exemplos que você citou, a composição seria mais aplicável? Refaça-os.

Sim, a composição seria mais aplicável nesses casos:

<details>
<summary> Animal </summary>

```java
interface Animal {
    void realizarAcao();
}

class HabilidadeVoar {
    void voar() {
        System.out.println("Voando...");
    }
}

class Cao implements Animal {
    HabilidadeVoar habilidadeVoar;

    @Override
    public void realizarAcao() {
        // Não implementa...
    }
}

class Passaro implements Animal {
    HabilidadeVoar habilidadeVoar;

    public Passaro() {
        habilidadeVoar = new HabilidadeVoar();
    }

    @Override
    public void realizarAcao() {
        habilidadeVoar.voar();
    }
}
```
</details>

Cao e Passaro são classes que implementam a interface Animal. A habilidade de voar é tratada como uma composição separada que pode ser usada quando necessário.

<details>
<summary> Produto </summary>

```java
interface Produto {
    void verificarPropriedade();
}

class Validade {
    void getValidade() {
        System.out.println("Verificando validade...");
    }
}

class Livro implements Produto {
    Validade validade;

    @Override
    public void verificarPropriedade() {
        // Não implementa...
    }
}

class Alimento implements Produto {
    Validade validade;

    public Alimento() {
        validade = new Validade();
    }

    @Override
    public void verificarPropriedade() {
        validade.getValidade();
    }
}
```
</details>

Livro e Alimento são classes que implementam a interface Produto. A validade é tratada como uma composição separada que pode ser usada quando necessário.