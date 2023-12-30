package br.com.gestao.entregas.entities.Empresa;

import br.com.gestao.entregas.entities.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Empresa")
@Table(name = "Empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorValue("empresa")
public class Empresa extends Usuario {


    @Column(name = "CNPJ")
    private String cnpj;
}
