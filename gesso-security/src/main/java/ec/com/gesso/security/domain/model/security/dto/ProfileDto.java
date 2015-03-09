/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_profile")

public class ProfileDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prf_id")
    private Integer prfId;
    @Basic(optional = false)
    @Column(name = "prf_name")
    private String prfName;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segProfile", fetch = FetchType.LAZY)
    private Collection<UserProfileDto> segUserProfileCollection;

    public ProfileDto() {
    }

    public ProfileDto(Integer prfId) {
        this.prfId = prfId;
    }

    public ProfileDto(Integer prfId, String prfName, boolean status) {
        this.prfId = prfId;
        this.prfName = prfName;
        this.status = status;
    }

    public Integer getPrfId() {
        return prfId;
    }

    public void setPrfId(Integer prfId) {
        this.prfId = prfId;
    }

    public String getPrfName() {
        return prfName;
    }

    public void setPrfName(String prfName) {
        this.prfName = prfName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<UserProfileDto> getSegUserProfileCollection() {
        return segUserProfileCollection;
    }

    public void setSegUserProfileCollection(Collection<UserProfileDto> segUserProfileCollection) {
        this.segUserProfileCollection = segUserProfileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prfId != null ? prfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileDto)) {
            return false;
        }
        ProfileDto other = (ProfileDto) object;
        if ((this.prfId == null && other.prfId != null) || (this.prfId != null && !this.prfId.equals(other.prfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.SegProfile[ prfId=" + prfId + " ]";
    }
    
}
