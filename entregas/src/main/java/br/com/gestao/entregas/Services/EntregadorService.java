package br.com.gestao.entregas.Services;

import br.com.gestao.entregas.Repositories.EntregadorRepository;
import br.com.gestao.entregas.entities.Entregador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregadorService {

    @Autowired
    EntregadorRepository repository;

    public List<Entregador> BuscarAll(){
        return repository.findAll();
    }

    public Optional<Entregador> Buscar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        return repository.findById(id);
    }

    public void Adicionar(Entregador entregador){
        repository.save(entregador);
    }

    public void Deletetar(Long id){
        repository.deleteById(id);
    }

    public void alterar(){}

}
