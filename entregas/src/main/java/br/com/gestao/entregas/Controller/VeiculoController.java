package br.com.gestao.entregas.Controller;

import br.com.gestao.entregas.Services.VeiculoService;
import br.com.gestao.entregas.entities.veiculo.DadosAtualizacaoVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosCadastroVeiculo;
import br.com.gestao.entregas.entities.veiculo.DadosListagemVeiculo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/veiculo", produces = {"application/json"})
@Tag(name = "Controle_veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService service;

    @Operation(summary = "lista de veiculos", method = "GET")
    @GetMapping("/listAll")
    public ResponseEntity<Page<DadosListagemVeiculo>> GetAll(@PageableDefault(size = 10, sort = "marca") Pageable paginacao){
        Page<DadosListagemVeiculo> page = service.BuscarAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Buscar veiculo por id", method = "GET")
    @GetMapping("/id={id}")
    public ResponseEntity<DadosListagemVeiculo> Get(@PathVariable Long id){
        Optional<DadosListagemVeiculo> entregador = service.Buscar(id);

        if (entregador.isPresent()) {
            return ResponseEntity.ok(entregador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastro de veiculo", method = "POST")
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> Post(@RequestBody @Valid DadosCadastroVeiculo veiculo) {
        service.Adicionar(veiculo);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @Operation(summary = "alterar veiculo", method = "PUT")
    @PutMapping("/alterar")
    @Transactional
    public void Put(@RequestBody @Valid DadosAtualizacaoVeiculo dados){
        service.alterar(dados);
        ResponseEntity.ok();
    }

    @Operation(summary = "Deletar veiculo por id", method = "DELETE")
    @DeleteMapping("/id={id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id){
        service.Deletetar(id);
        return ResponseEntity.noContent().build();
    }

}
