package com.agendalab.api.validacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agendalab.api.dto.DadosAgendamento;
import com.agendalab.api.exception.ValidacaoException;
import com.agendalab.api.model.Agendamento;
import com.agendalab.api.repository.AgendamentoRepository;

@Component
public class ValidacaoLimitePessoaHorario implements ValidadorAgendamento {

	@Autowired
	private AgendamentoRepository repository;
	
	@Override
	public void validar(DadosAgendamento dados) {
		LocalDate dataAgendamento = dados.data();		
		LocalTime horaAgendamento = dados.hora();

		List<Agendamento> agendamentos =  repository.findAllByDataAndHora(dataAgendamento, horaAgendamento);
		int agendamentosNoMesmoHorario = agendamentos.size();
		
		if(agendamentosNoMesmoHorario > 5) {
			throw new ValidacaoException("O laboratório atingiu sua capacidade máxima para o horário.");
		}
	}

}
