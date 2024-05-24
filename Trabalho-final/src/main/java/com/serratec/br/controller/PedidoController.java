package com.serratec.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.br.entity.Pedido;
import com.serratec.br.service.PedidoService;


@RequestMapping("/pedidos")
@RestController
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@PostMapping
	public ResponseEntity<Pedido> inserir(@RequestBody Pedido pedido){
		return ResponseEntity.ok(service.inserir(pedido));
	}
	
}
