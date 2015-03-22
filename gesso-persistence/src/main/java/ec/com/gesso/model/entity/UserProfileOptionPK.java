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
public class UserProfileOptionPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "opt_id")
    private int optId;
    @Basic(optional = false)
    @Column(name = "prf_id")
    private int prfId;
    @Basic(optional = false)
    @Column(name = "usr_id")
    private int usrId;

    public UserProfileOptionPK() {
    }

    public UserProfileOptionPK(int optId, int prfId, int usrId) {
        this.optId = optId;
        this.prfId = prfId;
        this.usrId = usrId;
    }

    public int getOptId() {
        return optId;
    }

    public void setOptId(int optId) {
        this.optId = optId;
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
    
}
