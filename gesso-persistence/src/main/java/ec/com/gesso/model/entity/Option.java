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
@Table(name = "seg_option")

public class Option implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "opt_id")
    private Integer optId;
    @Basic(optional = false)
    @Column(name = "opt_name")
    private String optName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "option", fetch = FetchType.LAZY)
    private Collection<UserProfileOption> lstUserProfileOption;
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu menu;

    public Option() {
    }

    public Option(Integer optId) {
        this.optId = optId;
    }

    public Option(Integer optId, String optName) {
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

    public Collection<UserProfileOption> getLstUserProfileOption() {
        return lstUserProfileOption;
    }

    public void setLstUserProfileOption(Collection<UserProfileOption> lstUserProfileOption) {
        this.lstUserProfileOption = lstUserProfileOption;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
