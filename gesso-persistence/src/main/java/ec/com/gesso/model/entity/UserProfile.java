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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_user_profile")

public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserProfilePK segUserProfilePK;
    //@Basic(optional = false)
    @Column(name = "id_company")
    private Integer idCompany;
    @Basic(optional = false)
    @Column(name = "upr_status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUserProfile", fetch = FetchType.LAZY)
    private Collection<UserProfileOption> segUserProfileOptionCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userDto;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profile segProfile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userProfile", fetch = FetchType.LAZY)
    private Collection<UserProfileMenu> lstUserProfileMenu;

    public UserProfile() {
    }

    public UserProfile(UserProfilePK segUserProfilePK) {
        this.segUserProfilePK = segUserProfilePK;
    }

    public UserProfile(UserProfilePK segUserProfilePK, Integer idCompany, boolean uprStatus) {
        this.segUserProfilePK = segUserProfilePK;
        this.idCompany = idCompany;
        this.status = uprStatus;
    }

    public UserProfile(int prfId, int usrId) {
        this.segUserProfilePK = new UserProfilePK(prfId, usrId);
    }

    public UserProfilePK getSegUserProfilePK() {
        return segUserProfilePK;
    }

    public void setSegUserProfilePK(UserProfilePK segUserProfilePK) {
        this.segUserProfilePK = segUserProfilePK;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<UserProfileOption> getSegUserProfileOptionCollection() {
        return segUserProfileOptionCollection;
    }

    public void setSegUserProfileOptionCollection(Collection<UserProfileOption> segUserProfileOptionCollection) {
        this.segUserProfileOptionCollection = segUserProfileOptionCollection;
    }

    public User getUserDto() {
		return userDto;
	}

	public void setUserDto(User userDto) {
		this.userDto = userDto;
	}

	public Profile getSegProfile() {
        return segProfile;
    }

    public void setSegProfile(Profile segProfile) {
        this.segProfile = segProfile;
    }

    public Collection<UserProfileMenu> getLstUserProfileMenu() {
        return lstUserProfileMenu;
    }

    public void setLstUserProfileMenu(Collection<UserProfileMenu> lstUserProfileMenu) {
        this.lstUserProfileMenu = lstUserProfileMenu;
    }
}
