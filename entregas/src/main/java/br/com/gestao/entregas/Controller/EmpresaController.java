package br.com.gestao.entregas.Controller;


import br.com.gestao.entregas.Services.EmpresaService;
import br.com.gestao.entregas.entities.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService service;

    @GetMapping("/listAll")
    public List<Empresa> GetAll(){
        return service.BuscarAll();
    }

    @GetMapping("/id={id}")
    public Optional<Empresa> Get(@PathVariable Long id){
        return service.Buscar(id);
    }

    @PostMapping("/criar")
    public void Post(@RequestBody Empresa empresa){
        service.Adicionar(empresa);
    }

    @DeleteMapping("/id={id}")
    public void Delete(@PathVariable Long id){
        service.Deletetar(id);
    }

    @PutMapping("/alterar")
    public void Put(){}
}
