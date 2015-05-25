/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.criteria.test.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roberto
 */
@Embeddable
public class SubcompanyPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "id_company")
    private long idCompany;
    @Basic(optional = false)
    @Column(name = "id_subcompany")
    private long idSubcompany;

    public SubcompanyPK() {
    }

    public SubcompanyPK(long idCompany, long idSubcompany) {
        this.idCompany = idCompany;
        this.idSubcompany = idSubcompany;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public long getIdSubcompany() {
        return idSubcompany;
    }

    public void setIdSubcompany(long idSubcompany) {
        this.idSubcompany = idSubcompany;
    }
}
