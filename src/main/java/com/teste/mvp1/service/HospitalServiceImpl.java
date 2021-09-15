package com.teste.mvp1.service;

import com.teste.mvp1.DTO.HospitalDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Paciente;
import com.teste.mvp1.model.Recurso;
import com.teste.mvp1.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Optional<Hospital> getHospitalById(long id) {
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(id);

        return hospitalOptional;
    }

    @Override
    public Optional<Hospital> getHospitalByCnpj(long cnpj) {
        Optional<Hospital> hospitalOptional = hospitalRepository.findByCnpj(cnpj);

        return hospitalOptional;
    }

    @Override
    public void salvarHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }


    @Override
    public void removerHospital(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }

    @Override
    public List<Hospital> listarHospitais() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital cadastraHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = new Hospital(hospitalDTO.getNome(),hospitalDTO.getEndereco(),
                hospitalDTO.getCnpj(),hospitalDTO.getLatitude(),hospitalDTO.getLongitude(),
                hospitalDTO.getEmail(),hospitalDTO.getFone(),hospitalDTO.getRecursos(),hospitalDTO.getOcupacao());
        return hospital;
    }

    @Override
    public Hospital atualizarHospital(HospitalDTO hospitalDTO, Hospital hospital) {
        hospital.setOcupacao(hospitalDTO.getOcupacao());
        return hospital;
    }

    @Override
    public Paciente adicionarPaciente(Paciente paciente,long id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        hospital.adicionaPaciente(paciente);
        return paciente;
    }

    @Override
    public Recurso adicionarRecurso(Recurso recurso,long id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        hospital.adicionaRecurso(recurso);
        return recurso;
    }

    @Override
    public int somarPontos(Hospital hospital) {
        return hospital.getPontos();
    }

    @Override
    public void removerRecursos(long id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        hospital.removeRecursos();
    }


}
