import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteService {
    public List<Transacao> filtrarTransacoesInvalidas(ContaCorrente conta) {
        List<Transacao> transacoes = conta.getTransacoes();
        List<Transacao> transacoesInvalidas = new ArrayList<>();

        for (Transacao transacao : transacoes) {

            if (transacao.isFraudulenta()) {
                transacoesInvalidas.add(transacao);
            }
            if (transacao.getValor() < 0) {
                transacoesInvalidas.add(transacao);
            }
        }
        return transacoesInvalidas;
    }
}
