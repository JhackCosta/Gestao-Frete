package br.com.gestao.entregas.entities.veiculo;


import br.com.gestao.entregas.entities.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JoinColumn(name = "FK_PROPRIETARIO")
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
        this.proprietario = dados.proprietario();
    }

    public void atualizarInformacoes(DadosAtualizacaoVeiculo dados) {

        if (dados.peso() != null) {
            this.peso = dados.peso();
        }

        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }

        if (dados.marca() != null) {
            this.marca = dados.marca();
        }

        if (dados.proprietario() != null) {
            this.proprietario = dados.proprietario();
        }
    }
}
