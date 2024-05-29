package com.serratec.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serratec.br.dto.CategoriaResponseDTO;
import com.serratec.br.entity.Categoria;
import com.serratec.br.service.CategoriaService;

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
	public ResponseEntity<CategoriaResponseDTO> adicionarCategoria(@Valid @RequestBody Categoria cat){
		CategoriaResponseDTO a = service.CPostar(cat);
		if(a == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(a);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaResponseDTO> atualizarCategoria(@PathVariable Long id, @Valid @RequestBody Categoria cat){
		CategoriaResponseDTO a = service.Atualizar(id, cat);
		if(a != null) {
			return ResponseEntity.ok(a);
		}
		return ResponseEntity.notFound().build();
	}
	
}
