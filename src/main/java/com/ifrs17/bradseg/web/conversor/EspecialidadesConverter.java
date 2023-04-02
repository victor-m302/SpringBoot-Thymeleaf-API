package com.ifrs17.bradseg.web.conversor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ifrs17.bradseg.dominio.Especialidade;
import com.ifrs17.bradseg.service.EspecialidadeService;

@Component
public class EspecialidadesConverter implements Converter<String[], Set<Especialidade>> {

	@Autowired
	private EspecialidadeService service;

	@Override
	public Set<Especialidade> convert(String[] titulos) {
		
		Set<Especialidade> especialidades = new HashSet<>();
		if (titulos != null && titulos.length > 0) {
			especialidades.addAll(service.buscarPorTitulos(titulos));			
		}
		System.out.println("PerfisConverter 0001");
		return especialidades;
	}
}
