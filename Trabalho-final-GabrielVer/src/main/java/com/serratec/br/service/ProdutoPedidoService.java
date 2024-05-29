package com.serratec.br.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.dto.ProdutoPedidoRequestDTO;
import com.serratec.br.dto.ProdutoPedidoResponseDTO;
import com.serratec.br.entity.Pedido;
import com.serratec.br.entity.Produto;
import com.serratec.br.entity.ProdutoPedido;
import com.serratec.br.repository.PedidoRepository;
import com.serratec.br.repository.ProdutoPedidoRepository;
import com.serratec.br.repository.ProdutoRepository;

@Service
public class ProdutoPedidoService {

	
	@Autowired
	private ProdutoPedidoRepository repository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//get
	public List<ProdutoPedidoResponseDTO> buscarTodosCarrinhos() {
		List<ProdutoPedido> lista = repository.findAll();
		List<ProdutoPedidoResponseDTO> produtos = lista.stream().map(produto -> new ProdutoPedidoResponseDTO(produto))
				.collect(Collectors.toList());
		return produtos;
	}
	
	//Post
	public ProdutoPedidoResponseDTO inserir(ProdutoPedidoRequestDTO pedido) {
		Optional<Pedido> p = pedidoRepository.findById(pedido.getIdPedido());
		Optional<Produto> l = produtoRepository.findById(pedido.getIdProduto());
		ProdutoPedido resposta = repository.save(new ProdutoPedido(pedido, p.get(), l.get()));
		System.out.println(p.toString());
		System.out.println(l.toString());
		System.out.println(resposta.toString());
		return new ProdutoPedidoResponseDTO(resposta);
	}
	
	
}
