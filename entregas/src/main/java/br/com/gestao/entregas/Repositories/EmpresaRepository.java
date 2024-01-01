package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.empresa.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Page<Empresa> findAllByAtivoTrue (Pageable paginacao);
}
