package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EntregadorRepository;
import br.com.gestao.entregas.entities.entregador.DadosAtualizacaoEntregador;
import br.com.gestao.entregas.entities.entregador.DadosCadastroEntregador;
import br.com.gestao.entregas.entities.entregador.DadosListagemEntregador;
import br.com.gestao.entregas.entities.entregador.Entregador;
import br.com.gestao.entregas.infra.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    public Page<DadosListagemEntregador> buscarAll(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemEntregador::new);
    }

    public Optional<DadosListagemEntregador> buscar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id).map(DadosListagemEntregador::new);
    }

    public void adicionar(DadosCadastroEntregador dados){

        this.verificaCampos(dados.nome(), dados.cnh());

        Entregador entregador = new Entregador(dados);
        repository.save(entregador);
    }

    public void alterar(DadosAtualizacaoEntregador dados){

        this.verificaCampos(dados.nome(), dados.cnh());

        Entregador entregador = repository.getReferenceById(dados.id());
        entregador.atualizarInformacoes(dados);
    }

    public void deletetar(Long id){
        Entregador entregador = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entregador não encontrado para o ID: " + id));

        entregador.excluir();
    }

    public void verificaCampos(String nome, String cnh){
        if (repository.existsByNome(nome)) {
            throw new DataIntegrityViolationException("Entregador com este nome: " + nome + " ja cadastrado");
        }
        if (repository.existsByCnh(cnh)) {
            throw new DataIntegrityViolationException("Entregador com esta CNH: " + cnh + " ja cadastrado");
        }
    }

}
