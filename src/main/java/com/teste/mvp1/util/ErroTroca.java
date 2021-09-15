package com.teste.mvp1.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroTroca {

    static final String TROCA_NAO_EFETUADA = "Trca com id %s não está cadastrada no sistema";

    static final String TROCASS_NAO_CASTRADAS = "Não há trocas cadastradas";

    public static ResponseEntity<CustomErrorType> erroTrocaNaoEncontrado(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroTroca.TROCA_NAO_EFETUADA, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<CustomErrorType> erroSemTrocasCadastrados() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroTroca.TROCASS_NAO_CASTRADAS),
                HttpStatus.NO_CONTENT);
    }

}
