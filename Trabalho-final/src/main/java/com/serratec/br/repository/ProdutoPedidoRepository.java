package com.serratec.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.br.entity.ProdutoPedido;
import com.serratec.br.entity.ProdutoPedidoPK;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, ProdutoPedidoPK>{

}
