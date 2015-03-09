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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_system")
@NamedQueries({
    @NamedQuery(name = "SegSystem.findAll", query = "SELECT s FROM SegSystem s")})
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysId != null ? sysId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemDto)) {
            return false;
        }
        SystemDto other = (SystemDto) object;
        if ((this.sysId == null && other.sysId != null) || (this.sysId != null && !this.sysId.equals(other.sysId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.SegSystem[ sysId=" + sysId + " ]";
    }
    
}
