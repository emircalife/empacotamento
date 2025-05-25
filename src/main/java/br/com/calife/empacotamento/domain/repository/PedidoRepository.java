package br.com.calife.empacotamento.domain.repository;

import br.com.calife.empacotamento.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
