package com.ifrs17.bradseg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifrs17.bradseg.dominio.General;

import java.util.List;

@Repository
public interface GeneralRepository extends JpaRepository<General, Integer> {

    public boolean existsByEmail(String email);

    public List<General> findByEmail(String email);

    @Query("select max(g.id) from General g")
    public Integer findMaxId();
}
