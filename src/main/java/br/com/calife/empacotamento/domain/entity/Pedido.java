package br.com.calife.empacotamento.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name = "pedido_id", nullable = false)
    private Integer pedido_id;

    @OneToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name = "produto_id")
    private Produto produto;
}