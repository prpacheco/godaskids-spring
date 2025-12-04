package com.godaskids.dto;

import com.godaskids.entity.ProdutoEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    private Long id;
    private String descricao;
    private String categoria;
    private String faixa;
    private String tamanho;
    private BigDecimal preco;

    public static ProdutoDTO fromEntity(ProdutoEntity p) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(p.getId());
        dto.setDescricao(p.getDescricao());
        dto.setCategoria(p.getCategoria());
        dto.setFaixa(p.getFaixa());
        dto.setTamanho(p.getTamanho());
        dto.setPreco(p.getPreco());
        return dto;
    }
}
