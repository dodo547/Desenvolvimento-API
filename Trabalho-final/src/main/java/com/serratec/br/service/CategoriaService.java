package com.serratec.br.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.entity.Categoria;
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
	public Categoria CPostar(Categoria cat) {
		return repository.save(cat);
	}
	
	//Put (Ou update)
	public Categoria Atualizar(Long id, Categoria cat){
			Categoria a = repository.findById(id).orElse(null);
			if(a != null) {
				a.setId(id);
				return repository.save(a);
			}
			else {
				return null;
			}
	}
}
