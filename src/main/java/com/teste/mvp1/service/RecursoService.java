package com.teste.mvp1.service;

import com.teste.mvp1.DTO.RecursoDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Recurso;

import java.util.List;
import java.util.Optional;

public interface RecursoService {

    Optional<Recurso> getRecursoById(long id);

    void salvarRecurso(Recurso recurso);

    void removerRecurso(Recurso recurso);

    List<Recurso> listarRecursos();

    Recurso cadastrarRecurso(RecursoDTO recursoDTO);


    void adicionaHospital(Recurso recurso, Hospital hospital);

}
