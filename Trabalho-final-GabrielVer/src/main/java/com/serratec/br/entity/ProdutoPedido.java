package com.serratec.br.entity;

import java.time.LocalDate;

import com.serratec.br.dto.ProdutoPedidoRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Produto_Pedido")
public class ProdutoPedido {
	
	@EmbeddedId
	private ProdutoPedidoPK id = new ProdutoPedidoPK();
	
	private LocalDate dataPedido;
	
	@Min(1)
	@Column(name = "quantidade", nullable = false)
	private Integer qtdItens;
	
	@NotNull
	@Min(0)
	@Column(name = "valor")
	private Double valor;


	
	public ProdutoPedido() {
		super();
	}

	
	
	public ProdutoPedido(ProdutoPedidoRequestDTO ProdutoPedido,Pedido pedido, Produto produto) {
        super();
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.qtdItens = ProdutoPedido.getQtdItens();
        this.valor = produto.getValor();
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

	public ProdutoPedidoPK getId() {
		return id;
	}

	public void setId(ProdutoPedidoPK id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}



	@Override
	public String toString() {
		return "ProdutoPedido [id=" + id + ", dataPedido=" + dataPedido + ", qtdItens=" + qtdItens + ", valor=" + valor
				+ "]";
	}
	
	
}
