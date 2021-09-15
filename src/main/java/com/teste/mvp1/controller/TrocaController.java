package com.teste.mvp1.controller;

import com.teste.mvp1.DTO.TrocaDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Recurso;
import com.teste.mvp1.model.Troca;
import com.teste.mvp1.service.HospitalService;
import com.teste.mvp1.service.TrocaService;
import com.teste.mvp1.util.ErroHospital;
import com.teste.mvp1.util.ErroTroca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trocacontroller")
@CrossOrigin
public class TrocaController {

    @Autowired
    TrocaService trocaService;

    @Autowired
    HospitalService hospitalService;

    @RequestMapping(value = "/trocas",method = RequestMethod.POST)
    public ResponseEntity<?> efetuaTroca(@RequestBody TrocaDTO trocaDTO){

        Optional<Hospital> optionalHospital1 = hospitalService.getHospitalById(trocaDTO.getIdHospital1());
        Optional<Hospital> optionalHospital2 = hospitalService.getHospitalById(trocaDTO.getIdHospital2());

        if(!optionalHospital1.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(trocaDTO.getIdHospital1());
        }

        if(!optionalHospital2.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(trocaDTO.getIdHospital2());
        }

        Hospital hospital1 = optionalHospital1.get();
        Hospital hospital2 = optionalHospital2.get();
        Troca troca = trocaService.efetuarTroca(trocaDTO);

        int pontos1 = hospital1.getPontos();
        int pontos2 = hospital2.getPontos();

        trocaService.trocaPontos(pontos1,pontos2);
        trocaService.salvarTroca(troca);
        List<Recurso> copiados1 = trocaService.copiaRecursos(hospital1);
        List<Recurso> copiados2 = trocaService.copiaRecursos(hospital2);
        hospitalService.removerRecursos(trocaDTO.getIdHospital1());
        hospitalService.removerRecursos(trocaDTO.getIdHospital2());
        trocaService.trocaRecursos(hospital1,copiados2);
        trocaService.trocaRecursos(hospital2,copiados1);
        hospitalService.salvarHospital(hospital1);
        hospitalService.salvarHospital(hospital2);

        return new ResponseEntity<Troca>(troca, HttpStatus.CREATED);
    }

    @RequestMapping(value = "trocas/exibir", method = RequestMethod.GET)
    public ResponseEntity<?> listarTrocas(){

        List<Troca> trocas = trocaService.listarTrocas();

        if(trocas.isEmpty()){
            return ErroTroca.erroSemTrocasCadastrados();
        }

        return new ResponseEntity<List<Troca>>(trocas,HttpStatus.OK);
    }

    @RequestMapping(value = "trocas/exibir/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> exibirTroca(@PathVariable("id") long id){

        Optional<Troca> trocaOptional = trocaService.findById(id);

        if(!trocaOptional.isPresent()){
            return ErroTroca.erroTrocaNaoEncontrado(id);
        }

        Troca troca = trocaOptional.get();

        return new ResponseEntity<Troca>(troca,HttpStatus.OK);
    }


}
