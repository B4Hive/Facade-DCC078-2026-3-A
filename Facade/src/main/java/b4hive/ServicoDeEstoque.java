package b4hive;

import java.util.HashSet;
import java.util.Set;

public class ServicoDeEstoque {
    private final Set<String> pedidosReservados = new HashSet<>();

    public boolean verificarDisponibilidade(String pedidoId) {
        return pedidoId != null && !pedidoId.isBlank();
    }

    public void reservarItens(String pedidoId) {
        pedidosReservados.add(pedidoId);
    }

    public boolean itensReservados(String pedidoId) {
        return pedidosReservados.contains(pedidoId);
    }
}
