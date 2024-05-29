package com.serratec.br.dto;

import com.serratec.br.entity.Produto;

public class ProdutoResponseDTO {

	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
	private CategoriaResponseDTO categoria;
	
	
	
	public ProdutoResponseDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
		this.categoria = new CategoriaResponseDTO(produto.getCategoria());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public CategoriaResponseDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaResponseDTO categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
