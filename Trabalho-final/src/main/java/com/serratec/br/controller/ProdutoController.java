package com.serratec.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.br.dto.ProdutoResponseDTO;
import com.serratec.br.entity.Produto;
import com.serratec.br.exception.ValorExcpetion;
import com.serratec.br.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping
	private ResponseEntity<List<ProdutoResponseDTO>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@PostMapping
	private ResponseEntity<ProdutoResponseDTO> inserir(@Valid @RequestBody Produto produto){
		return ResponseEntity.ok(service.postar(produto));
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id,@Valid @RequestBody Produto produto){
		ProdutoResponseDTO a = service.atualizar(id, produto);
		if(a != null) {
			return ResponseEntity.ok(a);
		}else {
			throw new ValorExcpetion("Valor está errado sério mesmo");
		}
	}
	
}
