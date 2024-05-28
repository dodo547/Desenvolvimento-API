package com.serratec.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.br.dto.JogoResponseDTO;
import com.serratec.br.service.JogoService;

@RequestMapping("/jogos")
@RestController
public class JogoController {
	@Autowired
	private JogoService jogoService;
	@GetMapping
	public ResponseEntity<List<JogoResponseDTO>> listarJogos(){
		return ResponseEntity.ok(jogoService.listarJogos());
	}

}
