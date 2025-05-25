package br.com.calife.empacotamento.domain.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoDTO {

    private Integer pedido_id;

    private CaixaDTO caixaDTO;

    public PedidoDTO() {

    }

}
