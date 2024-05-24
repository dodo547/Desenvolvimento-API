package com.serratec.br.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.serratec.br.dto.EnderecoResponseDTO;
import com.serratec.br.entity.Endereco;
import com.serratec.br.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public EnderecoResponseDTO buscar(String cep) {

		RestTemplate rs = new RestTemplate();
		String url = "http://viacep.com.br/ws/" + cep + "/json";
		Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(url, Endereco.class));
		if (enderecoViaCep.get().getCep() != null) {
			String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
			enderecoViaCep.get().setCep(cepSemTraco);
			return inserir(enderecoViaCep.get());
		} else {
			return null;
		}
	}

	public EnderecoResponseDTO inserir(Endereco endereco) {
		return new EnderecoResponseDTO(repository.save(endereco));
	}

}
