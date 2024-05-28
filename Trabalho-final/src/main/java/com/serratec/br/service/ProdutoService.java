package com.serratec.br.service;



import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serratec.br.dto.ProdutoResponseDTO;
import com.serratec.br.entity.Produto;
import com.serratec.br.exception.CategoriaException;
import com.serratec.br.exception.NomeException;
import com.serratec.br.exception.ResourceNotFoundException;
import com.serratec.br.exception.ValorExcpetion;
import com.serratec.br.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private FotoService fotoService;

	// get
	public List<ProdutoResponseDTO> listar() {
		List<Produto> produtinhos = repository.findAll();
		List<ProdutoResponseDTO> produtos = produtinhos.stream().map(produto -> new ProdutoResponseDTO(produto))
				.collect(Collectors.toList());
		return produtos;
	}

	// post
	public ProdutoResponseDTO postar(Produto produto) {
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

	public ProdutoResponseDTO adicionarLinkImagem(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/foto")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoResponseDTO dto = new ProdutoResponseDTO();
		dto.setNome(produto.getNome());
		dto.setUrl(uri.toString());
		return dto;
	}

	@Transactional
	public ProdutoResponseDTO inserir(Produto produto, MultipartFile file) throws IOException {
		produto = repository.save(produto);
		fotoService.inserir(produto, file);
		return adicionarLinkImagem(produto);
	}

	public List<ProdutoResponseDTO> listarFoto() {
		return repository.findAll().stream().map((f) -> adicionarLinkImagem(f)).collect(Collectors.toList());
	}

	public ProdutoResponseDTO buscar(Long id) {
		Optional<Produto> produto = repository.findById(id);
		return adicionarLinkImagem(produto.get());
	}

	@Transactional
	public void deletarTodos(Produto produto) {
		repository.deleteAll();
	}

	public ResponseEntity<ProdutoResponseDTO> deletarProduto(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
