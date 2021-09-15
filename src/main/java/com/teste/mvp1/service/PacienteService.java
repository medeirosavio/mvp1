package com.teste.mvp1.service;

import com.teste.mvp1.DTO.PacienteDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    public Optional<Paciente> getPacienteById(long id);

    public void salvarPaciente(Paciente paciente);

    public void removerPaciente(Paciente paciente);

    public List<Paciente> listarPacientes();

    public Paciente cadastrarPaciente(PacienteDTO pacienteDTO);

    public Paciente atualizarPaciente(PacienteDTO pacienteDTO,Paciente paciente);

    Optional<Paciente> getPacienteByCpf(long cpf);

    public void adicionarHospital(Hospital hospital,Long id);
}
