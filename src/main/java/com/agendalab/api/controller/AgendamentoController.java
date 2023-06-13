package com.agendalab.api.controller;

import java.util.List;

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

import com.agendalab.api.dto.DadosAgendamento;
import com.agendalab.api.dto.DadosAlteracaoData;
import com.agendalab.api.dto.DadosDetalhamentoAgendamento;
import com.agendalab.api.dto.DadosListagemAgendamento;
import com.agendalab.api.model.Agendamento;
import com.agendalab.api.repository.AgendamentoRepository;
import com.agendalab.api.service.AgendamentoService;
import com.agendalab.api.validacao.ValidadorAgendamento;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamento;
	
	@Autowired
	private AgendamentoRepository repository;
	
	@Autowired
	private List<ValidadorAgendamento> validadores;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> agendar(@RequestBody @Valid DadosAgendamento dados) {
		DadosDetalhamentoAgendamento dto = agendamento.agendar(dados);
		
		validadores.forEach(v -> v.validar(dados));
		
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemAgendamento>> listar() {
		List<DadosListagemAgendamento> agendamentos = repository.findAllOnlyFutureDate().stream().map(DadosListagemAgendamento::new).toList();		
		return ResponseEntity.ok(agendamentos);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Object> alterarData(@RequestBody DadosAlteracaoData dados) {
		Agendamento agendamento = repository.getReferenceById(dados.id());
		agendamento.alterarData(dados);
		
		return ResponseEntity.ok("Data alterada com sucesso para " + agendamento.getData() + ".");
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
