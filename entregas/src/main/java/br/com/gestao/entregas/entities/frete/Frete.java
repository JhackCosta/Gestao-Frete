package br.com.gestao.entregas.entities.frete;


import br.com.gestao.entregas.entities.empresa.Empresa;
import br.com.gestao.entregas.entities.entregador.Entregador;
import br.com.gestao.entregas.entities.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FRETE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOTA_FISCAL", unique = true, nullable = false)
    private String nota;

    @Column(name = "PRODUTO")
    private String produto;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "FK_EMPRESA")
    @OneToOne
    private Empresa solicitante;

    @JoinColumn(name = "FK_ENTREGADOR")
    @OneToOne
    private Entregador motorista;

    @JoinColumn(name = "FK_Veiculo")
    @OneToOne
    private Veiculo veiculo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "KM")
    private double km;

    @Column(name = "VALOR")
    private double valor;

    @Column(name = "ATIVO")
    private boolean ativo;

    public Frete(DadosCadastroFrete dados, Empresa empresa, Entregador proprietario, Veiculo veiculo, double valor) {
        this.nota = dados.nota();
        this.produto = dados.produto();
        this.descricao = dados.descricao();
        this.solicitante = empresa;
        this.motorista = proprietario;
        this.veiculo = veiculo;
        this.status = dados.status();
        this.km = dados.km();
        this.valor = valor;
    }
    public void atualizarInformacoes(DadosAtualizacaoFrete dados, Empresa empresa, Entregador proprietario, Veiculo veiculo, double valor) {

        if(dados.nota() != null){
            this.nota = dados.nota();
        }
        if(dados.produto() != null){
            this.produto = dados.produto();
        }
        if(dados.descricao() != null){
            this.descricao= dados.descricao();
        }
        if(empresa != null){
            this.solicitante = empresa;
        }
        if(proprietario != null){
            this.motorista = proprietario;
        }
        if(veiculo!= null){
            this.veiculo = veiculo;
        }
        if(dados.status()!= null){
            this.status = dados.status();
        }
        if(dados.km() != null){
            this.km = dados.km();
        }
        this.valor = valor;

    }


    public void excluir() {
        this.ativo=false;
    }

    public void alterarStatus(Status status){
        this.status = status;
    }


}
