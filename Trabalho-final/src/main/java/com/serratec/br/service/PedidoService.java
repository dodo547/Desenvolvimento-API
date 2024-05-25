package com.serratec.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.entity.Pedido;
import com.serratec.br.repository.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> buscarPedidos(){
		return repository.findAll();
	}
	
	//Post
	public Pedido inserir(Pedido pedido) {
		return repository.save(pedido);
	}
	
	//Put
	public Pedido Atualizar(Long id, Pedido c) {
		Pedido a = repository.findById(id).orElse(null);
		if (a != null) {
			c.setId(id);
			return repository.save(c);
		} else {
			return null;
		}
	}
	
}