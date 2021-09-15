package com.teste.mvp1.controller;

import com.teste.mvp1.DTO.RecursoDTO;
import com.teste.mvp1.model.Hospital;
import com.teste.mvp1.model.Recurso;
import com.teste.mvp1.service.HospitalService;
import com.teste.mvp1.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controllerrecurso")
@CrossOrigin

public class RecursoApiController {

    @Autowired
    RecursoService recursoService;

    @Autowired
    HospitalService hospitalService;

    @RequestMapping(value = "recursos/{idHospital}/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarRecurso(@RequestBody RecursoDTO recursoDTO
            ,@PathVariable ("idHospital") long idHospital){

        Optional<Hospital> optionalHospital = hospitalService.getHospitalById(idHospital);

        Recurso recurso = recursoService.cadastrarRecurso(recursoDTO);
        recursoService.adicionaHospital(recurso,optionalHospital.get());
        recursoService.salvarRecurso(recurso);
        hospitalService.adicionarRecurso(recurso,idHospital);

        return new ResponseEntity<Recurso>(recurso, HttpStatus.CREATED);
    }

    @RequestMapping(value = "recursos/remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removerRecurso(@PathVariable("id") long id){

        Optional<Recurso> recursoOptional = recursoService.getRecursoById(id);

        Recurso recurso = recursoOptional.get();
        recursoService.removerRecurso(recurso);

        return new ResponseEntity<Recurso>(HttpStatus.OK);
    }

    @RequestMapping(value = "recursos/exibir", method = RequestMethod.GET)
    public ResponseEntity<?> listarRecursos(){

        List<Recurso> recursos = recursoService.listarRecursos();

        return new ResponseEntity<List<Recurso>>(recursos, HttpStatus.OK);
    }

    @RequestMapping(value = "recursos/exibir/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> exibirRecurso(@PathVariable("id") long id){

        Optional<Recurso> recursoOptional = recursoService.getRecursoById(id);

        return new ResponseEntity<Recurso>(recursoOptional.get(),HttpStatus.OK);
    }


}
