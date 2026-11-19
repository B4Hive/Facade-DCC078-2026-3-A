package b4hive;

public class CheckoutFacade {
    private final ServicoDeEstoque servicoDeEstoque;
    private final GatewayPagamento gatewayPagamento;
    private final GeradorNotaFiscal geradorNotaFiscal;
    private final ServicoNotificacao servicoNotificacao;

    public CheckoutFacade() {
        this(new ServicoDeEstoque(), new GatewayPagamento(),
                new GeradorNotaFiscal(), new ServicoNotificacao());
    }

    public CheckoutFacade(ServicoDeEstoque servicoDeEstoque, GatewayPagamento gatewayPagamento, GeradorNotaFiscal geradorNotaFiscal, ServicoNotificacao servicoNotificacao) {
        this.servicoDeEstoque = servicoDeEstoque;
        this.gatewayPagamento = gatewayPagamento;
        this.geradorNotaFiscal = geradorNotaFiscal;
        this.servicoNotificacao = servicoNotificacao;
    }

    public String finalizarPedido(String pedidoId, String metodoPagamento) {
        servicoDeEstoque.reservarItens(pedidoId);
        String comprovante = gatewayPagamento.autorizarCobranca(pedidoId, metodoPagamento);
        String notaFiscal = geradorNotaFiscal.emitirNota(pedidoId, comprovante);
        servicoNotificacao.enviarConfirmacao(pedidoId, notaFiscal);
        return "Pedido finalizado com sucesso. Comprovante: " + comprovante + ". Nota fiscal: " + notaFiscal + ".";
    }
}
