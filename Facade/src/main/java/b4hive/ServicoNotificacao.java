package b4hive;

import java.util.HashSet;
import java.util.Set;

public class ServicoNotificacao {
    private final Set<String> pedidosConfirmados = new HashSet<>();

    public void enviarConfirmacao(String pedidoId, String nota) {
        pedidosConfirmados.add(pedidoId);
    }

    public boolean confirmacaoEnviada(String pedidoId) {
        return pedidosConfirmados.contains(pedidoId);
    }
}
