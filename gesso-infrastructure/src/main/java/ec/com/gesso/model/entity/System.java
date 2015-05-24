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
@Table(name = "seg_system")

public class System implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sys_id")
    private Integer sysId;
    @Basic(optional = false)
    @Column(name = "sys_name")
    private String sysName;
    @Basic(optional = false)
    @Column(name = "sys_status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "system", fetch = FetchType.LAZY)
    private Collection<Menu> lstMenu;

    public System() {
    }

    public System(Integer sysId) {
        this.sysId = sysId;
    }

    public System(Integer sysId, String sysName, Boolean sysStatus) {
        this.sysId = sysId;
        this.sysName = sysName;
        this.status = sysStatus;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<Menu> getLstMenu() {
        return lstMenu;
    }

    public void setLstMenu(Collection<Menu> lstMenu) {
        this.lstMenu = lstMenu;
    }
}
