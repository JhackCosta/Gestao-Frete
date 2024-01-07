package br.com.gestao.entregas.entities.frete;



public record DadosListagemFrete(
        Long id, String nota, String produto, String descricao, Long solicitante, Long entregador, Status status, double km, double valor, Boolean ativo
) {
    public DadosListagemFrete(Frete frete){
        this(frete.getId(), frete.getNota(), frete.getProduto(), frete.getDescricao(), frete.getSolicitante().getId(),
                frete.getMotorista().getId(), frete.getStatus(), frete.getKm(), frete.getValor(), frete.isAtivo());
    }
}
