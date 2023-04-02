package com.ifrs17.bradseg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifrs17.bradseg.dominio.Analista;

public interface AnalistaRepository extends JpaRepository<Analista, Long> {

	@Query("select a from Analista a where a.usuario.email like :email")
	Optional<Analista> findByUsuarioEmail(String email);
}
