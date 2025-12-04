package com.godaskids.controller.produto;

import com.godaskids.dto.ProdutoDTO;
import com.godaskids.service.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

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

    @PostMapping("/salvar")
	public ProdutoResponse salvar(@RequestBody ProdutoRequest request) {
		return service.salvar(request);
	}

}
