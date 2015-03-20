/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "activity_economic_company")
@NamedQueries({
    @NamedQuery(name = "ActivityEconomicCompany.findAll", query = "SELECT a FROM ActivityEconomicCompany a")})
public class ActivityEconomicCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_activity_economic")
    private Integer idActivityEconomic;
    @Basic(optional = false)
    @Column(name = "name_activity_economic")
    private String nameActivityEconomic;
    @Basic(optional = false)
    @Column(name = "status_activityeconomic")
    private boolean statusActivityeconomic;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    public ActivityEconomicCompany() {
    }

    public ActivityEconomicCompany(Integer idActivityEconomic) {
        this.idActivityEconomic = idActivityEconomic;
    }

    public ActivityEconomicCompany(Integer idActivityEconomic, String nameActivityEconomic, boolean statusActivityeconomic) {
        this.idActivityEconomic = idActivityEconomic;
        this.nameActivityEconomic = nameActivityEconomic;
        this.statusActivityeconomic = statusActivityeconomic;
    }

    public Integer getIdActivityEconomic() {
        return idActivityEconomic;
    }

    public void setIdActivityEconomic(Integer idActivityEconomic) {
        this.idActivityEconomic = idActivityEconomic;
    }

    public String getNameActivityEconomic() {
        return nameActivityEconomic;
    }

    public void setNameActivityEconomic(String nameActivityEconomic) {
        this.nameActivityEconomic = nameActivityEconomic;
    }

    public boolean getStatusActivityeconomic() {
        return statusActivityeconomic;
    }

    public void setStatusActivityeconomic(boolean statusActivityeconomic) {
        this.statusActivityeconomic = statusActivityeconomic;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivityEconomic != null ? idActivityEconomic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityEconomicCompany)) {
            return false;
        }
        ActivityEconomicCompany other = (ActivityEconomicCompany) object;
        if ((this.idActivityEconomic == null && other.idActivityEconomic != null) || (this.idActivityEconomic != null && !this.idActivityEconomic.equals(other.idActivityEconomic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.ActivityEconomicCompany[ idActivityEconomic=" + idActivityEconomic + " ]";
    }
    
}
