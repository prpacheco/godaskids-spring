package com.godaskids.rules.protuto;

import com.godaskids.entity.ProdutoEntity;
import com.godaskids.repository.ProdutoRepository;
import com.godaskids.rules.base.RuleInterface;
import com.godaskids.rules.base.RuleException;
import com.godaskids.rules.base.RuleType;
import org.springframework.stereotype.Component;

@Component
public class ProdutoSaveRule implements RuleInterface<ProdutoEntity> {

    private final ProdutoRepository repo;

    public ProdutoSaveRule(ProdutoRepository repo) {
        this.repo = repo;
    }

    @Override
    public RuleType getType() {
        return RuleType.SAVE;
    }

    @Override
    public void validate(ProdutoEntity obj) {
        if (repo.existsByDescricao(p.getDescricao())) {
            throw new RuleException("Teste regra.");
        }
    }
}
