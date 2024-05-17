package br.com.serratec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	public List<LancamentoVendasMostrarDTO> listar() {

		List<LancamentoVendas> lv = repository.findAll();

		return lv.stream().map((usuario) -> new LancamentoVendasMostrarDTO(usuario.getDataVenda(),
				usuario.getValorVenda(), usuario.getVendedor())).collect(Collectors.toList());
	}
	
	public LancamentoVendasMostrarDTO listarporID(Long id) {
		

	}
}
