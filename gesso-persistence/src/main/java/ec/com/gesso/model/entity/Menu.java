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

public class Menu implements Serializable {
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
    private System segSystem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMenu", fetch = FetchType.LAZY)
    private Collection<Option> segOptionCollection;

    public Menu() {
    }

    public Menu(Integer menId) {
        this.menId = menId;
    }

    public Menu(Integer menId, String menName, boolean menStatus) {
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

    public System getSegSystem() {
        return segSystem;
    }

    public void setSegSystem(System segSystem) {
        this.segSystem = segSystem;
    }

    public Collection<Option> getSegOptionCollection() {
        return segOptionCollection;
    }

    public void setSegOptionCollection(Collection<Option> segOptionCollection) {
        this.segOptionCollection = segOptionCollection;
    }
}
