package br.com.calife.empacotamento.domain.controller;

import br.com.calife.empacotamento.domain.documentation.PedidoDocumentation;
import br.com.calife.empacotamento.domain.entity.Pedido;
import br.com.calife.empacotamento.domain.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Pedidos")
public class PedidoController implements PedidoDocumentation {
    @Autowired
    private PedidoService service;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable("id") Integer id) {
        Pedido obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido obj) {
        Pedido objSaved = service.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objSaved);
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody Pedido obj) {
        Pedido objSaved = service.update(obj);
        return ResponseEntity.ok(objSaved);
    }
}