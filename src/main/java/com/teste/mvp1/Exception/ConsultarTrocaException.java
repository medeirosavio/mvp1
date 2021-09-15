package com.teste.mvp1.Exception;

public class ConsultarTrocaException extends RuntimeException{

    public static final String ERRO_EXIBIR_TROCA = "Troca não existente";

    public ConsultarTrocaException(){super(ExibirTrocasException.EXCEPTION_CODE_EXIBICAO_TROCAS);}

}
