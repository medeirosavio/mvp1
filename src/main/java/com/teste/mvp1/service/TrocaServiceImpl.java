package com.teste.mvp1.service;

import com.teste.mvp1.DTO.TrocaDTO;
import com.teste.mvp1.Exception.ConsultarTrocaException;
import com.teste.mvp1.Exception.TrocaPontosException;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Recurso;
import com.teste.mvp1.model.Troca;
import com.teste.mvp1.repository.HospitalRepository;
import com.teste.mvp1.repository.TrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrocaServiceImpl implements TrocaService{

    @Autowired
    TrocaRepository trocaRepository;

    @Autowired
    HospitalRepository hospitalRepository;


    @Override
    public boolean trocaPontos(int pontos, int pontosTrocar) {
        boolean retorno = false;
        if(pontos!=pontosTrocar){
            throw new IllegalStateException(TrocaPontosException.EXCEPTION_CODE_PONTOS);
        }
        retorno = true;
        return retorno;
    }

    @Override
    public Troca efetuarTroca(TrocaDTO trocaDTO) {
        Troca troca = new Troca(trocaDTO.getIdHospital1(),trocaDTO.getIdHospital2(),trocaDTO.getIdrecursos1()
                                ,trocaDTO.getIdrecursos2(),trocaDTO.getData());
        return troca;
    }

    @Override
    public void salvarTroca(Troca troca) {
        trocaRepository.save(troca);
    }

    @Override
    public List<Recurso> copiaRecursos(Hospital hospital) {
        return hospital.copiarRecursos();
    }

    @Override
    public void trocaRecursos(Hospital hospital,List<Recurso> recursos) {
        for(int i=0;i<recursos.size();i++){
            hospital.adicionaRecurso(recursos.get(i));
        }

    }

    @Override
    public List<Troca> listarTrocas() {
        List<Troca> trocas = trocaRepository.findAll();
        return trocas;
    }

    @Override
    public Optional<Troca> findById(long id) {
        Optional<Troca> trocaOptional = trocaRepository.findById(id);
        return trocaOptional;
    }

}
