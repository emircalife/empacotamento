package br.com.calife.empacotamento.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dimensao_id")
public class Caixa {
    @Id
    @Column(name = "dimensao_id", nullable = false)
    private Integer caixa_id;

    @OneToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name = "produto_id")
    private Produto produto_id;

    @Column(name = "observacoes")
    private String observacoes;
}
