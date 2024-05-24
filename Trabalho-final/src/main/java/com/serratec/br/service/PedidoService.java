package com.serratec.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.entity.Pedido;
import com.serratec.br.repository.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository repository;
	
	//Post
	public Pedido inserir(Pedido pedido) {
		return repository.save(pedido);
	}
	
	
}
