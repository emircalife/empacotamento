package br.com.calife.empacotamento.domain.service;

import br.com.calife.empacotamento.core.exception.GenericException;
import br.com.calife.empacotamento.domain.entity.Produto;
import br.com.calife.empacotamento.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;


    public Produto findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new GenericException("Produto não encontrado"));
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto create(Produto obj) {
        return repository.save(obj);
    }

    public Produto update(Produto obj) {
        Produto objSaved = findById(obj.getProduto_id());

//        BeanUtils.copyProperties(obj, objSaved, "produto_id");

        return repository.save(objSaved);
    }

    public void delete(Integer id) {
        Produto objSaved = findById(id);
        repository.delete(objSaved);
    }
}