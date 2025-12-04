package com.godaskids.controller.produto;

import com.godaskids.entity.ProdutoEntity;
import com.godaskids.service.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
/*
    @GetMapping("/consulta")
    public Page<ProdutoDTO> consultar(
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String faixa,
            @RequestParam(required = false) String tamanho,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable paginacao = PageRequest.of(page, 20);
        return service.consultar(descricao, categoria, faixa, tamanho, paginacao);
    }

    @GetMapping("/id")
    public ProdutoDTO consultar(@RequestParam(required = true) Integer id) {
        return service.consultar(id);
    }
*/
    @PostMapping("/salvar")
	public ProdutoResponse salvar(@RequestBody ProdutoRequest req) {

        ProdutoEntity e = new ProdutoEntity();
        e.setDescricao(req.descricao());
        e.setCategoria(req.categoria());
        e.setFaixa(req.faixa());
        e.setTamanho(req.tamanho());
        e.setPreco(req.preco());

        e = service.salvar(e);

        return new ProdutoResponse(e.getId(), e.getDescricao(), e.getCategoria(), e.getFaixa(), e.getTamanho(), e.getPreco());
	}

}
