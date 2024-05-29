package com.serratec.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
