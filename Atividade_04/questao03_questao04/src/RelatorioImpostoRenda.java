public class RelatorioImpostoRenda {
    public void gerarRelatorio(ImpostoDeRenda info, double impostoDevido) {
        System.out.println("CPF: " + info.getCpf());
        System.out.println("Rendimentos: " + info.getRendimentos());
        System.out.println("Despesas: " + info.getDespesas());
        System.out.println("Imposto Devido: R$" + String.format("%.2f", impostoDevido));
    }
}
