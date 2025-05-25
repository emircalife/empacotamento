package br.com.calife.empacotamento.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dimensao")
public class Dimensao {
    @Id
    @Column(name = "dimensao_id", nullable = false)
    private Integer dimensao_id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "altura", nullable = false)
    private Integer altura;

    @Column(name = "largura", nullable = false)
    private Integer largura;

    @Column(name = "comprimento", nullable = false)
    private Integer comprimento;
}
