package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.frete.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
    boolean existsByNota(String nota);

    boolean existsBySolicitante(Long solicitante);

    boolean existsByEntregador(Long entregador);
}
