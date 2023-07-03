package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.ProdutoException;

@Service
public class ProdutoService extends GenericService {
    
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {

        if (produto.getValorUnitario() < 10) {
	        throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
	    }

        super.preencherCamposAuditoria(produto);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return repository.findAll();
    }
 
    public Produto obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
        
        super.preencherCamposAuditoria(produto);
        repository.save(produto);
    }

    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

       List<Produto> listaProdutos = repository.findAll();

       if ((codigo != null && !"".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria == null)) {
            
            listaProdutos = repository.consultarPorCodigo(codigo);

       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria == null)) {

            listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);

       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria != null)) {

            listaProdutos = repository.consultarPorCategoria(idCategoria); 

       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria != null)) {

            listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria); 
       }

       return listaProdutos;
}


}
