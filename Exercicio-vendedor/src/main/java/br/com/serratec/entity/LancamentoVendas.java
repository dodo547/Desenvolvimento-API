package br.com.serratec.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LancamentoVendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoVenda;
	private LocalDate dataVenda;
	private Double valorVenda;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_Vendedor")
	private Vendedor vendedor; 
	
	public Long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
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
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
