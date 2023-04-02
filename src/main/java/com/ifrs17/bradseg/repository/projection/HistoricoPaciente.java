package com.ifrs17.bradseg.repository.projection;

import com.ifrs17.bradseg.dominio.Especialidade;
import com.ifrs17.bradseg.dominio.Medico;
import com.ifrs17.bradseg.dominio.Paciente;

public interface HistoricoPaciente {

	Long getId();
	
	Paciente getPaciente();
	
	String getDataConsulta();
	
	Medico getMedico();
	
	Especialidade getEspecialidade();
}
