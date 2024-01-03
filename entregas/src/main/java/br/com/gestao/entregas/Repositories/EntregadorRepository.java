package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.entregador.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long>{

    Entregador findByCnh(String cnh);
    boolean existsByCnh(String cnh);
    boolean existsByNome(String nome);
}
