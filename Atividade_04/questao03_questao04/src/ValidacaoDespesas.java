public class ValidacaoDespesas implements Validacao {
    public void validar(ImpostoDeRenda imposto) {

        for (double despesa : imposto.getDespesas()) {
            if (despesa < 0) {
                throw new IllegalArgumentException("Despesa Negativa.");
            }
        }
    }
}
