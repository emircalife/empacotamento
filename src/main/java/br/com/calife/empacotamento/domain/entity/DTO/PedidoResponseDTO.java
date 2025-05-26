package br.com.calife.empacotamento.domain.entity.DTO;

import br.com.calife.empacotamento.domain.entity.Caixa;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pedido_id;

    private List<Caixa> caixas;

    private String observacao;

    private String produtos;

    public PedidoResponseDTO() {
        super();
    }

    public PedidoResponseDTO(PedidoResponseDTO obj) {
        this.pedido_id = obj.getPedido_id();
        this.observacao = obj.getObservacao();
        this.caixas = obj.getCaixas();
        this.produtos = obj.getProdutos();
    }

}
