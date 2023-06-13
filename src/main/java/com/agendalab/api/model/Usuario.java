package com.agendalab.api.model;

import com.agendalab.api.dto.DadosAlteracaoSenha;
import com.agendalab.api.dto.DadosCadastroUsuario;
import com.agendalab.api.dto.DadosNome;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nomeusuario;
	private String senha;
	
	public Usuario(DadosCadastroUsuario dados) {
		this.nome = dados.nome();
		this.nomeusuario = dados.nomeusuario();
		this.senha = dados.senha();
	}

	public void atualizarSenha(DadosAlteracaoSenha dados) {
		this.senha = dados.senha();
	}

	public void atualizarNome(DadosNome dados) {
		this.nome = dados.nome();		
	}
	
}
