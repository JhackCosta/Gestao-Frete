package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    boolean existsByPlaca(String placa);

    @Query("SELECT v.peso FROM Veiculo v WHERE v.id = :proprietarioId")
    int findPesoById(@Param("proprietarioId") Long proprietarioId);


}
