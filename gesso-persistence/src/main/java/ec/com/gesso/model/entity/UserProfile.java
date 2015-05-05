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
    protected UserProfilePK userProfilePK;
    //@Basic(optional = false)
    @Column(name = "id_company")
    private Integer idCompany;
    @Basic(optional = false)
    @Column(name = "upr_status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userProfile", fetch = FetchType.LAZY)
    private Collection<UserProfileOption> lstUserProfileOption;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userDto;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userProfile", fetch = FetchType.EAGER)
    private Collection<UserProfileMenu> lstUserProfileMenu;

    public UserProfile() {
    }

    public UserProfile(UserProfilePK segUserProfilePK) {
        this.userProfilePK = segUserProfilePK;
    }

    public UserProfile(UserProfilePK segUserProfilePK, Integer idCompany, boolean uprStatus) {
        this.userProfilePK = segUserProfilePK;
        this.idCompany = idCompany;
        this.status = uprStatus;
    }

    public UserProfile(Integer prfId, Integer usrId) {
        this.userProfilePK = new UserProfilePK(prfId, usrId);
    }

    public UserProfilePK getUserProfilePK() {
        return userProfilePK;
    }

    public void setUserProfilePK(UserProfilePK userProfilePK) {
        this.userProfilePK = userProfilePK;
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

    public Collection<UserProfileOption> getLstUserProfileOption() {
        return lstUserProfileOption;
    }

    public void setLstUserProfileOption(Collection<UserProfileOption> lstUserProfileOption) {
        this.lstUserProfileOption = lstUserProfileOption;
    }

    public User getUserDto() {
		return userDto;
	}

	public void setUserDto(User userDto) {
		this.userDto = userDto;
	}

	public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Collection<UserProfileMenu> getLstUserProfileMenu() {
        return lstUserProfileMenu;
    }

    public void setLstUserProfileMenu(Collection<UserProfileMenu> lstUserProfileMenu) {
        this.lstUserProfileMenu = lstUserProfileMenu;
    }
}
