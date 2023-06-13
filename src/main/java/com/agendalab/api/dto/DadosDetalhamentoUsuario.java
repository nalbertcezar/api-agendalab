package com.agendalab.api.dto;

import com.agendalab.api.model.Usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String nomeusuario) {
	
	public DadosDetalhamentoUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getNomeusuario());
	}
	
}
