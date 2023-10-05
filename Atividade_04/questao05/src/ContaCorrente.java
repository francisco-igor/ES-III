import java.util.ArrayList;
import java.util.List;

class ContaCorrente {
    private String numero;
    private double saldo;
    private List<Transacao> transacoes;
    ContaCorrenteService obterInvalidas = new ContaCorrenteService();

    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.transacoes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }
    public List<Transacao> getTransacoesInvalidas() {
        return obterInvalidas.filtrarTransacoesInvalidas(this);
    }
}
