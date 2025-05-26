package br.com.calife.empacotamento.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @Column(name = "produto_id", nullable = false)
    private Integer id;

    @Column(name = "produto")
    private String produto_id;

    @OneToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name = "dimensao_id")
    private Dimensao dimensoes;
}
