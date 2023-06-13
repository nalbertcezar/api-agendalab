package com.agendalab.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendalab.api.dto.DadosAgendamento;
import com.agendalab.api.dto.DadosDetalhamentoAgendamento;
import com.agendalab.api.model.Agendamento;
import com.agendalab.api.model.Usuario;
import com.agendalab.api.repository.AgendamentoRepository;
import com.agendalab.api.repository.UsuarioRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public DadosDetalhamentoAgendamento agendar(DadosAgendamento dados) {
		Usuario usuario = usuariorepository.getReferenceById(dados.idUsuario());
		Agendamento agendamento = new Agendamento(null, usuario, dados.data(), dados.hora());
		agendamentoRepository.save(agendamento);
		return new DadosDetalhamentoAgendamento(agendamento);
	}
	
}
