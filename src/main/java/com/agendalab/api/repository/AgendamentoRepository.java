package com.agendalab.api.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agendalab.api.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

	@Query("SELECT a FROM Agendamento a WHERE a.data = :data AND a.hora = :hora")
	List<Agendamento> findAllByDataAndHora(LocalDate data, LocalTime hora);

	@Query("SELECT a FROM Agendamento a WHERE a.data >= CURRENT_DATE ORDER BY data")
	List<Agendamento> findAllOnlyFutureDate();
}
