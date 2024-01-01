package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.VeiculoRepository;
import br.com.gestao.entregas.entities.veiculo.DadosAtualizacaoVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosCadastroVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosListagemVeiculo;
import br.com.gestao.entregas.entities.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public Page<DadosListagemVeiculo> BuscarAll(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemVeiculo::new);
    }

    public Optional<DadosListagemVeiculo> Buscar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id).map(DadosListagemVeiculo::new);
    }

    public void Adicionar(DadosCadastroVeiculo dados){
        Veiculo veiculo = new Veiculo(dados);
        repository.save(veiculo);
    }
    public void alterar(DadosAtualizacaoVeiculo dados){
        Veiculo veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizarInformacoes(dados);
    }

    public void Deletetar(Long id){
       repository.deleteById(id);
    }
}

