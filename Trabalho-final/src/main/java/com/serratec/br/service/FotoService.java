package com.serratec.br.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.serratec.br.entity.Foto;
import com.serratec.br.entity.Produto;
import com.serratec.br.exception.ResourceNotFoundException;
import com.serratec.br.repository.FotoRepository;

@Service
public class FotoService {

	@Autowired
	private FotoRepository repository;

	public Foto inserir(Produto produto, MultipartFile file) throws IOException {
		Foto foto = new Foto();
		foto.setNome(file.getName());
		foto.setDados(file.getBytes());
		foto.setTipo(file.getContentType());
		foto.setProduto(produto);
		return repository.save(foto);
	}

	public Foto buscar(Long id) {
		Produto produto = new Produto();
		produto.setId(id);
		Optional<Foto> foto = repository.findByProduto(produto);
		
		if(foto.isPresent()) {
			return foto.get();
		}
		throw new ResourceNotFoundException("Foto não encontrada");

	}
}
