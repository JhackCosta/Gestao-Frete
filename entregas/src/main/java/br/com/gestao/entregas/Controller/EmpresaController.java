package br.com.gestao.entregas.Controller;


import br.com.gestao.entregas.Services.EmpresaService;
import br.com.gestao.entregas.entities.Empresa.Empresa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/empresa", produces = {"application/json"})
@Tag(name = "Controle-Empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @Operation(summary = "lista de empresas", method = "GET")
    @GetMapping("/listAll")
    public List<Empresa> GetAll(){
        return service.BuscarAll();
    }

    @Operation(summary = "Buscar empresa por id", method = "GET")
    @GetMapping("/id={id}")
    public ResponseEntity<Empresa> Get(@PathVariable Long id){
        Optional<Empresa> empresa = service.Buscar(id);

        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastro de empresa", method = "POST")
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<Object> Post(@RequestBody Empresa empresa){

        service.Adicionar(empresa);
       return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Operation(summary = "Deletar empresa por id", method = "DELETE")
    @DeleteMapping("/id={id}")
    public void Delete(@PathVariable Long id){
        service.Deletetar(id);
    }

    @Operation(summary = "alterar empresa", method = "PUT")
    @PutMapping("/alterar")
    public void Put(){}
}
