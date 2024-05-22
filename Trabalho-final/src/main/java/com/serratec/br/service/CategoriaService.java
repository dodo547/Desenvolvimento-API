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
	private List<Categoria> listarCat() {
		return repository.findAll();
	}
	
	//Post
	private Categoria ColocarCat(Categoria cat) {
		return repository.save(cat);
	}
}
