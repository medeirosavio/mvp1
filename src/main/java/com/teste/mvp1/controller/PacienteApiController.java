package com.teste.mvp1.controller;

import com.teste.mvp1.DTO.PacienteDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Paciente;
import com.teste.mvp1.service.HospitalService;
import com.teste.mvp1.service.PacienteService;
import com.teste.mvp1.util.ErroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controllerpaciente")
@CrossOrigin

public class PacienteApiController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    HospitalService hospitalService;


    @RequestMapping(value = "/pacientes/{idHospital}/cadastrar", method = RequestMethod.POST )
    public ResponseEntity<?> cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO
                                                ,@PathVariable("idHospital")long idHospital){

        Optional<Paciente> pacienteOptional = pacienteService.getPacienteByCpf(pacienteDTO.getCpf());
        Optional<Hospital> hospitalOptional = hospitalService.getHospitalById(idHospital);

        if(!pacienteOptional.isEmpty()){
            return ErroPaciente.erroPacienteJaCadastrado(pacienteDTO);
        }

        Paciente paciente = pacienteService.cadastrarPaciente(pacienteDTO);
        pacienteService.adicionarHospital(hospitalOptional.get(),paciente.getId());
        pacienteService.salvarPaciente(paciente);
        hospitalService.adicionarPaciente(paciente,idHospital);

        return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pacientes/remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removerPaciente(@PathVariable("id") long id){

        Optional<Paciente> pacienteOptional = pacienteService.getPacienteById(id);

        pacienteService.removerPaciente(pacienteOptional.get());

        return new ResponseEntity<Paciente>(HttpStatus.OK);
    }

    @RequestMapping(value = "/pacientes/exibir", method = RequestMethod.GET)
    public ResponseEntity<?> listarPacientes(){

        List<Paciente> pacientes = pacienteService.listarPacientes();

        return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.OK);
    }

    @RequestMapping(value = "/pacientes/exibir/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> exibirPaciente(@PathVariable("id") long id){

        Optional<Paciente> pacienteOptional = pacienteService.getPacienteById(id);

        return new ResponseEntity<Paciente>(pacienteOptional.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/pacientes/atualizar/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarPaciente(@PathVariable("id")long id,@RequestBody PacienteDTO pacienteDTO){

        Optional<Paciente> pacienteOptional = pacienteService.getPacienteById(id);

        Paciente paciente = pacienteOptional.get();

        pacienteService.atualizarPaciente(pacienteDTO,paciente);
        pacienteService.salvarPaciente(paciente);

        return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
    }

}
