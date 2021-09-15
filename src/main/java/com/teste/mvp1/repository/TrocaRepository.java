package com.teste.mvp1.repository;

import com.teste.mvp1.model.Troca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrocaRepository extends JpaRepository<Troca,Long> {

    Optional<Troca> findById(long id);


}
