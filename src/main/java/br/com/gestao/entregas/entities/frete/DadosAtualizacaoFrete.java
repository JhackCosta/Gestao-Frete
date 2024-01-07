package br.com.gestao.entregas.entities.frete;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFrete(
                                    @NotNull
                                    Long id,

                                    String nota,

                                    String produto,

                                    String descricao,

                                    Long solicitante,

                                    Long veiculo,

                                    Long entregador,

                                    Status status,

                                    Double km,

                                    double valor,

                                    Boolean ativo
                                    ) {
}
