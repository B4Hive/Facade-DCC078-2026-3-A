package b4hive;

public class GeradorNotaFiscal {
    public String emitirNota(String pedidoId, String comprovante) {
        return "NF-" + pedidoId + " (comprovante: " + comprovante + ")";
    }
}
