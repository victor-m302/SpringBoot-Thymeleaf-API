package com.mballem.curso.security.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "medicos")
public class Medico extends AbstractEntity {

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "crm", unique = true, nullable = false)
	private Integer crm;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_inscricao", nullable = false)
	private LocalDate dtInscricao;
	
	// evita recursividade quando o json de resposta for criado para a datatables.
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "medicos_tem_especialidades",
			joinColumns = @JoinColumn(name = "id_medico", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_especialidade", referencedColumnName = "id")
    )
	private Set<Especialidade> especialidades;
	
	// evita recursividade quando o json de resposta for criado para a datatables.
	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private List<Agendamento> agendamentos;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Medico() {
		super();
		System.out.println("Medico 0001");
	}

	public Medico(Long id) {
		super.setId(id);
		System.out.println("Medico 0002");
	}

	public Medico(Usuario usuario) {
		this.usuario = usuario;
		System.out.println("Medico 0003");
	}

	public String getNome() {
		System.out.println("Medico 0004");
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		System.out.println("Medico 0005");
	}

	public Integer getCrm() {
		System.out.println("Medico 0006");
		return crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
		System.out.println("Medico 0007");
	}

	public LocalDate getDtInscricao() {
		System.out.println("Medico 0008");
		return dtInscricao;
	}

	public void setDtInscricao(LocalDate dtInscricao) {
		this.dtInscricao = dtInscricao;
		System.out.println("Medico 0009");
	}

	public Set<Especialidade> getEspecialidades() {
		System.out.println("Medico 0010");
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
		System.out.println("Medico 0011");
	}

	public List<Agendamento> getAgendamentos() {
		System.out.println("Medico 0012");
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
		System.out.println("Medico 0013");
	}	

	public Usuario getUsuario() {
		System.out.println("Medico 0014");
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		System.out.println("Medico 0015");
	}
}
