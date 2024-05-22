package com.serratec.br.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
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
	
	@OneToMany(mappedBy = "id.pedido")
	private List<ProdutoPedido> produtos = new ArrayList<>();
	
	//TODO: fazer a ENUM de status
	//private Status status; (em teoria)
}
