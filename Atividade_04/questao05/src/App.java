import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ContaCorrente conta = new ContaCorrente("1", 100000);
        Transacao transacao = new Transacao(1, 60000, TipoTransacao.DEBITO, conta.getSaldo());
        List<Transacao> transacoesInvalidas = transacao.getTransacoes();

        conta.addTransacao(transacao);
        transacoesInvalidas = conta.getTransacoesInvalidas();

        for (Transacao transacaoInvalida : transacoesInvalidas) {
            System.out.println("Id: " + transacaoInvalida.getId());
            System.out.println("Valor: " + String.format("%.2f", transacaoInvalida));
        }       
    }
}
