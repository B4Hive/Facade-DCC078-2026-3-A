package b4hive;

public class GatewayPagamento {
    public String autorizarCobranca(String pedidoId, String metodo) {
        return "COMPROVANTE-" + pedidoId + "-" + metodo;
    }
}
