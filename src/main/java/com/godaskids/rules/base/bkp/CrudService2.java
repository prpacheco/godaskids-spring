package com.godaskids.rules.base.bkp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudService2<T, ID> {

    protected abstract JpaRepository<T, ID> getRepo();

    public T salvar(T entity) {
        return getRepo().save(entity);
    }

    public T atualizar(T entity) {
        return getRepo().save(entity);
    }

    public List<T> listar() {
        return getRepo().findAll();
    }

    public T buscarPorId(ID id) {
        return getRepo().findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void excluir(ID id) {
        getRepo().deleteById(id);
    }
}