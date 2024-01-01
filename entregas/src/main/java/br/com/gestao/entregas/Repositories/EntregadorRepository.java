package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.entregador.Entregador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long>{
    Page<Entregador> findAllByAtivoTrue (Pageable paginacao);

    Entregador findByCnh(String cnh);
}
