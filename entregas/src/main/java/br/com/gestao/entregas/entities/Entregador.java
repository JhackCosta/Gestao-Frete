package br.com.gestao.entregas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Entregador")
@Table(name = "Entregador")
@Data
public class Entregador extends Usuario {

    @Id
    private Long id;
    private String cnh;
    private boolean realizandoEntrega;
}
