package com.serratec.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.br.entity.Endereco;
import com.serratec.br.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@GetMapping
	public ResponseEntity<List<Endereco>> listarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@GetMapping("{cep}")
	public ResponseEntity<Endereco> buscarCep(@PathVariable String cep) {
		Endereco dto = service.buscar(cep);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/cnpj/{cnpj}")
	public ResponseEntity<Endereco> buscarCPNJ(@PathVariable String cnpj) {
		Endereco dto = service.buscarPorCNPJ(cnpj);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto);
	}

	@PutMapping("/cnpj/{cnpj}/{id}")
	public ResponseEntity<Endereco> trocarPorCnpj(@PathVariable Long id, @PathVariable String cnpj) {
		Endereco a = service.alterarPorCNPJ(id, cnpj);
		if (a != null) {
			return ResponseEntity.ok(a);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletarPorId(@PathVariable Long id){
		service.DeletarPorId(id);
		return ResponseEntity.accepted().build();
	}
}
