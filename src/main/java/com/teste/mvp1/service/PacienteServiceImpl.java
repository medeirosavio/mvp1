package com.teste.mvp1.service;

import com.teste.mvp1.DTO.PacienteDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Paciente;
import com.teste.mvp1.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<Paciente> getPacienteById(long id) {
        return pacienteRepository.findPacienteById(id);
    }

    @Override
    public Optional<Paciente> getPacienteByCpf(long cpf) {
        return pacienteRepository.findPacienteByCpf(cpf);
    }

    @Override
    public void adicionarHospital(Hospital hospital,Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findPacienteById(id);
        Paciente paciente = optionalPaciente.get();
        paciente.setHospital(hospital);
    }

    @Override
    public void salvarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void removerPaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente cadastrarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO.getNome(),pacienteDTO.getCpf(),pacienteDTO.getIdade()
                ,pacienteDTO.getEndereco(), pacienteDTO.getFone()
                ,pacienteDTO.getEmail(),pacienteDTO.getConvenio());


        return paciente;
    }

    @Override
    public Paciente atualizarPaciente(PacienteDTO pacienteDTO, Paciente paciente) {
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setFone(pacienteDTO.getFone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setConvenio(pacienteDTO.getConvenio());

        return paciente;
    }


}
