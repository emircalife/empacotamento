package br.com.calife.empacotamento.domain.service;

import br.com.calife.empacotamento.domain.entity.Pedido;
import br.com.calife.empacotamento.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    public Pedido findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new EmptyResultDataAccessException(1));
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido create(Pedido obj) {
        return repository.save(obj);
    }

    public Pedido update(Pedido obj) {
        Pedido objSaved = findById(obj.getPedido_id());

        return repository.save(objSaved);
    }

    public void delete(Integer id) {
        Pedido objSaved = findById(id);
        repository.delete(objSaved);
    }

}