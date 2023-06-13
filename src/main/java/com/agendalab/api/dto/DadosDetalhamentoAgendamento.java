package com.agendalab.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.agendalab.api.model.Agendamento;

public record DadosDetalhamentoAgendamento(Long id, Long idUsuario, LocalDate data, LocalTime hora) {

	public DadosDetalhamentoAgendamento(Agendamento agendamento) {
		this(agendamento.getId(), agendamento.getUsuario().getId(), agendamento.getData(), agendamento.getHora());
	}
	
}
