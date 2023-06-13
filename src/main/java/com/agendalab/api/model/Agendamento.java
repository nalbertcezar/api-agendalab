package com.agendalab.api.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.agendalab.api.dto.DadosAlteracaoData;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;

@Entity(name = "Agendamento")
@Table(name = "agendamentos")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Future
	private LocalDate data;
	private LocalTime hora;
	
	public Agendamento() {
	}
	
	public Agendamento(Long id, Usuario usuario, LocalDate data, LocalTime hora) {
		this.id = id;
		this.usuario = usuario;
		this.data = data;
		this.hora = hora;
	}
	
	public void alterarData(DadosAlteracaoData dados) {
		this.data = dados.data();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
		
}
