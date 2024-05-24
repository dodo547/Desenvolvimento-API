package com.serratec.br.dto;

import com.serratec.br.entity.Categoria;

public class CategoriaResponseDTO {
	
	private Long id;
	private String nomeCategoria;

	public CategoriaResponseDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nomeCategoria = categoria.getNomeCategoria();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
