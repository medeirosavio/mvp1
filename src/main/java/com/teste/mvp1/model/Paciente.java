/**Representação de um paciente do Hospital
 *
 */

package com.teste.mvp1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private long cpf;
    private int idade;
    private String endereco;
    private long fone;
    private String email;
    private String convenio;

    @ManyToOne
    private Hospital hospital;

    public Paciente(String nome,long cpf,int idade,String endereco,long fone
            ,String email,String convenio){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.fone = fone;
        this.email = email;
        this.convenio = convenio;
    }

    public Paciente() {

    }

    /**Método que altera o cadastro do endereço do paciente no hospital
     * @param endereco é o novo endereço
     */

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**Método que altera o cadastro do telefone do paciente no hospital
     * @param fone é o novo telefone
     */

    public void setFone(long fone) {
        this.fone = fone;
    }

    /**Método que altera o cadastro do email do paciente no hospital
     * @param email é o novo email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**Método que altera o cadastro do convenio do paciente no hospital
     * @param convenio é o novo convenio
     */

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    /**Método que é responsável por vincular o paciente ao hospital,
     * uma vez que um paciente só pode estar em um hospital, e na
     * criação do mesmo o hospital é alterado por meio deste método
     * @param hospital
     */

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    /**Método que fornece o id do Paciente
     * @return o id do Paciente
     */

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return cpf == paciente.cpf && id.equals(paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
