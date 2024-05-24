package com.serratec.br.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.dto.CategoriaResponseDTO;
import com.serratec.br.entity.Categoria;
import com.serratec.br.exception.ResourceNotFoundException;
import com.serratec.br.repository.CategoriaRepository;


@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	//No serviço ele pediu no enumciado o post e o put, porém vamos fazer o get tbm pq somos teimosos
	
	//GetALL
	public List<Categoria> listar() {
		return repository.findAll();
	}
	
	//Post
	public CategoriaResponseDTO CPostar(Categoria cat) {
		return new CategoriaResponseDTO(repository.save(cat));
	}
	
	//Put (Ou update)
	public CategoriaResponseDTO Atualizar(Long id, Categoria cat){
		Categoria a = repository.findById(id).orElse(null);
		if(a == null) throw new ResourceNotFoundException("Não foi possível achar o id pedido");
		cat.setId(id);
		return new CategoriaResponseDTO(repository.save(cat));
	}
}
