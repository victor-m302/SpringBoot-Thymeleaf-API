package com.ifrs17.bradseg.dominio;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "parametrizacoes") 
public class Parametrizacoes extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name="id_especialidade")
	private Especialidade especialidade;
	
	@ManyToOne
	@JoinColumn(name="id_medico")
	private Medico medico;
	
	//alterado
	@ManyToOne
	@JoinColumn(name="id_analista")
	private Analista analista;	
	
	@ManyToOne
	@JoinColumn(name="id_horario")
	private Horario horario; 

	@Column(name="data_consulta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataConsulta;
	
	public Especialidade getEspecialidade() {
		System.out.println("Agendamento 0001");
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
		System.out.println("Agendamento 0002");
	}

	public Medico getMedico() {
		System.out.println("Agendamento 0003");
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
		System.out.println("Agendamento 0004");
	}

	public Analista getAnalista() {
		System.out.println("Agendamento 0005");
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
		System.out.println("Agendamento 0006");
	}

	public LocalDate getDataConsulta() {
		System.out.println("Agendamento 0007");
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
		System.out.println("Agendamento 0008");
	}

	public Horario getHorario() {
		System.out.println("Agendamento 0009");
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
		System.out.println("Agendamento 0010");
	}
}
