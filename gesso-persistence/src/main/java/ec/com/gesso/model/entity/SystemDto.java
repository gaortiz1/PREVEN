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

public class SystemDto implements Serializable {
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
    private boolean sysStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segSystem", fetch = FetchType.LAZY)
    private Collection<MenuDto> segMenuCollection;

    public SystemDto() {
    }

    public SystemDto(Integer sysId) {
        this.sysId = sysId;
    }

    public SystemDto(Integer sysId, String sysName, boolean sysStatus) {
        this.sysId = sysId;
        this.sysName = sysName;
        this.sysStatus = sysStatus;
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

    public boolean getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(boolean sysStatus) {
        this.sysStatus = sysStatus;
    }

    public Collection<MenuDto> getSegMenuCollection() {
        return segMenuCollection;
    }

    public void setSegMenuCollection(Collection<MenuDto> segMenuCollection) {
        this.segMenuCollection = segMenuCollection;
    }
}
