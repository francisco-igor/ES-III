import java.util.List;

enum TipoTransacao {
    CREDITO, DEBITO
}

class Transacao {
    private int id;
    private double valor;
    private TipoTransacao tipo;
    private double saldoConta;
    TransacaoService transacao = new TransacaoService();

    public Transacao(int id, double valor, TipoTransacao tipo, double saldoConta) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.saldoConta = saldoConta;
    }
    
    public int getId() {
        return id;
    }
    public double getValor() {
        return valor;

    }
    public TipoTransacao getTipo() {
        return tipo;
    }
    public boolean isFraudulenta() {
        return transacao.verificarFraude(this, saldoConta);
    }

    public List<Transacao> getTransacoes() {
        return null;
    }
}
