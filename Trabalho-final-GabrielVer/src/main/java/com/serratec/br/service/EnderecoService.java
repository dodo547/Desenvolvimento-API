package com.serratec.br.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.serratec.br.dto.EnderecoCNPJDTO;
import com.serratec.br.entity.Endereco;
import com.serratec.br.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	//Get ALL
	public List<Endereco> listarTodos(){
		return repository.findAll();
	}
	
	//Post por CEP
	public Endereco buscar(String cep) {

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

	
	//Método mockado
	public Endereco inserir(Endereco endereco) {
		return repository.save(endereco);
	}

	//Post por CNPJ
	public Endereco buscarPorCNPJ(String cnpj) {

		RestTemplate rs = new RestTemplate();
		String url = "https://receitaws.com.br/v1/cnpj/" + cnpj;
		Optional<EnderecoCNPJDTO> endPorCNPJ = Optional.ofNullable(rs.getForObject(url, EnderecoCNPJDTO.class));
        Endereco enderecoViaCep = new Endereco(endPorCNPJ.get());
        if (enderecoViaCep.getCep() != null) {
            String cepSemTraco = enderecoViaCep.getCep().replaceAll("-", "");
            enderecoViaCep.setCep(cepSemTraco);
            return inserir(enderecoViaCep);
		} else {
			return null;
		}
	}
	
	//Put por CNPJ
	public Endereco alterarPorCNPJ(Long id, String cnpj) {
		RestTemplate rs = new RestTemplate();
		String url = "https://receitaws.com.br/v1/cnpj/" + cnpj;
		Optional<EnderecoCNPJDTO> endPorCNPJ = Optional.ofNullable(rs.getForObject(url, EnderecoCNPJDTO.class));
        Endereco enderecoViaCep = new Endereco(endPorCNPJ.get());
        if (enderecoViaCep.getCep() != null) {
            String cepSemTraco = enderecoViaCep.getCep().replaceAll("-", "");
            enderecoViaCep.setCep(cepSemTraco);
            enderecoViaCep.setId(id);
            return inserir(enderecoViaCep);
		} else {
			return null;
		}
	}
	
	public void DeletarPorId(Long id) {
			repository.deleteById(id);

	}

}
