package com.mballem.curso.security.domain;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity implements Serializable  {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public AbstractEntity() {
		super();
		System.out.println("AbstractEntity 0001");
	}

	public Long getId() {
		System.out.println("AbstractEntity 0002");
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		System.out.println("AbstractEntity 0003");
	}
	
	public boolean hasNotId() {
		System.out.println("AbstractEntity 0004");
		return id == null;
	}

	public boolean hasId() {
		System.out.println("AbstractEntity 0005");
		return id != null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		System.out.println("AbstractEntity 0006");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		System.out.println("AbstractEntity 0007");
		return true;
	}

	@Override
	public String toString() {
		System.out.println("AbstractEntity 0008");
		return String.format("Entidade %s id: %s", this.getClass().getName(), getId());
	}	
}
