package br.com.gestao.entregas.Controller;


import br.com.gestao.entregas.Services.EmpresaService;
import br.com.gestao.entregas.entities.empresa.DadosAtualizacaoEmpresa;
import br.com.gestao.entregas.entities.empresa.DadosCadastroEmpresa;
import br.com.gestao.entregas.entities.empresa.DadosListagemEmpresa;
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
@RequestMapping(value = "/empresa", produces = {"application/json"})
@Tag(name = "Controle_Empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @Operation(summary = "lista de empresas", method = "GET")
    @GetMapping("/listAll")
    public ResponseEntity<Page<DadosListagemEmpresa>> GetAll(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        Page<DadosListagemEmpresa> page = service.BuscarAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Buscar empresa por id", method = "GET")
    @GetMapping("/id={id}")
    public ResponseEntity<DadosListagemEmpresa> Get(@PathVariable Long id){
        Optional<DadosListagemEmpresa> empresa = service.Buscar(id);

        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastro de empresa", method = "POST")
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<HttpStatus> Post(@RequestBody @Valid DadosCadastroEmpresa empresa){
        service.Adicionar(empresa);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);

    }

    @Operation(summary = "alterar empresa", method = "PUT")
    @PutMapping("/alterar")
    public void Put(@RequestBody @Valid DadosAtualizacaoEmpresa dados){
        service.alterar(dados);
        ResponseEntity.ok();
    }

    @Operation(summary = "Deletar empresa por id", method = "DELETE")
    @DeleteMapping("/id={id}")
    @Transactional
    public ResponseEntity<Object> Delete(@PathVariable Long id){
        service.Deletetar(id);
        return ResponseEntity.noContent().build();
    }


}
