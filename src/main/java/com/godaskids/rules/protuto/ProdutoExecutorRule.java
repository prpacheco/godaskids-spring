package com.godaskids.rules.protuto;

import com.godaskids.entity.ProdutoEntity;
import com.godaskids.rules.base.RuleInterface;
import com.godaskids.rules.base.RuleExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoExecutorRule extends RuleExecutor<ProdutoEntity> {

    public ProdutoExecutorRule(List<RuleInterface<ProdutoEntity>> rules) {
        super(rules);
    }
}
