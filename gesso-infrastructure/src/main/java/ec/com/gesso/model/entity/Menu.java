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
    private Integer menuId;
    @Basic(optional = false)
    @Column(name = "men_name")
    private String menuName;
    @Basic(optional = false)
    @Column(name = "men_status")
    private Boolean status;
    @JoinColumn(name = "sys_id", referencedColumnName = "sys_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private System system;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.EAGER)
    private Collection<Option> lstOption;

    public Menu() {
    }

    public Menu(Integer menId) {
        this.menuId = menId;
    }

    public Menu(Integer menId, String menName, Boolean menStatus) {
        this.menuId = menId;
        this.menuName = menName;
        this.status = menStatus;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Collection<Option> getLstOption() {
        return lstOption;
    }

    public void setLstOption(Collection<Option> lstOption) {
        this.lstOption = lstOption;
    }
}
