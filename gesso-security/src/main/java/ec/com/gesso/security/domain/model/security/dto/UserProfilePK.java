/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roberto
 */
@Embeddable
public class UserProfilePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "prf_id")
    private int prfId;
    @Basic(optional = false)
    @Column(name = "usr_id")
    private int usrId;

    public UserProfilePK() {
    }

    public UserProfilePK(int prfId, int usrId) {
        this.prfId = prfId;
        this.usrId = usrId;
    }

    public int getPrfId() {
        return prfId;
    }

    public void setPrfId(int prfId) {
        this.prfId = prfId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prfId;
        hash += (int) usrId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfilePK)) {
            return false;
        }
        UserProfilePK other = (UserProfilePK) object;
        if (this.prfId != other.prfId) {
            return false;
        }
        if (this.usrId != other.usrId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.SegUserProfilePK[ prfId=" + prfId + ", usrId=" + usrId + " ]";
    }
    
}
