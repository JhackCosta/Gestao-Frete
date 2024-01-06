package br.com.gestao.entregas.Controller;

import br.com.gestao.entregas.Services.FreteService;
import br.com.gestao.entregas.entities.frete.DadosAtualizacaoFrete;
import br.com.gestao.entregas.entities.frete.DadosCadastroFrete;
import br.com.gestao.entregas.entities.frete.DadosListagemFrete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(value = "/frete", produces = {"application/json"})
@Tag(name = "Controle_fretes")
public class FreteController {

    @Autowired
    private FreteService service;

    @Operation(summary = "lista de Fretes", method = "GET")
    @GetMapping("/listAll")
    public ResponseEntity<Page<DadosListagemFrete>> GetAll(@PageableDefault(size = 10, sort = "id") Pageable paginacao){
        Page<DadosListagemFrete> page = service.buscarAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Buscar frete por id", method = "GET")
    @GetMapping("/id={id}")
    public ResponseEntity<DadosListagemFrete> Get(@PathVariable Long id){
        Optional<DadosListagemFrete> frete = service.buscar(id);

        if (frete.isPresent()) {
            return ResponseEntity.ok(frete.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastro de frete", method = "POST")
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> Post(@RequestBody @Valid DadosCadastroFrete frete) {
        service.adicionar(frete);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @Operation(summary = "alterar frete", method = "PUT")
    @PutMapping("/alterar")
    @Transactional
    public void Put(@RequestBody @Valid DadosAtualizacaoFrete dados){
        service.alterar(dados);
        ResponseEntity.ok();
    }

    @Operation(summary = "Deletar veiculo por id", method = "DELETE")
    @DeleteMapping("/id={id}")
    @Transactional
    public ResponseEntity<Object> Delete(@PathVariable Long id){
        service.deletetar(id);
        return ResponseEntity.noContent().build();
    }

}
