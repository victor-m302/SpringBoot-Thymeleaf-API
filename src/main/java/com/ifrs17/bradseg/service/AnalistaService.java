package com.ifrs17.bradseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifrs17.bradseg.dominio.Analista;
import com.ifrs17.bradseg.repository.AnalistaRepository;

@Service
public class AnalistaService {

	@Autowired
	private AnalistaRepository repository;
	
	@Transactional(readOnly = true)
	public Analista buscarPorUsuarioEmail(String email) {
		System.out.println("AnalistaService 0001");
		return repository.findByUsuarioEmail(email).orElse(new Analista());
	}

	@Transactional(readOnly = false)
	public void salvar(Analista analista) {
		System.out.println("AnalistaService 0002");
		repository.save(analista);		
	}

	@Transactional(readOnly = false)
	public void editar(Analista analista) {
		Analista p2 = repository.findById(analista.getId()).get();
		p2.setNome(analista.getNome());
		p2.setDtInscricao(analista.getDtInscricao());		
		System.out.println("AnalistaService 0003");
	}
}
