package com.ifrs17.bradseg.dominio;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfis")
public class Perfil extends AbstractEntity {
	
	@Column(name = "descricao", nullable = false, unique = true)
	private String desc;
	
	public Perfil() {
		super();
		System.out.println("Perfil 0001");
	}

	public Perfil(Long id) {
		super.setId(id);
		System.out.println("Perfil 0002");
	}

	public String getDesc() {
		System.out.println("Perfil 0003");
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
		System.out.println("Perfil 0004");
	}
}
