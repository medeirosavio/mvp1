/**Representação do intercâmbio de recursos
 * entre hospitais
 */

package com.teste.mvp1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Troca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long idHospital1;
    private long idHospital2;
    private int idrecursos1;
    private int idrecursos2;
    private String data;

    public Troca(long idHospital1,long idHospital2,int idrecursos1,int idrecursos2,String data){
        this.idHospital1 = idHospital1;
        this.idHospital2 = idHospital2;
        this.idrecursos1 = idrecursos1;
        this.idrecursos2 = idrecursos2;
        this.data = data;
    }


    public Troca() {

    }
}
