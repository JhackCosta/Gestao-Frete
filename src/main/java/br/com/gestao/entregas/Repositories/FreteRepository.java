package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.frete.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
    boolean existsByNota(String nota);

    @Query("SELECT f FROM Frete f WHERE UPPER(f.status) LIKE UPPER(CONCAT('%', :status, '%'))")
    List<Frete> findByStatus(String status);

/*    @Query("SELECT * FROM Frete f WHERE UPPER(f.STATUS) LIKE UPPER('%PENDENTE%')")
    List<Frete> findStatusPendente();

    @Query("SELECT * FROM Frete f WHERE UPPER(f.STATUS) LIKE UPPER('%ACEITO%')")
    List<Frete> findStatusAceito();

    @Query("SELECT * FROM Frete f WHERE UPPER(f.STATUS) LIKE UPPER('%REALIZANDO%')")
    List<Frete> findStatusRealizando();

    @Query("SELECT * FROM Frete f WHERE UPPER(f.STATUS) LIKE UPPER('%FINALIZADO%')")
    List<Frete> findStatusFinalizando(); */
}
