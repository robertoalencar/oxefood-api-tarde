package br.com.ifpe.oxefood.api.comprador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.comprador.CompradorService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController extends GenericController {

    @Autowired
    private CompradorService compradorService;

    @PostMapping
    public ResponseEntity<Comprador> save(@RequestBody @Valid CompradorRequest request) {

        Comprador compradorNovo = request.build();
        Comprador comprador = compradorService.save(compradorNovo);
        return new ResponseEntity<Comprador>(comprador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Comprador> listarTodos() {
  
       return compradorService.listarTodos();
    }

}
