package br.com.gestao.entregas.entities.veiculo;

import br.com.gestao.entregas.entities.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoVeiculo(
        @NotBlank
        Long id,
        @NotBlank
        Long idProprietario,
        String marca,
        Tipo tipo,
        Double peso) {
}