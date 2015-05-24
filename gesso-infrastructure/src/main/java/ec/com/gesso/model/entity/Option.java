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
@SuppressWarnings("serial")
@Entity
@Table(name = "seg_option")

public class Option implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Column(name = "opt_id")
    private Integer optionId;
    @Basic(optional = false)
    @Column(name = "opt_name")
    private String optionName;
    
    @Column(name = "opt_path")
    private String optionPath;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "option", fetch = FetchType.LAZY)
    private Collection<UserProfileOption> lstUserProfileOption;
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu menu;

    public Option() {
    }

    public Option(Integer optId) {
        this.optionId = optId;
    }

    public Option(Integer optId, String optName) {
        this.optionId = optId;
        this.optionName = optName;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
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

	public String getOptionPath() {
		return optionPath;
	}

	public void setOptionPath(String optionPath) {
		this.optionPath = optionPath;
	}
    
    
}
