package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EntregadorRepository;
import br.com.gestao.entregas.Repositories.VeiculoRepository;
import br.com.gestao.entregas.entities.entregador.Entregador;
import br.com.gestao.entregas.entities.veiculo.DadosAtualizacaoVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosCadastroVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosListagemVeiculo;
import br.com.gestao.entregas.entities.veiculo.Veiculo;
import br.com.gestao.entregas.infra.exception.TratadorDeErros;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
        Entregador entregador = entregadorOptional.orElse(null);

        if(entregador != null){
            Veiculo veiculo = new Veiculo(dados, entregador);
            repository.save(veiculo);
        }else{
            throw new EntityNotFoundException("Entregador não encontrado para o ID: " + proprietarioId);
        }


    }
    public void alterar(DadosAtualizacaoVeiculo dados){
        Long proprietarioId = dados.idProprietario();
        Entregador proprietario = entregadorRepository.getReferenceById(proprietarioId);

        Veiculo veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizarInformacoes(dados, proprietario);
    }

    public void Deletetar(Long id){
       repository.deleteById(id);
    }
}

