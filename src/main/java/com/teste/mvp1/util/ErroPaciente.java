package com.teste.mvp1.util;

import com.teste.mvp1.DTO.PacienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroPaciente {

    static final String PACIENTE_NAO_CASTRADO = "Paciente com id %s não está cadastrado";

    static final String PACIENTES_NAO_CASTRADOS = "Não há pacientes cadastrados";

    static final String PACIENTE_JA_CADASTRADO = "O paciente %s nome %s já esta cadastrado";

    public static ResponseEntity<CustomErrorType> erroPacienteNaoEncontrado(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroPaciente.PACIENTE_NAO_CASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<CustomErrorType> erroSemPacientesCadastrados() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroPaciente.PACIENTES_NAO_CASTRADOS),
                HttpStatus.NO_CONTENT);
    }


    public static ResponseEntity<?> erroPacienteJaCadastrado(PacienteDTO pacienteDTO) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroPaciente.PACIENTE_JA_CADASTRADO,
                pacienteDTO.getCpf(), pacienteDTO.getNome())), HttpStatus.CONFLICT);
    }

}
