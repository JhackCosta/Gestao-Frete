package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EmpresaRepository;
import br.com.gestao.entregas.Repositories.EntregadorRepository;
import br.com.gestao.entregas.Repositories.FreteRepository;
import br.com.gestao.entregas.Repositories.VeiculoRepository;
import br.com.gestao.entregas.entities.empresa.Empresa;
import br.com.gestao.entregas.entities.entregador.Entregador;
import br.com.gestao.entregas.entities.frete.*;
import br.com.gestao.entregas.entities.veiculo.Veiculo;
import br.com.gestao.entregas.infra.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FreteService {

    @Autowired
    private FreteRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Page<DadosListagemFrete> buscarAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemFrete::new);
    }

    public List<DadosListagemFrete> buscarStatus(String status) {
        return repository.findByStatus(status).stream().map(DadosListagemFrete::new).collect(Collectors.toList());
    }

    public Optional<DadosListagemFrete> buscar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id).map(DadosListagemFrete::new);
    }

    public void adicionar(DadosCadastroFrete dados) {

        this.verificaCampos(dados.nota(), dados.solicitante(), dados.entregador(), dados.veiculo());

        Optional<Empresa> empresaOptional = empresaRepository.findById(dados.solicitante());
        Optional<Entregador> entregadorOptional = entregadorRepository.findById(dados.entregador());
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(dados.veiculo());

        Empresa empresa = empresaOptional.orElse(null);
        Entregador proprietario = entregadorOptional.orElse(null);
        Veiculo veiculo = veiculoOptional.orElse(null);

        int peso = veiculoRepository.findPesoById(dados.veiculo());

        double valor = this.calculorValorTotalFrete(dados.km(),peso);

        Frete frete = new Frete(dados, empresa, proprietario, veiculo, valor);
        repository.save(frete);
    }

    public void alterar(DadosAtualizacaoFrete dados) {

        this.verificaCampos(dados.nota(), dados.solicitante(), dados.entregador(), dados.veiculo());

        Optional<Empresa> empresaOptional = empresaRepository.findById(dados.solicitante());
        Optional<Entregador> entregadorOptional = entregadorRepository.findById(dados.entregador());
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(dados.veiculo());

        Empresa empresa = empresaOptional.orElse(null);
        Entregador proprietario = entregadorOptional.orElse(null);
        Veiculo veiculo = veiculoOptional.orElse(null);

        int peso = veiculoRepository.findPesoById(dados.veiculo());
        double valor = this.calculorValorTotalFrete(dados.km(),peso);

        Frete frete = repository.getReferenceById(dados.id());
        frete.atualizarInformacoes(dados, empresa, proprietario, veiculo, valor);
    }

    public void alterarStatus(Long id, Status status){
        Frete frete = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Frete não encontrado para o ID: " + id));

        frete.alterarStatus(status);
    }

    public void deletetar(Long id) {
        Frete frete = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Frete não encontrado para o ID: " + id));

        frete.excluir();
    }

    public void verificaCampos(String nota, Long solicitante, Long entregador, Long veiculo) {
        if (repository.existsByNota(nota)) {
            throw new DataIntegrityViolationException("Frete com esta nota fiscal: " + nota + " ja cadastrado");
        }
        if (!empresaRepository.existsById(solicitante)) {
            throw new DataIntegrityViolationException("ID Solicitante: " + solicitante + " nao existe ");
        }
        if (!entregadorRepository.existsById(entregador)) {
            throw new DataIntegrityViolationException("ID Entregador " + entregador + " nao existe");
        }
        if (!veiculoRepository.existsById(entregador)) {
            throw new DataIntegrityViolationException("ID Veiculo " + veiculo + " nao existe");
        }
    }

    private double calculorValorTotalFrete(double km, int peso) {

        double taxaFixa = this.calcularTaxaFixa(km);

        double valorTaxa = (km * peso)*taxaFixa;

        return (km * peso)-valorTaxa;
    }

    private Double calcularTaxaFixa(double km) {
        if (km <= 100.0) {
            return 0.20;
        } else if (km <= 200.0) {
            return 0.15;
        } else if (km <= 500.0) {
            return 0.10;
        } else {
            return 0.075;
        }
    }
}