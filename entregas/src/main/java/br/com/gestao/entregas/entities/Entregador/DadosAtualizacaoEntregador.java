package br.com.gestao.entregas.entities.Entregador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEntregador(
        @NotNull
        Long id,
        String nome,
        String email,
        String contato,
        String cnh,
        String categoria,
        Boolean realizandoEntrega,
        Boolean ativo
) {
}
