package com.ifrs17.bradseg.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifrs17.bradseg.datatables.Datatables;
import com.ifrs17.bradseg.datatables.DatatablesColunas;
import com.ifrs17.bradseg.dominio.Especialidade;
import com.ifrs17.bradseg.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvar(Especialidade especialidade) {
		repository.save(especialidade);
		System.out.println("EspecialidadeService 0001");
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarEspecialidades(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.ESPECIALIDADES);
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findAllByTitulo(datatables.getSearch(), datatables.getPageable());
		System.out.println("EspecialidadeService 0002");
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public Especialidade buscarPorId(Long id) {
		System.out.println("EspecialidadeService 0003");
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		System.out.println("EspecialidadeService 0004");
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<String> buscarEspecialidadeByTermo(String termo) {
		System.out.println("EspecialidadeService 0005");
		return repository.findEspecialidadesByTermo(termo);
	}

	@Transactional(readOnly = true)
	public Set<Especialidade> buscarPorTitulos(String[] titulos) {
		System.out.println("EspecialidadeService 0006");
		return repository.findByTitulos(titulos);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarEspecialidadesPorMedico(Long id, HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.ESPECIALIDADES);
		Page<Especialidade> page = repository.findByIdMedico(id, datatables.getPageable()); 
		System.out.println("EspecialidadeService 0007");
		return datatables.getResponse(page);
	}
	
	
}
