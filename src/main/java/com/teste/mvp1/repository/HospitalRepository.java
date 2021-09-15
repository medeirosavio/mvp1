package com.teste.mvp1.repository;

import com.teste.mvp1.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {

    Optional<Hospital> findById(long id);

    Optional<Hospital> findByCnpj(long cnpj);
}
