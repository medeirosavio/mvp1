package com.teste.mvp1.service;

import com.teste.mvp1.DTO.HospitalDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Paciente;
import com.teste.mvp1.model.Recurso;

import java.util.List;
import java.util.Optional;

public interface HospitalService {

    Optional<Hospital> getHospitalById(long id);

    Optional<Hospital> getHospitalByCnpj(long cnpj);

    void salvarHospital(Hospital hospital);

    void removerHospital(Hospital hospital);

    List<Hospital> listarHospitais();

    Hospital cadastraHospital(HospitalDTO hospitalDTO);

    Hospital atualizarHospital(HospitalDTO hospitalDTO,Hospital hospital);

    Paciente adicionarPaciente(Paciente paciente,long id);

    Recurso adicionarRecurso(Recurso recurso,long id);

    int somarPontos(Hospital hospital);

    void removerRecursos(long id);
}
