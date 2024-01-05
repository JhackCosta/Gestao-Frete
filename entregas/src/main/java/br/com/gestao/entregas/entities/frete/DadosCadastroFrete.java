package br.com.gestao.entregas.entities.frete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFrete(
        @NotBlank
        String nota,

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
