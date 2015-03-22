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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_menu")

public class MenuDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "men_id")
    private Integer menId;
    @Basic(optional = false)
    @Column(name = "men_name")
    private String menName;
    @Basic(optional = false)
    @Column(name = "men_status")
    private boolean menStatus;
    @JoinColumn(name = "sys_id", referencedColumnName = "sys_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SystemDto segSystem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMenu", fetch = FetchType.LAZY)
    private Collection<OptionDto> segOptionCollection;

    public MenuDto() {
    }

    public MenuDto(Integer menId) {
        this.menId = menId;
    }

    public MenuDto(Integer menId, String menName, boolean menStatus) {
        this.menId = menId;
        this.menName = menName;
        this.menStatus = menStatus;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenName() {
        return menName;
    }

    public void setMenName(String menName) {
        this.menName = menName;
    }

    public boolean getMenStatus() {
        return menStatus;
    }

    public void setMenStatus(boolean menStatus) {
        this.menStatus = menStatus;
    }

    public SystemDto getSegSystem() {
        return segSystem;
    }

    public void setSegSystem(SystemDto segSystem) {
        this.segSystem = segSystem;
    }

    public Collection<OptionDto> getSegOptionCollection() {
        return segOptionCollection;
    }

    public void setSegOptionCollection(Collection<OptionDto> segOptionCollection) {
        this.segOptionCollection = segOptionCollection;
    }
}
