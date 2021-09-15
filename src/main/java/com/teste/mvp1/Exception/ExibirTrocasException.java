package com.teste.mvp1.Exception;

public class ExibirTrocasException extends RuntimeException{

    public static final String EXCEPTION_CODE_EXIBICAO_TROCAS = "Sem trocas cadastradas no sistema";

    public ExibirTrocasException(){
        super(EXCEPTION_CODE_EXIBICAO_TROCAS);
    }
}
