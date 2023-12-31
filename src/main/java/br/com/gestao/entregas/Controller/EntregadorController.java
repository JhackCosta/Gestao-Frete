package br.com.gestao.entregas.Controller;

import br.com.gestao.entregas.Services.EntregadorService;
import br.com.gestao.entregas.entities.entregador.DadosAtualizacaoEntregador;
import br.com.gestao.entregas.entities.entregador.DadosCadastroEntregador;
import br.com.gestao.entregas.entities.entregador.DadosListagemEntregador;
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
@RequestMapping(value = "/entregador", produces = {"application/json"})
@Tag(name = "Controle_Entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @Operation(summary = "lista de entregadores", method = "GET")
    @GetMapping("/listAll")
    public ResponseEntity<Page<DadosListagemEntregador>> GetAll(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        Page<DadosListagemEntregador> page = service.buscarAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Buscar entregadores por id", method = "GET")
    @GetMapping("/id={id}")
    public ResponseEntity<DadosListagemEntregador> Get(@PathVariable Long id){
        Optional<DadosListagemEntregador> entregador = service.buscar(id);

        if (entregador.isPresent()) {
            return ResponseEntity.ok(entregador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastro de entregador", method = "POST")
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> Post(@RequestBody @Valid DadosCadastroEntregador entregador){
            service.adicionar(entregador);
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @Operation(summary = "alterar entregador", method = "PUT")
    @PutMapping("/alterar")
    @Transactional
    public void Put(@RequestBody @Valid DadosAtualizacaoEntregador dados){
        service.alterar(dados);
        ResponseEntity.ok();
    }

    @Operation(summary = "Deletar entregador por id", method = "DELETE")
    @DeleteMapping("/id={id}")
    @Transactional
    public ResponseEntity<Object> Delete(@PathVariable Long id){
        service.deletetar(id);
        return ResponseEntity.noContent().build();
    }



}
