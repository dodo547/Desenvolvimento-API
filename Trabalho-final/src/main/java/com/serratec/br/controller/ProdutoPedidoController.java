package com.serratec.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.br.dto.ProdutoPedidoRequestDTO;
import com.serratec.br.dto.ProdutoPedidoResponseDTO;
import com.serratec.br.service.ProdutoPedidoService;


@RequestMapping("/carrinho")
@RestController
public class ProdutoPedidoController {

	@Autowired
	private ProdutoPedidoService service;

	@GetMapping
	private ResponseEntity<List<ProdutoPedidoResponseDTO>> buscartodos(){
		return ResponseEntity.ok(service.buscarTodosCarrinhos());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoPedidoResponseDTO> inserir(@RequestBody ProdutoPedidoRequestDTO pedido){
		return ResponseEntity.ok(service.inserir(pedido));
	}
	
}
