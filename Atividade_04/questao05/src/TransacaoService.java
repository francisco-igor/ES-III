public class TransacaoService {
    public boolean verificarFraude(Transacao transacao, double saldo) {
        double valor = transacao.getValor();
        TipoTransacao tipo = transacao.getTipo();

        if (tipo == TipoTransacao.CREDITO) {
            if (valor <= (saldo * 0.75)) {
                return false;
            }
        }
        if (tipo == TipoTransacao.DEBITO) {
            if (valor <= (saldo * 0.5)) {
                return false;
            }
        }
        return true;
    }
}
