package com.teste.mvp1.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroRecurso {

    static final String RECURSO_NAO_CASTRADO = "Recurso com id %s não está cadastrado";

    static final String RECURSOS_NAO_CASTRADOS = "Não há recursos cadastrados";


    public static ResponseEntity<CustomErrorType> erroRecursoNaoEncontrado(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroRecurso.RECURSO_NAO_CASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<CustomErrorType> erroSemRecursosCadastrados() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroRecurso.RECURSOS_NAO_CASTRADOS),
                HttpStatus.NO_CONTENT);
    }





}
