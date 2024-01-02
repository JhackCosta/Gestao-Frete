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
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Column(name = "CODIGO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "CONTATO")
    private String contato;

  //  @OneToMany(mappedBy = "proprietario")
  //  private List<Veiculo> veiculo;

    @Column(name = "ATIVO")
    private boolean ativo = true;

    public Usuario(String nome, String email, String contato) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
    }


}
