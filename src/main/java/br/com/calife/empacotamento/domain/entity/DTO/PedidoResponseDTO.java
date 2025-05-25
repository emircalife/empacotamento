package br.com.calife.empacotamento.domain.entity.DTO;

import br.com.calife.empacotamento.domain.entity.Caixa;
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
public class PedidoResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pedido_id;

    private String produtos;

    private String observacao;

    private List<Caixa> caixas;

    @Autowired
    private DimensaoService dimensoesService;

    public PedidoResponseDTO() {
        super();
    }

    public PedidoResponseDTO(PedidoRequestDTO obj) {
        int qtdeProdutos = 0;
        int altura = 0;
        int largura = 0;
        int comprimento = 0;

        if (obj.getPedido_id() != null) {
            this.pedido_id = obj.getPedido_id();

            for (Pedido pedido : obj.getPedidos()) {
                Caixa caixa = new Caixa();

                if(altura > 80 || largura > 80 || comprimento > 80) {
                    caixas.add(caixa);

                    altura = 0;
                    largura = 0;
                    comprimento = 0;
                    qtdeProdutos = 0;
                }

                altura += pedido.getDimensao().getAltura();
                largura += pedido.getDimensao().getLargura();
                comprimento += pedido.getDimensao().getComprimento();
                qtdeProdutos += qtdeProdutos;

                produtos += pedido.getProduto().getNomeProduto() + ", ";

                if(altura <= 30 && largura <= 40 && comprimento <= 80){
                    Dimensao dimensoes = dimensoesService.findByDescricao("Caixa 1");
                    caixa.setCaixa_id(dimensoes.getDimensao_id());
                }else if(altura <= 80 && largura <= 50 && comprimento <= 40){
                    Dimensao dimensoes = dimensoesService.findByDescricao("Caixa 2");
                    caixa.setCaixa_id(dimensoes.getDimensao_id());
                }else if(altura <= 50 && largura <= 80 && comprimento <= 60){
                    Dimensao dimensoes = dimensoesService.findByDescricao("Caixa 3");
                    caixa.setCaixa_id(dimensoes.getDimensao_id());
                }else if(qtdeProdutos == 1){
                    this.observacao = "Produto não cabe em nenhuma caixa disponível.";
                }
            }
        }
    }

}
