/**Representação de um hospital,
 * o hospital possui um identificador único que é seu id, além de um cnpj, também único
 */

package com.teste.mvp1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private long cnpj;
    private String latitude;
    private String longitude;
    private String email;
    private long fone;
    private String ocupacao;

    @OneToMany
    private List<Recurso> recursos;

    @OneToMany
    private List<Paciente> pacientes;

    public Hospital(String nome,String endereco,long cnpj,String latitude,String longitude,
                    String email,long fone,List<Long> recursos,String ocupacao){
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this. fone = fone;
        this.recursos = new ArrayList<>();
    }

    public Hospital() {

    }

    /**Método utilizado para alterar a ocupação do hospital**/
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return cnpj == hospital.cnpj && id.equals(hospital.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj);
    }

    /**Método utilizado para cadastrar um paciente do hospital,
     * este paciente está vinculado a este hospital
     @param paciente
     */
    public void adicionaPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    /**Método utilizado para cadastrar um recurso do hospital,
     * este recurso pode ser do tipo material ou humano. e está vinculado ao hospital
     * @param recurso
     */
    public void adicionaRecurso(Recurso recurso) {
        this.recursos.add(recurso);
    }

    /**Método utilizado para contabilizar os pontos
     * dos recursos disponiveis no hospital, uma vez que se necessário uma troca
     * com recursos de outros hospitais será feita
     * @return os pontos dos recursos do hospital
     */
    public int getPontos() {
        int pontos = 0;
        for(int i=0;i<recursos.size();i++){
            pontos+=recursos.get(i).getPontos();
        }
        return pontos;
    }

    /**Método utilizado para remover um recurso do hospital,
     * o recurso so pode ser removido por meio de intercambio
     * com outro hospital
     */
    public void removeRecursos() {
        recursos.clear();
    }

    /**Método utilizado para criar uma lista que armazena os atuais
     * recursos do hospital, o método é util em uma troca do hospital
     * @return a lista com os recursos disponiveis do hospital
     */
    public List<Recurso> copiarRecursos() {
        List<Recurso> copiar = new ArrayList<>();
        for(int i=0;i<recursos.size();i++){
            copiar.add(recursos.get(i));
        }
        return copiar;
    }
}
