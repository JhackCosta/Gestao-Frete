package br.com.gestao.entregas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Entregador")
@Data
public class Entregador extends Usuario {

    @Id
    private Long id;
    private String cnh;
    private boolean realizandoEntrega;
}
