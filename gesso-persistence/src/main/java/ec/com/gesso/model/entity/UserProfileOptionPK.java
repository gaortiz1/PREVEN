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
    private Integer optId;
    @Basic(optional = false)
    @Column(name = "prf_id")
    private Integer prfId;
    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer usrId;

    public UserProfileOptionPK() {
    }

    public UserProfileOptionPK(Integer optId, Integer prfId, Integer usrId) {
        this.optId = optId;
        this.prfId = prfId;
        this.usrId = usrId;
    }

    public Integer getOptId() {
        return optId;
    }

    public void setOptId(Integer optId) {
        this.optId = optId;
    }

    public Integer getPrfId() {
        return prfId;
    }

    public void setPrfId(Integer prfId) {
        this.prfId = prfId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }
}
