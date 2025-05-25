package br.com.calife.empacotamento.domain.entity.DTO;

import br.com.calife.empacotamento.domain.entity.Caixa;
import br.com.calife.empacotamento.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaixaDTO {
    private Integer caixa_id;

    private Caixa caixa;

    private Produto produto;

    public CaixaDTO() {

    }
}
