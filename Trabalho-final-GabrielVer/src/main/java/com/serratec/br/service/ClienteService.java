package com.serratec.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.configuration.MailConfig;
import com.serratec.br.entity.Cliente;
import com.serratec.br.entity.Endereco;
import com.serratec.br.exception.EmailException;
import com.serratec.br.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private MailConfig mailConfig;

	// GetAll
	public List<Cliente> listar() {
		return repository.findAll();
	}

	// Post
	@Transactional
	public Cliente InserirC(String cep, Cliente c) {
		if (c.getEmail() == null) throw new EmailException("Bota um email de verdade!");
		Endereco endereco = enderecoService.buscar(cep);
        if(endereco != null) {
		c.setEndereco(endereco);
		mailConfig.sendMail(c.getEmail(),"Cadastro de Usuário no Sistema" ,c.toString());
		return repository.save(c);
		}else {
		return null;
		}
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
