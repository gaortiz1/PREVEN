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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_option")

public class OptionDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "opt_id")
    private Integer optId;
    @Basic(optional = false)
    @Column(name = "opt_name")
    private String optName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segOption", fetch = FetchType.LAZY)
    private Collection<UserProfileOptionDto> segUserProfileOptionCollection;
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MenuDto segMenu;

    public OptionDto() {
    }

    public OptionDto(Integer optId) {
        this.optId = optId;
    }

    public OptionDto(Integer optId, String optName) {
        this.optId = optId;
        this.optName = optName;
    }

    public Integer getOptId() {
        return optId;
    }

    public void setOptId(Integer optId) {
        this.optId = optId;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public Collection<UserProfileOptionDto> getSegUserProfileOptionCollection() {
        return segUserProfileOptionCollection;
    }

    public void setSegUserProfileOptionCollection(Collection<UserProfileOptionDto> segUserProfileOptionCollection) {
        this.segUserProfileOptionCollection = segUserProfileOptionCollection;
    }

    public MenuDto getSegMenu() {
        return segMenu;
    }

    public void setSegMenu(MenuDto segMenu) {
        this.segMenu = segMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optId != null ? optId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OptionDto)) {
            return false;
        }
        OptionDto other = (OptionDto) object;
        if ((this.optId == null && other.optId != null) || (this.optId != null && !this.optId.equals(other.optId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.SegOption[ optId=" + optId + " ]";
    }
    
}