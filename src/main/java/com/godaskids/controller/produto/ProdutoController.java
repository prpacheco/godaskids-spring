package com.godaskids.controller.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godaskids.dto.ProdutoDTO;
import com.godaskids.service.produto.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
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

	@PostMapping("/salvar")
	public ProdutoResponse salvar(@RequestBody ProdutoRequest request) {
		return service.salvar(request);
	}

}
