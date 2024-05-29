package com.serratec.br.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.serratec.br.enums.StatusENUM;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ProdutoPedido> pedidos = new HashSet<>();
	
	@Enumerated(EnumType.ORDINAL)
	private StatusENUM status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ProdutoPedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<ProdutoPedido> pedidos) {
		this.pedidos = pedidos;
	}

	public StatusENUM getStatus() {
		return status;
	}

	public void setStatus(StatusENUM status) {
		this.status = status;
	}


	
	
}
