package br.com.gestao.entregas.entities;

import lombok.Data;

@Data
public abstract class Usuario {

    private String nome;
    private String email;
    private String contato;

}
