package com.teste.mvp1.repository;

import com.teste.mvp1.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findPacienteById(long id);

    Optional<Paciente> findPacienteByCpf(long cpf);
}
