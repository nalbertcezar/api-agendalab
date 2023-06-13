package com.agendalab.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoSenha(
		
		@NotNull
		Long id,
		
		@NotBlank
		String senha) {
}
