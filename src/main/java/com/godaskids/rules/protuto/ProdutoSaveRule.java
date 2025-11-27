package com.godaskids.rules.protuto;

import com.godaskids.entity.ProdutoEntity;
import com.godaskids.repository.ProdutoRepository;
import com.godaskids.rules.base.RuleException;
import com.godaskids.rules.base.bkp.Rule;
import com.godaskids.rules.base.bkp.RuleType;
import org.springframework.stereotype.Component;

@Component
public class ProdutoSaveRule implements Rule<ProdutoEntity> {

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
//        if (repo.existsByDescricao(p.getDescricao())) {
            throw new RuleException("Teste regra.");
//        }
    }
}
