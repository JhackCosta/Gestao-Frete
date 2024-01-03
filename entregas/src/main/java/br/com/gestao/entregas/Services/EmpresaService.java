package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EmpresaRepository;
import br.com.gestao.entregas.entities.empresa.DadosAtualizacaoEmpresa;
import br.com.gestao.entregas.entities.empresa.DadosCadastroEmpresa;
import br.com.gestao.entregas.entities.empresa.DadosListagemEmpresa;
import br.com.gestao.entregas.entities.empresa.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public Page<DadosListagemEmpresa> BuscarAll(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemEmpresa::new);
    }

    public Optional<DadosListagemEmpresa> Buscar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id).map(DadosListagemEmpresa::new);
    }

    public void Adicionar(DadosCadastroEmpresa dados){

        this.verificaCampos(dados.nome(), dados.cnpj());

        Empresa empresa = new Empresa(dados);
        repository.save(empresa);
    }
    public void alterar(DadosAtualizacaoEmpresa dados){

        this.verificaCampos(dados.nome(), dados.cnpj());

        Empresa empresa = repository.getReferenceById(dados.id());
        empresa.atualizarInformacoes(dados);
    }

    public void Deletetar(Long id){
        Empresa empresa = repository.getReferenceById(id);
        empresa.excluir();
    }


    public void verificaCampos(String nome, String cnpj){
        if (repository.existsByNome(nome)) {
            throw new DataIntegrityViolationException("Empresa com este nome: " + nome + " ja cadastrado");
        }
        if (repository.existsByCnpj(cnpj)) {
            throw new DataIntegrityViolationException("Empresa com este CNPJ: " + cnpj + " ja cadastrado");
        }
    }


}
