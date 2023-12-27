package br.com.gestao.entregas.Controller;

import br.com.gestao.entregas.Services.EntregadorService;
import br.com.gestao.entregas.entities.Entregador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregador")
public class EntregadorController {

    private EntregadorService service;

    @GetMapping("/listAll")
    public List<Entregador> GetAll(){
        return service.BuscarAll();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Entregador> Get(@PathVariable Long id){
        Optional<Entregador> entregador = service.Buscar(id);

        if (entregador.isPresent()) {
            return ResponseEntity.ok(entregador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    public void Post(@RequestBody Entregador entregador){
        service.Adicionar(entregador);
    }

    @DeleteMapping("/id={id}")
    public void Delete(@PathVariable Long id){
        service.Deletetar(id);
    }

    @PutMapping("/alterar")
    public void Put(){}

}
