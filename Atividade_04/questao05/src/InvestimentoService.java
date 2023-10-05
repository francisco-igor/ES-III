enum StatusRisco {
    BAIXO, MODERADO, ALTO
}

public class InvestimentoService {
    public StatusRisco avaliarRisco(Investimento investimento) {
        double valor = investimento.getValor();
        TipoInvestimento tipo = investimento.getTipo();

        if (valor > 5000.0 && tipo == TipoInvestimento.RENDA_FIXA) {
            return StatusRisco.BAIXO;
        }
        if (valor > 10000.0 && tipo == TipoInvestimento.RENDA_VARIAVEL) {
            return StatusRisco.ALTO;
        }
        return StatusRisco.MODERADO;
    }
}
