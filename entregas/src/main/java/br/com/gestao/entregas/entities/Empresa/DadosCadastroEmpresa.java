package br.com.gestao.entregas.entities.Empresa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEmpresa(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contato,
        @NotBlank
        @Pattern(regexp = "\\d{14}")
        String cnpj
) {
}
