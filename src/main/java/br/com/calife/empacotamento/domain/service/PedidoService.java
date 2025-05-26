package br.com.calife.empacotamento.domain.service;

import br.com.calife.empacotamento.domain.entity.Caixa;
import br.com.calife.empacotamento.domain.entity.DTO.PedidoDTO;
import br.com.calife.empacotamento.domain.entity.DTO.PedidoRequestDTO;
import br.com.calife.empacotamento.domain.entity.DTO.PedidoResponseDTO;
import br.com.calife.empacotamento.domain.entity.Dimensao;
import br.com.calife.empacotamento.domain.entity.Pedido;
import br.com.calife.empacotamento.domain.entity.Produto;
import br.com.calife.empacotamento.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository repository;

    private List<Caixa> caixas;

    @Autowired
    private DimensaoService dimensoesService;

    @Autowired
    private ProdutoService produtoService;

    public Pedido findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new EmptyResultDataAccessException(1));
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido create(Pedido obj) {
        return repository.save(obj);
    }

    public Pedido update(Pedido obj) {
        Pedido objSaved = findById(obj.getPedido_id());

        return repository.save(objSaved);
    }

    public void delete(Integer id) {
        Pedido objSaved = findById(id);
        repository.delete(objSaved);
    }

    public List<PedidoResponseDTO> separarPedido(PedidoRequestDTO obj) {
        int altura = 0;
        int largura = 0;
        int comprimento = 0;
        int cntItens = 0;

        Caixa caixa = new Caixa();

        if (obj.getPedido_id() != null) {
            String produtos = "";

            PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
            List<PedidoResponseDTO> lstPedidoResponseDTO = new ArrayList<PedidoResponseDTO>();

            pedidoResponseDTO.setPedido_id(obj.getPedido_id());

            for (PedidoDTO pedido : obj.getPedidosDTO()) {
                for (Produto produto : obj.getProdutos()) {
                    Produto objProduto = produtoService.findById(produto.getId());
                    produtos += objProduto.getProduto_id() + ", ";
                    altura += objProduto.getDimensoes().getAltura();
                    largura += objProduto.getDimensoes().getLargura();
                    comprimento += objProduto.getDimensoes().getComprimento();
                    cntItens++;

                    if (altura > 80 || largura > 80 || comprimento > 80) {
                        altura = 0;
                        largura = 0;
                        comprimento = 0;

                        if (obj.getProdutos().size() == 1) {
                            pedidoResponseDTO.setObservacao("Produto não cabe em nenhuma caixa disponível.");
                        }

                        if (obj.getProdutos().size() == cntItens) {
                            if (produtos.length() > 5) {
                                produtos = produtos.substring(0, produtos.length() - 2);
                            }

                            pedidoResponseDTO.setProdutos(produtos);

                            lstPedidoResponseDTO.add(pedidoResponseDTO);
                        }
                    }

                    produtos += produto.getProduto_id() + ", ";

                    if (altura <= 30 && largura <= 40 && comprimento <= 80) {
                        Dimensao dimensoes = dimensoesService.findByDescricao("Caixa 1");
                        caixa.setCaixa_id(dimensoes.getDimensao_id());
                    } else if (altura <= 80 && largura <= 50 && comprimento <= 40) {
                        Dimensao dimensoes = dimensoesService.findByDescricao("Caixa 2");
                        caixa.setCaixa_id(dimensoes.getDimensao_id());
                    } else if (altura <= 50 && largura <= 80 && comprimento <= 60) {
                        Dimensao dimensoes = dimensoesService.findByDescricao("Caixa 3");
                        caixa.setCaixa_id(dimensoes.getDimensao_id());
                    }
                    if (altura >= 80 || largura >= 80 || comprimento >= 80) {
                        caixas.add(caixa);
                    }
                }

                if (obj.getProdutos().size() > 1) {
                    if (produtos.length() > 5) {
                        produtos = produtos.substring(0, produtos.length() - 2);
                    }

                    if (caixas.isEmpty()) {
                        pedidoResponseDTO.setCaixas(caixas);
                    }

                    pedidoResponseDTO.setProdutos(produtos);

                    lstPedidoResponseDTO.add(pedidoResponseDTO);
                }
            }

            return lstPedidoResponseDTO;
        }
        return null;
    }
}