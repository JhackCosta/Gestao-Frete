package br.com.gestao.entregas.entities.Empresa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEmpresa(@NotNull
                                      Long id,
                                      String nome,
                                      String email,
                                      String contato,
                                      String cnpj,
                                      Boolean ativo) {
}
