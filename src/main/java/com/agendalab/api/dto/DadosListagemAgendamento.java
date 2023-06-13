package com.agendalab.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.agendalab.api.model.Agendamento;

public record DadosListagemAgendamento(Long id, String nome, LocalDate data, LocalTime hora) {

	public DadosListagemAgendamento(Agendamento agendamento) {
		this(agendamento.getId(), agendamento.getUsuario().getNome(), agendamento.getData(), agendamento.getHora());
	}
	
}
