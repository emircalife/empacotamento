package br.com.calife.empacotamento.domain.entity.DTO;

import br.com.calife.empacotamento.domain.entity.Pedido;
import br.com.calife.empacotamento.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoDTO {

    private Integer pedido_id;

    private Produto produto;

    private CaixaDTO caixaDTO;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.pedido_id = pedido.getPedido_id();
        this.produto = pedido.getProduto();
        this.caixaDTO = new CaixaDTO();
    }

}
