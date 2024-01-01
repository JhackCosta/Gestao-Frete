package br.com.gestao.entregas.entities.veiculo;

import br.com.gestao.entregas.entities.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVeiculo(
        @NotNull
        @NotBlank
        Entregador proprietario,
        @NotBlank
        String marca,
        @NotBlank
        Tipo tipo,
        @NotBlank
        Double peso) {

}
