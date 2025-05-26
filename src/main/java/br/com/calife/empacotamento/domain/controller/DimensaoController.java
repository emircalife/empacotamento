package br.com.calife.empacotamento.domain.controller;

import br.com.calife.empacotamento.domain.documentation.DimensaoDocumentation;
import br.com.calife.empacotamento.domain.entity.Dimensao;
import br.com.calife.empacotamento.domain.service.DimensaoService;
import br.com.calife.empacotamento.config.Constants;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Constants.CONTROLLER.DIMENSAO.BASE_URL)
public class DimensaoController implements DimensaoDocumentation {
    @Autowired
    private DimensaoService service;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Dimensao> findById(@PathVariable("id") Integer id) {
        Dimensao obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @GetMapping
    public List<Dimensao> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Dimensao> create(@RequestBody Dimensao obj) {
        Dimensao objSaved = service.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objSaved);
    }

    @PutMapping
    public ResponseEntity<Dimensao> update(@RequestBody Dimensao obj) {
        Dimensao objSaved = service.update(obj);
        return ResponseEntity.ok(objSaved);
    }
}