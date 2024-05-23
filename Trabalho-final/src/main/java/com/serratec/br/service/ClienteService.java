package com.serratec.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.entity.Cliente;
import com.serratec.br.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	// GetAll
	public List<Cliente> listar() {
		return repository.findAll();
	}

	// Post
	public Cliente InserirC(Cliente c) {
		return repository.save(c);
	}

	// Put (Ou update)
	public Cliente Atualizar(Long id, Cliente c) {
		Cliente a = repository.findById(id).orElse(null);
		if (a != null) {
			c.setId(id);
			return repository.save(c);
		} else {
			return null;
		}
	}
}
