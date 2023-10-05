enum TipoInvestimento {
    RENDA_FIXA, RENDA_VARIAVEL
}

class Investimento {
    private int id;
    private double valor;
    private TipoInvestimento tipo;
    private StatusRisco statusRisco;
    InvestimentoService investimento = new InvestimentoService();

    public Investimento(int id, double valor, TipoInvestimento tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.statusRisco = investimento.avaliarRisco(this);
    }

    public int getId() {
        return id;
    }
    public double getValor() {
        return valor;
    }
    public TipoInvestimento getTipo() {
        return tipo;
    }
    public StatusRisco getStatusRisco() {
        return statusRisco;
    }
}
