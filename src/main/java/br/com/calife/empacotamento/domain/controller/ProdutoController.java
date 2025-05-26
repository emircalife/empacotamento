package br.com.calife.empacotamento.domain.controller;

import br.com.calife.empacotamento.config.Constants;
import br.com.calife.empacotamento.domain.documentation.ProdutoDocumentation;
import br.com.calife.empacotamento.domain.entity.Produto;
import br.com.calife.empacotamento.domain.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Constants.CONTROLLER.PRODUTO.BASE_URL)
public class ProdutoController implements ProdutoDocumentation {
    @Autowired
    private ProdutoService service;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable("id") Integer id) {
        Produto obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @GetMapping
    public List<Produto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto obj) {
        Produto objSaved = service.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objSaved);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto obj) {
        Produto objFind = service.findById(obj.getId());
        if (objFind == null) {
            return ResponseEntity.notFound().build();
        }
        Produto objSaved = service.update(obj);

        return ResponseEntity.ok(objSaved);
    }
}