/**Representação de um recurso que está disponível
 * no Hospital, o recurso está diretamente associado
 * ao hospital
 */

package com.teste.mvp1.model;

import javax.persistence.*;

@Entity
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private int pontos;

    @ManyToOne
    Hospital hospital;

    public Recurso(String tipo,int pontos){
        this.tipo = tipo;
        this.pontos = pontos;
    }

    public Recurso() {

    }

    /**Método que retorna a quantidade de pontos
     * de um recurso
     * @return quantidade de pontos do recurso
     */
    public int getPontos() {
        return pontos;
    }


    /**Método utilizado na criação do recurso
     * para associar o recurso ao hospital do mesmo
     * @param hospital é o hospital em que o recurso está alocado
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
