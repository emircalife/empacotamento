package br.com.calife.empacotamento.domain.repository;

import br.com.calife.empacotamento.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
