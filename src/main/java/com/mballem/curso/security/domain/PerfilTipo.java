package com.mballem.curso.security.domain;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), MEDICO(2, "MEDICO"), PACIENTE(3, "PACIENTE");
	
	private long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
		System.out.println("PerfilTipo 0001");
	}

	public long getCod() {
		System.out.println("PerfilTipo 0002");
		return cod;
	}

	public String getDesc() {
		System.out.println("PerfilTipo 0003");
		return desc;
	}
}
