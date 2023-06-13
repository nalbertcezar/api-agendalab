package com.agendalab.api.controller;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.agendalab.api.dto.DadosAlteracaoSenha;
import com.agendalab.api.dto.DadosCadastroUsuario;
import com.agendalab.api.dto.DadosDetalhamentoUsuario;
import com.agendalab.api.dto.DadosNome;
import com.agendalab.api.model.Usuario;
import com.agendalab.api.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
		Usuario usuario = new Usuario(dados);
		repository.save(usuario);
		
		URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
	}
	
	@GetMapping
	public ResponseEntity<Object> listar() {
		List<DadosDetalhamentoUsuario> dto =  repository.findAll().stream().map(DadosDetalhamentoUsuario::new).toList();
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/senha")
	@Transactional
	public ResponseEntity<Object> alterarSenha(@RequestBody @Valid DadosAlteracaoSenha dados) {
		Usuario usuario = repository.getReferenceById(dados.id());
		usuario.atualizarSenha(dados);
		
		return ResponseEntity.ok("Senha atualizada com sucesso!");
	}
	
	@PutMapping("/nome")
	@Transactional
	public ResponseEntity<Object> alterarNome(@RequestBody @Valid DadosNome dados) {
		Usuario usuario = repository.getReferenceById(dados.id());
		usuario.atualizarNome(dados);
		
		return ResponseEntity.ok("Nome atualizado com sucesso!");
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
