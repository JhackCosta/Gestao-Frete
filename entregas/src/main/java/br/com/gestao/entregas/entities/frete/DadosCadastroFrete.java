package br.com.gestao.entregas.entities.frete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFrete(
        @NotBlank
        String nota,

        @NotBlank
        String produto,

        @NotBlank
        String descricao,

        @NotNull
        Long solicitante,

        @NotNull
        Long entregador,

        @NotNull
        Long veiculo,

        @NotNull
        Status status,

        @NotNull
        double km,

        @NotNull
        double valor
) {
}
