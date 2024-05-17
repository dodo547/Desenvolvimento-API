package br.com.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
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
		if (!(Dto == null)) {
			LancamentoVendasMostrarDTO Dtof = new LancamentoVendasMostrarDTO(Dto.getDataVenda(), Dto.getValorVenda(),
					Dto.getVendedor());
			return Dtof;
		}
		return null;
	}

	public LancamentoVendas inserir(LancamentoVendas lancamento) {
		return repository.save(lancamento);
	}

	public void deleteVenda(Long id) {
		LancamentoVendas vendas = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lancamento não encontrado"));
		repository.deleteById(id);
	}

	public LancamentoVendas atualizar(Long id, LancamentoVendas vendas) {
		LancamentoVendas a = repository.findById(id).orElse(null);
		if (a != null) {
			vendas.setCodigoVenda(id);
			return repository.save(vendas);
		}
		return null;

	}
}
