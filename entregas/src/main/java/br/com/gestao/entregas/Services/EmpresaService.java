package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EmpresaRepository;
import br.com.gestao.entregas.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository repository;

    public List<Empresa> BuscarAll(){
        return repository.findAll();
    }

    public Optional<Empresa> Buscar(Long id){
        return repository.findById(id);
    }

    public void Adicionar(Empresa empresa){
        repository.save(empresa);
    }

    public void Deletetar(Long id){
        repository.deleteById(id);
    }

    public void alterar(){}
}
