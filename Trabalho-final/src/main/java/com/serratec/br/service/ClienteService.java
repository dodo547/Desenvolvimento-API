package com.serratec.br.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.entity.Cliente;
import com.serratec.br.entity.Endereco;
import com.serratec.br.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private EnderecoService enderecoService;

	// GetAll
	public List<Cliente> listar() {
		return repository.findAll();
	}

	// Post
	public Cliente InserirC(String cep, Cliente c) {
		Endereco endereco = enderecoService.buscar(cep);
        if(endereco != null) {//usar esse negócio de criar aleatóriamente ou por o ID direto
//		Endereco enderecozinho = new Endereco( endereco.getCep(), endereco.getLogradouro(),
//				endereco.getBairro(), endereco.getLocalidade(), endereco.getUf());

		c.setEndereco(endereco);
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
