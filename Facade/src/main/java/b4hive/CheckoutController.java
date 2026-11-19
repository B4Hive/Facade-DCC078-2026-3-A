package b4hive;

public class CheckoutController {
    private final CheckoutFacade checkoutFacade;

    public CheckoutController(CheckoutFacade checkoutFacade) {
        this.checkoutFacade = checkoutFacade;
    }

    public String finalizarPedido(String pedidoId, String metodoPagamento) {
        return checkoutFacade.finalizarPedido(pedidoId, metodoPagamento);
    }
}
