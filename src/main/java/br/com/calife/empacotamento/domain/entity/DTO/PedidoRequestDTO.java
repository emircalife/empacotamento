package br.com.calife.empacotamento.domain.entity.DTO;

import br.com.calife.empacotamento.domain.entity.Dimensao;
import br.com.calife.empacotamento.domain.entity.Pedido;
import br.com.calife.empacotamento.domain.entity.Produto;
import br.com.calife.empacotamento.domain.service.DimensaoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pedido_id;

    private List<PedidoDTO> pedidosDTO;

    private List<Produto> produtos;

    private Dimensao dimensao;

    @Autowired
    private DimensaoService dimensoesService;

    public PedidoRequestDTO() {
        super();
    }

    public PedidoRequestDTO(Pedido obj) {
        this.pedido_id = obj.getPedido_id();
        this.produtos.add(obj.getProduto());
        this.dimensao = obj.getProduto().getDimensoes();
    }

}
