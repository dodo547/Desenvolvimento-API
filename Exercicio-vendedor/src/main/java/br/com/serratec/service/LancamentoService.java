package br.com.serratec.service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public LancamentoVendasMostrarDTO listarPorID(Long id) {
		LancamentoVendas Dto = repository.findById(id).orElse(null);
		if(!(Dto == null)) {
			LancamentoVendasMostrarDTO Dtof = new LancamentoVendasMostrarDTO(Dto.getDataVenda(), Dto.getValorVenda(), Dto.getVendedor());
			return Dtof;
		}
		return null;
	}
	
	public LancamentoVendas inserir(LancamentoVendas lancamento) {
		return repository.save(lancamento);
	}
	
	public void deletarPorID(Long id) {
		repository.deleteById(id);
	}
	
	public LancamentoVendas trocarPorId(Long id, LancamentoVendas vendas ) {
		LancamentoVendas Venda = repository.findById(id).orElse(null);
		if(Venda != null) {
			Venda = vendas;
			return Venda;
		}else {
			return null;
		}
	}
}
