package com.godaskids.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.godaskids.entity.ProdutoEntity;

public interface ProdutoRepositoryCustom {
    Page<ProdutoEntity> consultar(String descricao,
                            String categoria,
                            String faixa,
                            String tamanho,
                            Pageable pageable);
}
