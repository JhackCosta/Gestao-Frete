package br.com.gestao.entregas.entities.frete;

public record DadosListagemFrete(
        String nota, Long solicitante, Long entregador, Status status, double km, double valor
) {
    public DadosListagemFrete(Frete frete){
        this(frete.getNota(), frete.getSolicitante().getId(),
                frete.getMotorista().getId(), frete.getStatus(), frete.getKm(), frete.getValor());
    }
}
