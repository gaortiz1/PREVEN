/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roberto
 */
@Embeddable
public class DegreePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "id_degree")
    private int idDegree;
    @Basic(optional = false)
    @Column(name = "id_leveleducation")
    private int idLeveleducation;

    public DegreePK() {
    }

    public DegreePK(int idDegree, int idLeveleducation) {
        this.idDegree = idDegree;
        this.idLeveleducation = idLeveleducation;
    }

    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
    }

    public int getIdLeveleducation() {
        return idLeveleducation;
    }

    public void setIdLeveleducation(int idLeveleducation) {
        this.idLeveleducation = idLeveleducation;
    }
}
