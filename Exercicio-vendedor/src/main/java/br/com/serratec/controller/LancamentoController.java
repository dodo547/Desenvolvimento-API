package br.com.serratec.controller;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/Vendas")
public class LancamentoController {
	
	@Autowired
	LancamentoService service;
	
	@GetMapping
	public ResponseEntity<List<LancamentoVendasMostrarDTO>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LancamentoVendasMostrarDTO> listarPorID(@PathVariable Long id){
		if(service.listarPorID(id) != null) {
			return ResponseEntity.ok(service.listarPorID(id));
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<LancamentoVendas> inserir(@Valid @RequestBody LancamentoVendas vendas) {
		LancamentoVendas venda = service.inserir(vendas);
		return ResponseEntity.created(null).body(venda);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletevenda(@PathVariable Long id){
        service.deleteVenda(id);
        return ResponseEntity.noContent().build();
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<LancamentoVendas> trocar(@Valid @RequestBody LancamentoVendas venda, @PathVariable Long id){
		try {
		var a = service.atualizar(id, venda);
		return ResponseEntity.ok(a);
		}catch(Exception e){
			return ResponseEntity.noContent().build();
		}
	}
}
