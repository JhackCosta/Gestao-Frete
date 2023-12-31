package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EntregadorRepository;
import br.com.gestao.entregas.entities.Entregador.DadosAtualizacaoEntregador;
import br.com.gestao.entregas.entities.Entregador.DadosCadastroEntregador;
import br.com.gestao.entregas.entities.Entregador.DadosListagemEntregador;
import br.com.gestao.entregas.entities.Entregador.Entregador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    public Page<DadosListagemEntregador> BuscarAll(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemEntregador::new);
    }

    public Optional<DadosListagemEntregador> Buscar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id).map(DadosListagemEntregador::new);
    }

    public void Adicionar(DadosCadastroEntregador dados){

        Entregador entregador = new Entregador(dados);
        repository.save(entregador);
    }

    public void alterar(DadosAtualizacaoEntregador dados){
        Entregador entregador = repository.getReferenceById(dados.id());
        entregador.atualizarInformacoes(dados);
    }

    public void Deletetar(Long id){
        Entregador entregador = repository.getReferenceById(id);
        entregador.excluir();
    }

}
