package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/entregador")
public class EntregadorController extends GenericController {
    
    @Autowired
    private EntregadorService entregadorService;

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody @Valid EntregadorRequest request) {

        Entregador entregadorNovo = request.build();
        Entregador entregador = entregadorService.save(entregadorNovo);
        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Entregador> listarTodos() {
  
       return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {

       return entregadorService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

        entregadorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

}
