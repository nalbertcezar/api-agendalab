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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Agendamento")
@Table(name = "agendamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
	
	public void alterarData(DadosAlteracaoData dados) {
		this.data = dados.data();
	}
		
}
