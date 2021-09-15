package com.teste.mvp1.controller;

import com.teste.mvp1.DTO.HospitalDTO;
import com.teste.mvp1.DTO.PacienteDTO;
import com.teste.mvp1.DTO.RecursoDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Paciente;
import com.teste.mvp1.service.HospitalService;
import com.teste.mvp1.service.PacienteService;
import com.teste.mvp1.service.RecursoService;
import com.teste.mvp1.util.ErroHospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controllerhospital")
@CrossOrigin

public class HospitalApiController {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    RecursoService recursoService;

    @RequestMapping(value="/hospitais/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarHospital(@RequestBody HospitalDTO hospitalDTO){

        Optional<Hospital> hospitalOptional = hospitalService.getHospitalByCnpj(hospitalDTO.getCnpj());

        if(!hospitalOptional.isEmpty()){
            return ErroHospital.erroHospitalJaCadastrado(hospitalDTO);
        }

        Hospital hospital = hospitalService.cadastraHospital(hospitalDTO);
        hospitalService.salvarHospital(hospital);

        return new ResponseEntity<Hospital>(hospital, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hospitais/remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removerHospital(@PathVariable("id") long id){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(id);

        if(!optionalHospital.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(id);
        }

        hospitalService.removerHospital(optionalHospital.get());

        return new ResponseEntity<Hospital>(HttpStatus.OK);
    }

    @RequestMapping(value = "/hospitais/exibir",method = RequestMethod.GET)
    public ResponseEntity<?> listarHospitais(){

        List<Hospital> hospitais = hospitalService.listarHospitais();

        if(hospitais.isEmpty()){
            return ErroHospital.erroSemHospitaisCadastrados();
        }

        return new ResponseEntity<List<Hospital>>(hospitais, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospitais/exibir/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> exibirHospital(@PathVariable("id") long id){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(id);

        if(!optionalHospital.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(id);
        }

        return new ResponseEntity<Hospital>(optionalHospital.get(),HttpStatus.OK);
    }

    @RequestMapping(value = "/hospitais/atualizar/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarHospital(@PathVariable("id") long id,@RequestBody HospitalDTO hospitalDTO){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(id);

        if(!optionalHospital.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(id);
        }

        Hospital hospital = optionalHospital.get();

        hospitalService.atualizarHospital(hospitalDTO,hospital);
        hospitalService.salvarHospital(hospital);

        return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospitais/cadastrar/{id}/paciente", method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarPaciente(@PathVariable("id")long id, @RequestBody PacienteDTO pacienteDTO){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(id);

        if(!optionalHospital.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(id);
        }

        pacienteService.cadastrarPaciente(pacienteDTO);
        hospitalService.salvarHospital(optionalHospital.get());

        return new ResponseEntity<Paciente>(pacienteService.cadastrarPaciente(pacienteDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/hospitais/cadastrar/{id}/recurso",method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarRecurso(@PathVariable("id")long id, @RequestBody RecursoDTO recursoDTO){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(id);

        if(!optionalHospital.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(id);
        }

        recursoService.cadastrarRecurso(recursoDTO);
        hospitalService.salvarHospital(optionalHospital.get());

        return new ResponseEntity<Hospital>(optionalHospital.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/hospitais/{id}/recursos/pontuacao",method = RequestMethod.GET)
    private ResponseEntity<?> pontosHospital(@PathVariable("id")long id){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(id);

        if(!optionalHospital.isPresent()){
            return ErroHospital.erroHospitalNaoEncontrado(id);
        }

        int pontos = hospitalService.somarPontos(optionalHospital.get());

        return new ResponseEntity<Integer>(pontos, HttpStatus.OK);
    }



}
