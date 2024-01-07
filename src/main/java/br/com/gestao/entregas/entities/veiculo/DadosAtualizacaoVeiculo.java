package br.com.gestao.entregas.entities.veiculo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVeiculo(
        @NotNull
        Long id,
        Long idProprietario,
        String marca,
        Tipo tipo,
        String placa
        ) {
}
