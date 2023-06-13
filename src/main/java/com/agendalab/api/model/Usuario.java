package com.agendalab.api.model;

import com.agendalab.api.dto.DadosAlteracaoSenha;
import com.agendalab.api.dto.DadosCadastroUsuario;
import com.agendalab.api.dto.DadosNome;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nomeusuario;
	private String senha;
	
	public Usuario() {
	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
