import java.util.List;

public class CalculadoraImpostoDeRenda {
    public double calcularImposto(List<Double> rendimentos, List<Double> despesas) {
        double rendaTotal = rendimentos.stream().mapToDouble(Double::doubleValue).sum();
        double despesaTotal = despesas.stream().mapToDouble(Double::doubleValue).sum();
        double baseCalculo = rendaTotal - despesaTotal;

        if (baseCalculo <= 1903.98) {
            return 0.0;
        }
        if (baseCalculo <= 2826.65) {
            return baseCalculo * 0.075 - 142.80;
        }
        if (baseCalculo <= 3751.05) {
            return baseCalculo * 0.15 - 354.80;
        }
        if (baseCalculo <= 4664.68) {
            return baseCalculo * 0.225 - 636.13;
        }
        return baseCalculo * 0.275 - 869.36;
    }
}
