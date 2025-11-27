package com.godaskids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godaskids.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>, ProdutoRepositoryCustom {

}