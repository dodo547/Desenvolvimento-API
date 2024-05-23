package com.serratec.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
