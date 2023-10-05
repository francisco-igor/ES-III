import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Calculadora calculadora = new Calculadora(16, 8);
        List<Operacao> resultados = new ArrayList<>();

        Operacao soma = new Operacao() {
            public double executar(double a, double b) {
                return a + b;
            }
        };
        resultados.add(soma);

        Operacao sub = new Operacao() {
            public double executar(double a, double b) {
                return a - b;
            }
        };
        resultados.add(sub);

        Operacao mult = new Operacao() {
            public double executar(double a, double b) {
                return a * b;
            }
        };
        resultados.add(mult);

        Operacao div = new Operacao() {
            public double executar(double a, double b) {
                return a / b;
            }
        };
        resultados.add(div);

        System.out.println(calculadora.calcular(resultados));
    }
}
