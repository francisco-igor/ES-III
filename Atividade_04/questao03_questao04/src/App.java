import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Double> rendimentos = Arrays.asList(23890.45, 13450.12, 28900.76, 16700.55, 23210.99);
        List<Double> despesas = Arrays.asList(1200.75, 4500.00, 3045.50, 1800.90, 3500.25);
        ImpostoDeRenda info = new ImpostoDeRenda("00000000000", rendimentos, despesas);
        info.processar();
    }
}
