package com.godaskids.controller.produto;

import java.math.BigDecimal;

public record ProdutoRequest(
        String descricao,
        String categoria,
        String faixa,
        String tamanho,
        BigDecimal preco
) {}
