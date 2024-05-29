package com.serratec.br.entity;

import java.util.List;

import com.serratec.br.dto.EnderecoCNPJDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;

	@OneToMany(mappedBy = "endereco")
	private List<Cliente> cliente;

	
	
	public Endereco() {
	}

	public Endereco(EnderecoCNPJDTO dto) {
		this.cep = dto.getCep();
		this.logradouro = dto.getLogradouro();
		this.bairro = dto.getBairro();
		this.localidade = dto.getMunicipio();
		this.uf = dto.getUf();

	}

	public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {

		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
