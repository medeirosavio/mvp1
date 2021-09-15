package com.teste.mvp1.service;

import com.teste.mvp1.DTO.TrocaDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Recurso;
import com.teste.mvp1.model.Troca;

import java.util.List;
import java.util.Optional;

public interface TrocaService {

    boolean trocaPontos(int pontos,int pontosTrocar);

    Troca efetuarTroca(TrocaDTO trocaDTO);

    void salvarTroca(Troca troca);

    List<Recurso> copiaRecursos(Hospital hospital);

    void trocaRecursos(Hospital hospital,List<Recurso> recursos);

    List<Troca> listarTrocas();

    Optional<Troca> findById(long id);
}
