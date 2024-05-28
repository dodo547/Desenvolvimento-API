package com.serratec.br.repository;

import org.springframework.stereotype.Repository;

import com.serratec.br.entity.Jogo;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
