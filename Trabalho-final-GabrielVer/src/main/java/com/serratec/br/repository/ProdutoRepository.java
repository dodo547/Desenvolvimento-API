package com.serratec.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
