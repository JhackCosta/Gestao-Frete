package br.com.gestao.entregas.Controller;

import br.com.gestao.entregas.Services.EntregadorService;
import br.com.gestao.entregas.entities.Entregador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/entregador", produces = {"application/json"})
@Tag(name = "Controle-Entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @Operation(summary = "lista de entregadores", method = "GET")
    @GetMapping("/listAll")
    public List<Entregador> GetAll(){
        return service.BuscarAll();
    }

    @Operation(summary = "Buscar entregadores por id", method = "GET")
    @GetMapping("/id={id}")
    public ResponseEntity<Entregador> Get(@PathVariable Long id){
        Optional<Entregador> entregador = service.Buscar(id);

        if (entregador.isPresent()) {
            return ResponseEntity.ok(entregador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastro de entregador", method = "POST")
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void Post(@RequestBody Entregador entregador){
        service.Adicionar(entregador);
    }

    @Operation(summary = "Deletar entregador por id", method = "DELETE")
    @DeleteMapping("/id={id}")
    public void Delete(@PathVariable Long id){
        service.Deletetar(id);
    }

    @Operation(summary = "alterar entregador", method = "PUT")
    @PutMapping("/alterar")
    public void Put(){}

}
