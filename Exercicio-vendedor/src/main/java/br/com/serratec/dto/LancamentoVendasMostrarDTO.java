package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.Vendedor;

public class LancamentoVendasMostrarDTO {
	private LocalDate dataVenda;
	private Double valorVenda;
	private Vendedor NomeVendedor;
	
	
	
	public LancamentoVendasMostrarDTO(LocalDate dataVenda, Double valorVenda, Vendedor vendedor) {
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.NomeVendedor = vendedor;
	}
	
	
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Vendedor getVendedor() {
		return NomeVendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.NomeVendedor = vendedor;
	}
	
	
}
