import java.util.List;

public class ValidacaoRendimentos implements Validacao{
    public void validar(ImpostoDeRenda imposto) {
        List<Double> rendimentos = imposto.getRendimentos();

        if (rendimentos.size() > 5) {
            throw new IllegalArgumentException("Rendimentos Excessivos");
        }
        for (double rendimento : rendimentos) {
            if (rendimento < 0) {
                throw new IllegalArgumentException("Rendimento Negativo.");
            }
        }
    }
}
