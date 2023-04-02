package com.ifrs17.bradseg.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ifrs17.bradseg.dominio.Perfil;

@Component
public class PerfisConverter implements Converter<String[], List<Perfil>>{

	@Override
	public List<Perfil> convert(String[] source) {
		System.out.println("PerfisConverter 0001");
		List<Perfil> perfis = new ArrayList<>();
		for (String id : source) {
			if (!id.equals("0")) {
				perfis.add(new Perfil(Long.parseLong(id)));
			}
		}
		return perfis;
	}
}
