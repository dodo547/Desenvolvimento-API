package com.serratec.br.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.Foto;
import com.serratec.br.entity.Produto;

public interface FotoRepository extends JpaRepository<Foto, Long> {
	public Optional<Foto> findByProduto(Produto produto);
}