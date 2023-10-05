import java.util.List;

public class ValidacaoImpostoDeRenda {
    private List<Validacao> validacoes;

    public ValidacaoImpostoDeRenda(List<Validacao> validacoes) {
        this.validacoes = validacoes;
    }

    public void validar(ImpostoDeRenda imposto) {
        for (Validacao validacao : validacoes) {
            validacao.validar(imposto);
        }
    }
}
