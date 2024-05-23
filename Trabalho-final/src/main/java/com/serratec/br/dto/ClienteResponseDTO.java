package com.serratec.br.dto;

import java.util.ArrayList;
import java.util.List;

import com.serratec.br.entity.Cliente;
import com.serratec.br.entity.Pedido;

public class ClienteResponseDTO {
	
	private Long id;
	private String telefone;
	private String email;
	private List<Pedido> pedidos = new ArrayList<>();
 	
	
	
	public ClienteResponseDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.pedidos = cliente.getPedidos();	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
}
