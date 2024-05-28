package com.serratec.br.dto;

import java.time.LocalDate;

import com.serratec.br.entity.Jogo;

public class JogoResponseDTO {
	private String nome;
	private Long id;
	private LocalDate dataCriacao;
	private String empresa;
	
	public JogoResponseDTO(Jogo jogo) {
		super();
		this.nome = jogo.getNome();
		this.dataCriacao = jogo.getDataCriacao();
		this.empresa = jogo.getEmpresa();
		this.id = jogo.getId();
	}

	public JogoResponseDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
