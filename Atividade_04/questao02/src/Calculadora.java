import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private final double a;
    private final double b;

    public Calculadora(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public List<Double> calcular(List<Operacao> operacoes) {
        List<Double> resultados = new ArrayList<>();

        for (Operacao operacao : operacoes) {
            resultados.add(operacao.executar(a, b));
        }
        return resultados;
    }
}
