package com.teste.mvp1.DTO;

import com.teste.mvp1.model.Recurso;

import java.util.List;

public class HospitalDTO {

    private String nome;
    private String endereco;
    private long cnpj;
    private String latitude;
    private String longitude;
    private String email;
    private long fone;
    private List<Long> recursos;
    private String ocupacao;


    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getCnpj() {
        return cnpj;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getEmail() {
        return email;
    }

    public long getFone() {
        return fone;
    }

    public List<Long> getRecursos() {
        return recursos;
    }

    public String getOcupacao() {
        return ocupacao;
    }
}
