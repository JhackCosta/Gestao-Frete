package br.com.gestao.entregas.entities.veiculo;


import br.com.gestao.entregas.entities.Usuario;
import br.com.gestao.entregas.entities.entregador.Entregador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "Veiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_VEICULO")
    private Long id;

    @JoinColumn(name = "FK_PROPRIETARIO" , nullable = false)
    @ManyToOne
    private Usuario proprietario;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "PESO")
    private Double peso;


    public Veiculo(DadosCadastroVeiculo dados) {
        this.marca = dados.marca();
        this.peso = dados.peso();
        this.tipo = dados.tipo();
    }

    public Veiculo(DadosCadastroVeiculo dados, Entregador proprietario) {
        this.marca = dados.marca();
        this.peso = dados.peso();
        this.tipo = dados.tipo();
        this.proprietario = proprietario;
    }

    public void atualizarInformacoes(DadosAtualizacaoVeiculo dados , Entregador proprietario) {

        if (dados.peso() != null) {
            this.peso = dados.peso();
        }

        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }

        if (dados.marca() != null) {
            this.marca = dados.marca();
        }

        if (proprietario != null) {
            this.proprietario = proprietario;
        }
    }
}
