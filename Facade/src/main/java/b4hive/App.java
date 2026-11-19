package b4hive;

public class App {
    public static void main(String[] args) {
        CheckoutController controller = new CheckoutController(new CheckoutFacade());
        String resultado = controller.finalizarPedido("pedido-123", "cartao");
        System.out.println(resultado);
    }
}
