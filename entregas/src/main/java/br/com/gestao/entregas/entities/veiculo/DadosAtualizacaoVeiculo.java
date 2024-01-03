package br.com.gestao.entregas.entities.veiculo;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoVeiculo(
        @NotBlank
        Long id,
        Long idProprietario,
        String marca,
        Tipo tipo,
        Double peso,
        String placa
        ) {
}
