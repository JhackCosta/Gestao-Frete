package br.com.gestao.entregas.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "DTYPE")
public abstract class Usuario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;

    @Column(name = "E-MAIL")
    private String email;
    @Column(name = "CONTATO")
    private String contato;

    public Usuario(String nome, String email, String contato) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
    }
}
