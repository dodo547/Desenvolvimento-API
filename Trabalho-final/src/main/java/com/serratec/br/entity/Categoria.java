package com.serratec.br.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeCategoria;

	@JsonManagedReference
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	
	public Categoria() {
		super();
	}

	public Categoria(Long id, String nomeCategoria, List<Produto> produtos) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}