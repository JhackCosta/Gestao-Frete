package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EntregadorRepository;
import br.com.gestao.entregas.Repositories.VeiculoRepository;
import br.com.gestao.entregas.entities.entregador.Entregador;
import br.com.gestao.entregas.entities.veiculo.DadosAtualizacaoVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosCadastroVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosListagemVeiculo;
import br.com.gestao.entregas.entities.veiculo.Veiculo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private EntregadorRepository entregadorRepository;

    public Page<DadosListagemVeiculo> BuscarAll(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemVeiculo::new);
    }
    public Optional<DadosListagemVeiculo> Buscar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id).map(DadosListagemVeiculo::new);
    }
    public void Adicionar(DadosCadastroVeiculo dados) {
        Long proprietarioId = dados.idProprietario();
        Optional<Entregador> entregadorOptional = entregadorRepository.findById(dados.idProprietario());
        Entregador proprietario = entregadorOptional.orElse(null);

        if(proprietario == null) {
            throw new EntityNotFoundException("Entregador não encontrado para o ID: " + proprietarioId);
        }

        if (repository.existsByPlaca(dados.placa())) {
            throw new DataIntegrityViolationException("Veiculo com a placa: " + dados.placa() + " ja cadastrado");
        }

        Veiculo veiculo = new Veiculo(dados, proprietario);
        repository.save(veiculo);

    }
    public void alterar(DadosAtualizacaoVeiculo dados){
        Long proprietarioId = dados.idProprietario();
        Optional<Entregador> entregadorOptional = entregadorRepository.findById(dados.idProprietario());
        Entregador proprietario = entregadorOptional.orElse(null);

        if(proprietario == null){
            throw new EntityNotFoundException("Entregador não encontrado para o ID: " + proprietarioId);
        }

        if (repository.existsByPlaca(dados.placa())) {
            throw new DataIntegrityViolationException("Veiculo com a placa: " + dados.placa() + " ja cadastrado");
        }

        Veiculo veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizarInformacoes(dados, proprietario);
    }

    public void Deletetar(Long id){
       repository.deleteById(id);
    }
}

