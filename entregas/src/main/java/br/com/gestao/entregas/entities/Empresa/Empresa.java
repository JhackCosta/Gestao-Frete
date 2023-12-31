package br.com.gestao.entregas.entities.Empresa;

import br.com.gestao.entregas.entities.Entregador.DadosAtualizacaoEntregador;
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

    public Empresa(DadosCadastroEmpresa dados) {
        super(dados.nome(), dados.email(), dados.contato());
        this.cnpj = dados.cnpj();
    }

    public void atualizarInformacoes(DadosAtualizacaoEmpresa dados) {

        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }
        if (dados.email() != null){
            super.setEmail(dados.email());
        }
        if (dados.contato() != null){
            super.setContato(dados.contato());
        }
        if(dados.cnpj() != null){
            this.cnpj = dados.cnpj();
        }
        if(dados.ativo() != null) {
            super.setAtivo(dados.ativo());
        }

    }

    public void excluir() {
        super.setAtivo(false);
    }
}
