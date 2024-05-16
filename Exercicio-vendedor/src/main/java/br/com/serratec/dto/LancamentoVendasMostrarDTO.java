package br.com.serratec.dto;

import java.time.LocalDate;

public class LancamentoVendasMostrarDTO {
	private LocalDate dataVenda;
	private Integer valorVenda;
	private String NomeVendedor;
	
	
	
	public LancamentoVendasMostrarDTO(LocalDate dataVenda, Integer valorVenda, String vendedor) {
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
	public Integer getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Integer valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getVendedor() {
		return NomeVendedor;
	}
	public void setVendedor(String vendedor) {
		this.NomeVendedor = vendedor;
	}
	
	
}
