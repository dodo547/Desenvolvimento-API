package com.serratec.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.br.entity.Categoria;
import com.serratec.br.service.CategoriaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	public CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listarTodos(){
		return ResponseEntity.ok(service.listar());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> adicionarCategoria(@Valid @RequestBody Categoria cat){
		Categoria a = service.CPostar(cat);
		if(a != null) {
			return ResponseEntity.ok(a);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Categoria> atualizarCategoria(@RequestParam Long id, @Valid @RequestBody Categoria cat){
		Categoria a = service.Atualizar(id, cat);
		if(a != null) {
			return ResponseEntity.ok(a);
		}
		return ResponseEntity.notFound().build();
	}
	
}
