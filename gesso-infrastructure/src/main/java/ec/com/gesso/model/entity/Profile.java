/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

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

public class Profile implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", fetch = FetchType.LAZY)
    private Collection<UserProfile> lstUserProfile;

    public Profile() {
    }

    public Profile(Integer prfId) {
        this.prfId = prfId;
    }

    public Profile(Integer prfId, String prfName, boolean status) {
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

    public Collection<UserProfile> getLstUserProfile() {
        return lstUserProfile;
    }

    public void setLstUserProfile(Collection<UserProfile> lstUserProfile) {
        this.lstUserProfile = lstUserProfile;
    }
}
