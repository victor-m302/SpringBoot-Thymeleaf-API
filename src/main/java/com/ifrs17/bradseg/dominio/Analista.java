package com.ifrs17.bradseg.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "analistas")
public class Analista extends AbstractEntity {

	@Column(name = "matricula", unique = true, nullable = false)
	private Integer matricula;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "empresa", nullable = false)
	private String empresa;
	
	@Column(name = "setor", nullable = false)
	private String setor;

	@Column(name = "data_inscricao", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtInscricao;

	@JsonIgnore
	@OneToMany(mappedBy = "analista")
	private List<Parametrizacoes> parametrizacoes;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public String getNome() {
		System.out.println("Analista 0001");
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		System.out.println("Analista 0002");
	}

	public LocalDate getDtInscricao() {
		System.out.println("Analista 0003");
		return dtInscricao;
	}

	public void setDtInscricao(LocalDate dtInscricao) {
		this.dtInscricao = dtInscricao;
		System.out.println("Analista 0004");
	}

	public List<Parametrizacoes> getParametrizacoes() {
		System.out.println("Analista 0005");
		return parametrizacoes;
	}

	public void setParametrizacoes(List<Parametrizacoes> parametrizacoes) {
		this.parametrizacoes = parametrizacoes;
		System.out.println("Analista 0006");
	}

	public Usuario getUsuario() {
		System.out.println("Analista 0007");
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		System.out.println("Analista 0008");
		this.usuario = usuario;
	}

}
