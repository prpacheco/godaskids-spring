package com.godaskids.repository;

import com.godaskids.entity.ProdutoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<ProdutoEntity> consultar(String descricao, String categoria, String faixa, String tamanho, Pageable pageable) {

        StringBuilder sb = new StringBuilder("FROM Produto p WHERE 1=1 ");
        Map<String, Object> params = new HashMap<>();

        if (descricao != null && !descricao.isEmpty()) {
            sb.append("AND LOWER(p.descricao) LIKE LOWER(:descricao) ");
            params.put("descricao", "%" + descricao + "%");
        }
        if (categoria != null && !categoria.isEmpty()) {
            sb.append("AND p.categoria = :categoria ");
            params.put("categoria", categoria);
        }
        if (faixa != null && !faixa.isEmpty()) {
            sb.append("AND p.faixa = :faixa ");
            params.put("faixa", faixa);
        }
        if (tamanho != null && !tamanho.isEmpty()) {
            sb.append("AND p.tamanho = :tamanho ");
            params.put("tamanho", tamanho);
        }

        Query query = em.createQuery("SELECT p " + sb, ProdutoEntity.class);
        params.forEach(query::setParameter);

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<ProdutoEntity> lista = query.getResultList();

        Query countQuery = em.createQuery("SELECT COUNT(p) " + sb);
        params.forEach(countQuery::setParameter);
        long total = (long) countQuery.getSingleResult();

        return new PageImpl<>(lista, pageable, total);
    }

    @Override
    public Optional<ProdutoEntity> consultar(Integer id) {
        try {
            String jpql = "SELECT p FROM Produto p WHERE p.id = :id";
            ProdutoEntity entity = em.createQuery(jpql, ProdutoEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();

            return Optional.of(entity);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}

