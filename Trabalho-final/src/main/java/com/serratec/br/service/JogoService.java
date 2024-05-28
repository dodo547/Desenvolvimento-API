package com.serratec.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.br.dto.JogoResponseDTO;
import com.serratec.br.entity.Jogo;
import com.serratec.br.repository.JogoRepository;

@Service
public class JogoService {
	@Autowired
	private JogoRepository jogoRepository;
	public List<JogoResponseDTO> listarJogos() {
		List <Jogo> jogos = jogoRepository.findAll();
		List <JogoResponseDTO> jogosResponseDTO = new ArrayList <>();
		for (Jogo jogo: jogos) {
			
			JogoResponseDTO jogoDTO = new JogoResponseDTO(jogo);
			jogosResponseDTO.add(jogoDTO);
		}
		return jogosResponseDTO;
		
		
	}
	public JogoResponseDTO inserirJogo(Jogo jogo) {
		Optional<Jogo> jogoOpt =
	}
	
	

}
