package com.godaskids.service.produto;

import com.godaskids.controller.produto.ProdutoRequest;
import com.godaskids.controller.produto.ProdutoResponse;
import com.godaskids.dto.ProdutoDTO;
import com.godaskids.entity.ProdutoEntity;
import com.godaskids.repository.ProdutoRepository;
import com.godaskids.rules.base.CrudService;
import com.godaskids.rules.protuto.ProdutoRuleExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends CrudService<ProdutoEntity, Long> {

	@Autowired
	private final ProdutoRepository repo;
    private final ProdutoRuleExecutor executor;

    public ProdutoService(ProdutoRepository repo,
                          ProdutoRuleExecutor executor) {
        this.repo = repo;
        this.executor = executor;
    }

    public Page<ProdutoDTO> consultar(String descricao, String categoria, String faixa, String tamanho,
                                      Pageable pageable) {

        return repo.consultar(descricao, categoria, faixa, tamanho, pageable).map(ProdutoDTO::fromEntity);
    }

    public ProdutoDTO consultar(Integer id) {
        return repo.consultar(id)
                .map(ProdutoDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
    }


    public ProdutoResponse salvar(ProdutoRequest req) {

		ProdutoEntity e = new ProdutoEntity();
		e.setDescricao(req.descricao());
		e.setCategoria(req.categoria());
		e.setFaixa(req.faixa());
		e.setTamanho(req.tamanho());
		e.setPreco(req.preco());

		ProdutoEntity salvo = repo.save(e);

		return new ProdutoResponse(salvo.getId(), salvo.getDescricao(), salvo.getCategoria(), salvo.getFaixa(),
				salvo.getTamanho(), salvo.getPreco());
	}

    @Override
    protected JpaRepository<ProdutoEntity, Long> getRepo() {
        return repo;
    }
}