package br.com.gestao.entregas.Repositories;

import br.com.gestao.entregas.entities.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    boolean existsByCnpj(String cnpj);

    boolean existsByNome(String nome);
}
