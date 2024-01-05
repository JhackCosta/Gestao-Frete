package br.com.gestao.entregas.entities.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVeiculo(
        @NotNull
        Long idProprietario,
        @NotBlank
        String marca,
        @NotNull
        Tipo tipo,
        @NotBlank
        String placa
        ) {

}
