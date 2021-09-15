package com.teste.mvp1.service;

import com.teste.mvp1.DTO.RecursoDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Recurso;
import com.teste.mvp1.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    @Override
    public Optional<Recurso> getRecursoById(long id) {
        return recursoRepository.findRecursoById(id);
    }

    @Override
    public void salvarRecurso(Recurso recurso) {
        recursoRepository.save(recurso);
    }

    @Override
    public void removerRecurso(Recurso recurso) {
        recursoRepository.delete(recurso);
    }

    @Override
    public List<Recurso> listarRecursos() {
        return recursoRepository.findAll();
    }

    @Override
    public Recurso cadastrarRecurso(RecursoDTO recursoDTO) {
        Recurso recurso = new Recurso(recursoDTO.getTipo(),recursoDTO.getPontos());
        return recurso;
    }


    @Override
    public void adicionaHospital(Recurso recurso, Hospital hospital) {
        recurso.setHospital(hospital);
    }
}
