package br.com.gestao.entregas.entities.frete;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoStatusFrete(
        @NotNull
        Long id,

         @NotBlank
         String nota,

        @NotNull
        Status status
) {
}
