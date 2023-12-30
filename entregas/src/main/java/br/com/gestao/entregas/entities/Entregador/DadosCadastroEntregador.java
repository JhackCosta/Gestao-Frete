package br.com.gestao.entregas.entities.Entregador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEntregador(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contato,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cnh,
        @NotBlank
        @Pattern(regexp = "[A-Za-z]{1,2}")
        String categoria
) {
}
