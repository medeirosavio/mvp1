package com.teste.mvp1.repository;

import com.teste.mvp1.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecursoRepository extends JpaRepository<Recurso,Long> {

    Optional<Recurso> findRecursoById(long id);

}
