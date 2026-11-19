package b4hive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void finalizaPedido() {
        CheckoutFacade facade = new CheckoutFacade(
                new ServicoDeEstoque(),
                new GatewayPagamento(),
                new GeradorNotaFiscal(),
                new ServicoNotificacao());

        String resultado = facade.finalizarPedido("pedido-1", "cartao");

        assertEquals(
                "Pedido finalizado com sucesso. Comprovante: "
                        + "COMPROVANTE-pedido-1-cartao. Nota fiscal: "
                        + "NF-pedido-1 (comprovante: COMPROVANTE-pedido-1-cartao).",
                resultado);
    }

    @Test
    void verificaEstoqueEReservaItens() {
        ServicoDeEstoque estoque = new ServicoDeEstoque();

        assertFalse(estoque.verificarDisponibilidade(""));

        estoque.reservarItens("pedido-2");

        assertTrue(estoque.itensReservados("pedido-2"));
    }
}
