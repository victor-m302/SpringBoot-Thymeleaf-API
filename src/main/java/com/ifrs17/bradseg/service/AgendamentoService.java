package com.ifrs17.bradseg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifrs17.bradseg.datatables.Datatables;
import com.ifrs17.bradseg.datatables.DatatablesColunas;
import com.ifrs17.bradseg.dominio.Agendamento;
import com.ifrs17.bradseg.dominio.Horario;
import com.ifrs17.bradseg.exception.AcessoNegadoException;
import com.ifrs17.bradseg.repository.AgendamentoRepository;
import com.ifrs17.bradseg.repository.projection.HistoricoPaciente;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = true)
	public List<Horario> buscarHorariosNaoAgendadosPorMedicoIdEData(Long id, LocalDate data) {
		System.out.println("AgendamentoService 0001");
		return repository.findByMedicoIdAndDataNotHorarioAgendado(id, data);
	}

	@Transactional(readOnly = false)
	public void salvar(Agendamento agendamento) {
		System.out.println("AgendamentoService 0002");
		repository.save(agendamento);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarHistoricoPorPacienteEmail(String email, HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.AGENDAMENTOS);
		Page<HistoricoPaciente> page = repository.findHistoricoByPacienteEmail(email, datatables.getPageable());
		System.out.println("AgendamentoService 0003");
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarHistoricoPorMedicoEmail(String email, HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.AGENDAMENTOS);
		Page<HistoricoPaciente> page = repository.findHistoricoByMedicoEmail(email, datatables.getPageable());
		System.out.println("AgendamentoService 0004");
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public Agendamento buscarPorId(Long id) {
		System.out.println("AgendamentoService 0005");
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void editar(Agendamento agendamento, String email) {
		Agendamento ag = buscarPorIdEUsuario(agendamento.getId(), email);
		ag.setDataConsulta(agendamento.getDataConsulta());
		ag.setEspecialidade(agendamento.getEspecialidade());
		ag.setHorario(agendamento.getHorario());
		ag.setMedico(agendamento.getMedico());
		System.out.println("AgendamentoService 0006");
	}

	@Transactional(readOnly = true)
	public Agendamento buscarPorIdEUsuario(Long id, String email) {
		System.out.println("AgendamentoService 0007");
		return repository
				.findByIdAndPacienteOrMedicoEmail(id, email)
				.orElseThrow(() -> new AcessoNegadoException("Acesso negado ao usuário: " + email));
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		repository.deleteById(id);
		System.out.println("AgendamentoService 0008");
	}

}
