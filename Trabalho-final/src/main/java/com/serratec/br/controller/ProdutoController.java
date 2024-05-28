package com.serratec.br.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.serratec.br.dto.ProdutoResponseDTO;
import com.serratec.br.entity.Foto;
import com.serratec.br.entity.Produto;
import com.serratec.br.exception.ValorExcpetion;
import com.serratec.br.service.FotoService;
import com.serratec.br.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@Autowired
	private FotoService fotoService;

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> inserir(@Valid @RequestBody Produto produto) {
		return ResponseEntity.ok(service.postar(produto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		ProdutoResponseDTO a = service.atualizar(id, produto);
		if (a != null) {
			return ResponseEntity.ok(a);
		} else {
			throw new ValorExcpetion("Valor está errado sério mesmo");
		}
	}
	
	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id){
		Foto foto = fotoService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(),headers,HttpStatus.OK);	
	}
	
	@GetMapping("{id}")
	public ProdutoResponseDTO buscar (@PathVariable Long id) {
		return service.buscar(id);
	}
	
	@PostMapping(consumes = (MediaType.MULTIPART_FORM_DATA_VALUE))/*("/fotoP")*/
	public ProdutoResponseDTO inserir(@RequestPart Produto produto, @RequestPart MultipartFile file) throws IOException {
		return service.inserir(produto, file);
	}
	
//	@DeleteMapping
//    public ResponseEntity<Void> deletarTodos() {
//        service.deletarTodos();
//    }

		
}
