package br.com.calife.empacotamento.domain.repository;

import br.com.calife.empacotamento.domain.entity.Dimensao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DimensaoRepository extends JpaRepository<Dimensao, Integer> {

    @Query(value = """
        select  d.`id`,
                d.`altura`,
                d.`comprimento`,
                d.`largura`,
                d.`descricao`
        from `dimensoes` d
        where d.`descricao` = :descricao
    """, nativeQuery = true)
    Optional<Dimensao> findByDescricao(String descricao);
}