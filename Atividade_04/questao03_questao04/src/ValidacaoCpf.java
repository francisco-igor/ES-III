public class ValidacaoCpf implements Validacao {
    public void validar(ImpostoDeRenda imposto) {

        if (imposto.getCpf() == "") {
            throw new NullPointerException("Campo CPF Vazio.");
        }
        if (imposto.getCpf().length() != 11) {
            throw new IllegalArgumentException("CPF Inválido.");
        }
    }
}
