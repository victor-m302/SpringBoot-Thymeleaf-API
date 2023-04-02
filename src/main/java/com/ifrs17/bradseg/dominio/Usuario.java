package com.ifrs17.bradseg.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios", indexes = {@Index(name = "idx_usuario_email", columnList = "email")})
public class Usuario extends AbstractEntity {	
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@ManyToMany
	@JoinTable(
		name = "usuarios_tem_perfis", 
        joinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "perfil_id", referencedColumnName = "id") }
	)
	private List<Perfil> perfis;
	
	@Column(name = "ativo", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean ativo;
	
	@Column(name = "codigo_verificador", length = 6)
	private String codigoVerificador;
	
	public Usuario() {
		super();
		System.out.println("Usuario 0001");

	}

	public Usuario(Long id) {
		super.setId(id);
		System.out.println("Usuario 0002");
	}

	// adiciona perfis a lista
	public void addPerfil(PerfilTipo tipo) {
		if (this.perfis == null) {
			this.perfis = new ArrayList<>();
		}
		this.perfis.add(new Perfil(tipo.getCod()));
		
		System.out.println("Usuario 0003");
	}

	public Usuario(String email) {
		this.email = email;
		System.out.println("Usuario 0004");
	}
	
	public String getEmail() {
		System.out.println("Usuario 0005");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Usuario 0006");
		this.email = email;
	}

	public String getSenha() {
		System.out.println("Usuario 0007");
		return senha;
	}

	public void setSenha(String senha) {
		System.out.println("Usuario 0008");
		this.senha = senha;
	}

	public List<Perfil> getPerfis() {
		System.out.println("Usuario 0009");
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
		System.out.println("Usuario 0010");
	}

	public boolean isAtivo() {
		System.out.println("Usuario 0011");
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
		System.out.println("Usuario 0012");
	}	
	
	public String getCodigoVerificador() {
		System.out.println("Usuario 0013");
		return codigoVerificador;
	}

	public void setCodigoVerificador(String codigoVerificador) {
		this.codigoVerificador = codigoVerificador;
		System.out.println("Usuario 0013");
		
	}

}
