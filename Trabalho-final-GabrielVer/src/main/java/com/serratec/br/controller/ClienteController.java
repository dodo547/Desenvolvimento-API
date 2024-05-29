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

import com.serratec.br.entity.Cliente;
import com.serratec.br.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.ok(service.listar());
	}
	
	@PostMapping("/{cep}")
	public ResponseEntity<Cliente> adicionarCliente(@PathVariable String cep, @Valid @RequestBody Cliente c){
		Cliente a = service.InserirC(cep, c);
		if(a == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(c);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente c){
		Cliente a = service.Atualizar(id, c);
		if(a != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.notFound().build();
	}

}
