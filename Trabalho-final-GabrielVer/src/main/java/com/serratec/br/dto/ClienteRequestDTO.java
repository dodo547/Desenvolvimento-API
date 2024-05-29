package com.serratec.br.dto;

import java.util.ArrayList;
import java.util.List;

import com.serratec.br.entity.Cliente;
import com.serratec.br.entity.Pedido;

public class ClienteRequestDTO {

	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	private String senha;
	private String confirmaSenha;
	private List<Pedido> pedidos = new ArrayList<>();

	
	
	public ClienteRequestDTO(String nome, String telefone, String cpf, String email, String senha, String confirmaSenha,
			List<Pedido> pedidos) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.confirmaSenha = confirmaSenha;
	}

	//Construtor passando Cliente
	public ClienteRequestDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
		this.cpf = cliente.getCpf();
		this.email =  cliente.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
