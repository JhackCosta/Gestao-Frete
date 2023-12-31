package br.com.gestao.entregas.entities.Entregador;

import br.com.gestao.entregas.entities.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Entregador")
@Table(name = "Entregador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorValue("entregador")
public class Entregador extends Usuario {

    @Column(name = "CNH", unique = true)
    private String cnh;

    @Column(name = "Categoria-CNH")
    private String categoria;

    @Column(name = "Realizando-Entrega")
    private boolean realizandoEntrega = false;

    public Entregador(DadosCadastroEntregador dados) {
        super(dados.nome(), dados.email(), dados.contato());
        this.cnh = dados.cnh();
        this.categoria = dados.categoria();
    }

    public void atualizarInformacoes(DadosAtualizacaoEntregador dados) {

        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }
        if (dados.email() != null){
            super.setEmail(dados.email());
        }
        if (dados.contato() != null){
            super.setContato(dados.contato());
        }
        if(dados.cnh() != null){
            this.cnh = dados.cnh();
        }
        if(dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if(dados.ativo() != null) {
            super.setAtivo(dados.ativo());
        }
        if(dados.realizandoEntrega() != null) {
            alterarStatusFrete(dados.realizandoEntrega());
        }
    }

    public void alterarStatusFrete(Boolean step){
        this.realizandoEntrega = step;
    }

    public void excluir() {
        super.setAtivo(false);
    }

}
