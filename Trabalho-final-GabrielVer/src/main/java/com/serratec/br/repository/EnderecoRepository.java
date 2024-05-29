package com.serratec.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	public Endereco findByCep(String cep);
	
}
