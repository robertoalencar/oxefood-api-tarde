package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class EntregadorService extends GenericService {
    
    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        super.preencherCamposAuditoria(entregador);
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos() {
  
        return repository.findAll();
    }
 
    public Entregador obterPorID(Long id) {
 
        return repository.findById(id).get();
    }
}
