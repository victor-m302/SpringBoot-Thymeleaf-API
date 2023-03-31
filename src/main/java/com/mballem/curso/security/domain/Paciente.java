package com.mballem.curso.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "pacientes")
public class Paciente extends AbstractEntity {

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNascimento;

	@JsonIgnore
	@OneToMany(mappedBy = "paciente")
	private List<Agendamento> agendamentos;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public String getNome() {
		System.out.println("Paciente 0001");
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		System.out.println("Paciente 0002");
	}

	public LocalDate getDtNascimento() {
		System.out.println("Paciente 0003");
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
		System.out.println("Paciente 0004");
	}

	public List<Agendamento> getAgendamentos() {
		System.out.println("Paciente 0005");
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
		System.out.println("Paciente 0006");
	}

	public Usuario getUsuario() {
		System.out.println("Paciente 0007");
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		System.out.println("Paciente 0008");
		this.usuario = usuario;
	}

}
