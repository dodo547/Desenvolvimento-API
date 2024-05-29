package com.serratec.br.dto;

import java.time.LocalDate;

import com.serratec.br.entity.ProdutoPedido;
import com.serratec.br.enums.StatusENUM;

public class ProdutoPedidoResponseDTO {
	
	private Long idPedido;
	private Integer qtdItens;
	private Double valor;
	private LocalDate dataPedido;
	private StatusENUM status;
	
	
	
	public ProdutoPedidoResponseDTO(ProdutoPedido prod) {
		this.idPedido = prod.getId().getPedido().getId();
		this.qtdItens = prod.getQtdItens();
		this.valor = prod.getValor();
		this.dataPedido = prod.getDataPedido();
		this.status = prod.getId().getPedido().getStatus();
	}
	
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getQtdItens() {
		return qtdItens;
	}
	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}


	public StatusENUM getStatus() {
		return status;
	}


	public void setStatus(StatusENUM status) {
		this.status = status;
	}


	

}
