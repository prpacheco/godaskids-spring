package com.godaskids.rules.protuto;

import com.godaskids.entity.ProdutoEntity;
import com.godaskids.rules.base.bkp.Rule;
import com.godaskids.rules.base.bkp.RuleExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoRuleExecutor extends RuleExecutor<ProdutoEntity> {

    public ProdutoRuleExecutor(List<Rule<ProdutoEntity>> rules) {
        super(rules);
    }
}
