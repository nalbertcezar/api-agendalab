package com.agendalab.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

public record DadosAgendamento(
		
		@NotNull
		Long idUsuario,
		
		@NotNull
		LocalDate data,
		
		@NotNull
		LocalTime hora) {
}
