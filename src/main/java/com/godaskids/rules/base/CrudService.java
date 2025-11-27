package com.godaskids.rules.base;

import com.godaskids.rules.base.bkp.RuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService <T, ID> {

    @Autowired
    private RuleExecutor<T> executor;

    protected abstract JpaRepository<T, ID> getRepo();

    public T salvar(T entity) {
        executor.execute(entity, RuleType.SAVE);
        return getRepo().save(entity);
    }

    public T atualizar(T entity) {
        executor.execute(entity, RuleType.UPDATE);
        return getRepo().save(entity);
    }

    public void excluir(ID id) {
        T obj = buscarPorId(id);
        executor.execute(obj, RuleType.DELETE);
        getRepo().delete(obj);
    }

    public T buscarPorId(ID id) {
        return getRepo().findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }
}