package com.mballem.curso.security.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "especialidades", indexes = {@Index(name = "idx_especialidade_titulo", columnList = "titulo")})
public class Especialidade extends AbstractEntity {
	
	@Column(name = "titulo", unique = true, nullable = false)
	private String titulo;
	
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	
	@ManyToMany
	@JoinTable(
			name = "medicos_tem_especialidades",
			joinColumns = @JoinColumn(name = "id_especialidade", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_medico", referencedColumnName = "id")
    )
	private List<Medico> medicos;	

	public String getTitulo() {
		System.out.println("Especialidade 0001");
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		System.out.println("Especialidade 0002");
	}	

	public String getDescricao() {
		System.out.println("Especialidade 0003");
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
		System.out.println("Especialidade 0004");
	}

	public List<Medico> getMedicos() {
		System.out.println("Especialidade 0005");
		return medicos;
	}

	public void setMedico(List<Medico> medicos) {
		this.medicos = medicos;
		System.out.println("Especialidade 0006");
	}
}
