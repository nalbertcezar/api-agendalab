package com.agendalab.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
		
		@NotBlank
		String nome,
		
		@NotBlank
		String nomeusuario,
		
		@NotBlank
		String senha) {
}
