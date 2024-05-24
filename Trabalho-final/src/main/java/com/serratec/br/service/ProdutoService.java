package com.serratec.br.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.dto.ProdutoResponseDTO;
import com.serratec.br.entity.Produto;
import com.serratec.br.exception.CategoriaException;
import com.serratec.br.exception.NomeException;
import com.serratec.br.exception.ResourceNotFoundException;
import com.serratec.br.exception.ValorExcpetion;
import com.serratec.br.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	// get
	public List<ProdutoResponseDTO> listar() {
		List<Produto> produtinhos = repository.findAll();
		List<ProdutoResponseDTO> produtos = produtinhos.stream().map(produto -> new ProdutoResponseDTO(produto))
				.collect(Collectors.toList());
		return produtos;
	}

	// post
	public ProdutoResponseDTO postar(Produto produto) { // talvez nn seja o melhor jeito de tratar erros mas foi como eu consegui
		if (produto.getValor() <= 0 || produto.getValor() == null)
			throw new ValorExcpetion("Valor vazio ou menor que zero");
		if (produto.getNome() == null)
			throw new NomeException("Nome vazio!");
		if (produto.getCategoria() == null)
			throw new CategoriaException("Não foi inserido uma categoria por favor insira uma");
		return new ProdutoResponseDTO(repository.save(produto));
	}

	// put
	public ProdutoResponseDTO atualizar(Long id, Produto produto) {
		Produto a = repository.findById(id).orElse(null);
		if (a == null)
			throw new ResourceNotFoundException("Não foi possível achar o id pedido");
		produto.setId(id);
		return new ProdutoResponseDTO(repository.save(produto));
	}

}
