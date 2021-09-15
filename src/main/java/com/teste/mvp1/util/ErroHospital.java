package com.teste.mvp1.util;

import com.teste.mvp1.DTO.HospitalDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ErroHospital {

    static final String HOSPITAL_NAO_CASTRADO = "Hospital com id %s não está cadastrado";

    static final String HOSPITAIS_NAO_CASTRADOS = "Não há hospitais cadastrados";

    static final String HOSPITAL_JA_CADASTRADO = "O hospital %s nome %s já esta cadastrado";

    public static ResponseEntity<CustomErrorType> erroHospitalNaoEncontrado(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroHospital.HOSPITAL_NAO_CASTRADO
                , id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<CustomErrorType> erroSemHospitaisCadastrados() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroHospital.HOSPITAIS_NAO_CASTRADOS),
                HttpStatus.NO_CONTENT);
    }


    public static ResponseEntity<?> erroHospitalJaCadastrado(HospitalDTO hospitalDTO) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroHospital.HOSPITAL_JA_CADASTRADO,
                hospitalDTO.getCnpj(), hospitalDTO.getNome())), HttpStatus.CONFLICT);
    }

}
