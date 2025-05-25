package br.com.calife.empacotamento.domain.service;

import br.com.calife.empacotamento.core.exception.GenericException;
import br.com.calife.empacotamento.domain.entity.Dimensao;
import br.com.calife.empacotamento.domain.repository.DimensaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DimensaoService {

    private final DimensaoRepository repository;

    public Dimensao findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new GenericException("Dimensão não encontrada"));

    }

    public Dimensao findByDescricao(String descricao) {
        return repository.findByDescricao(descricao).orElseThrow(() ->
                new GenericException("Dimensão não encontrada"));
    }

    public List<Dimensao> findAll() {
        return repository.findAll();
    }

    public Dimensao create(Dimensao obj) {
        return repository.save(obj);
    }

    public Dimensao update(Dimensao obj) {
        Dimensao objSaved = findById(obj.getDimensao_id());

        return repository.save(objSaved);
    }

    public void delete(Integer id) {
        Dimensao objSaved = findById(id);
        repository.delete(objSaved);
    }

}