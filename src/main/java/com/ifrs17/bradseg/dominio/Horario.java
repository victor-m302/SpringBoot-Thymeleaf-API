package com.ifrs17.bradseg.dominio;

import java.time.LocalTime;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "horas", indexes = {@Index(name = "idx_hora_minuto", columnList = "hora_minuto")})
public class Horario extends AbstractEntity {
	
	@Column(name = "hora_minuto", unique = true, nullable = false)
	private LocalTime horaMinuto;
	
	public LocalTime getHoraMinuto() {
		System.out.println("Horário 0001");
		return horaMinuto;
	}

	public void setHoraMinuto(LocalTime horaMinuto) {
		System.out.println("Horário 0002");
		this.horaMinuto = horaMinuto;
	}

}
