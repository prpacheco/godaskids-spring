package com.godaskids.repository;

import com.godaskids.entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoRepositoryCustom {
    Page<ProdutoEntity> consultar(String descricao,
                                  String categoria,
                                  String faixa,
                                  String tamanho,
                                  Pageable pageable);

    Optional<ProdutoEntity> consultar(Integer id);
}
