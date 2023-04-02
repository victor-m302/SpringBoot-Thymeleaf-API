package com.ifrs17.bradseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifrs17.bradseg.dominio.Paciente;
import com.ifrs17.bradseg.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Transactional(readOnly = true)
	public Paciente buscarPorUsuarioEmail(String email) {
		System.out.println("PacienteService 0001");
		return repository.findByUsuarioEmail(email).orElse(new Paciente());
	}

	@Transactional(readOnly = false)
	public void salvar(Paciente paciente) {
		System.out.println("PacienteService 0002");
		repository.save(paciente);		
	}

	@Transactional(readOnly = false)
	public void editar(Paciente paciente) {
		Paciente p2 = repository.findById(paciente.getId()).get();
		p2.setNome(paciente.getNome());
		p2.setDtNascimento(paciente.getDtNascimento());		
		System.out.println("PacienteService 0003");
	}
}
