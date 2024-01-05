package br.com.gestao.entregas.entities.frete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFrete(
                                    @NotNull
                                    Long id,

                                    @NotBlank
                                    String nota,

                                    @NotNull
                                    Long solicitante,

                                    @NotNull
                                    Long veiculo,

                                    @NotNull
                                    Long entregador,

                                    @NotNull
                                    Status status,

                                    @NotNull
                                    Double km,

                                    @NotNull
                                    double valor) {
}
