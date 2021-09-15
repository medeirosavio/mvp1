package com.teste.mvp1.Exception;

public class TrocaPontosException extends RuntimeException{

    public static final String EXCEPTION_CODE_PONTOS = "Troca não permiida, pontos não são iguais";

    public TrocaPontosException(){
        super(EXCEPTION_CODE_PONTOS);
    }

}
