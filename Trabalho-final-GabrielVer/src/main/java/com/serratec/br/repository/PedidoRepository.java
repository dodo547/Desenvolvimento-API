package com.serratec.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
