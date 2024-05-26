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

import com.serratec.br.entity.Pedido;
import com.serratec.br.exception.ValorExcpetion;
import com.serratec.br.service.PedidoService;


@RequestMapping("/pedidos")
@RestController
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> gettar(){
		return ResponseEntity.ok(service.buscarPedidos());
	}
	
	@PostMapping
	public ResponseEntity<Pedido> inserir(@RequestBody Pedido pedido){
		return ResponseEntity.ok(service.inserir(pedido));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
		Pedido a = service.Atualizar(id, pedido);
		if(a != null) {
			return ResponseEntity.ok(a);
		}else {
			throw new ValorExcpetion("Id está errado sério mesmo");
		}
	}
	
}