package br.com.gestao.entregas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Empresa")
@Table(name = "Empresa")
@Data
public class Empresa extends Usuario{

    @Id
    private Long id;
    private String cnpj;
}
