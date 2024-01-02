package br.com.gestao.entregas.entities.veiculo;

import br.com.gestao.entregas.entities.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVeiculo(
        @NotNull
        Long idProprietario,
        @NotBlank
        String marca,
        @NotNull
        Tipo tipo,
        @NotNull
        Double peso) {

}
