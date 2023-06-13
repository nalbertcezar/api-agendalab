package com.agendalab.api.validacao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.agendalab.api.dto.DadosAgendamento;
import com.agendalab.api.exception.ValidacaoException;

@Component
public class ValidacaoHorarioFuncionamento implements ValidadorAgendamento {

	@Override
	public void validar(DadosAgendamento dados) {
		LocalDate dataAgendamento = dados.data();
		LocalTime horaAgendamento = dados.hora();
		
		var sabado = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SATURDAY);
		var domingo = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		var antesDaAbertura = horaAgendamento.getHour() < 7;
		var depoisDoFechamento = horaAgendamento.getHour() > 21;
		
		if(sabado || domingo || antesDaAbertura || depoisDoFechamento) {
			throw new ValidacaoException("Dia ou horário indisponível.");
		}
	}
	
}
