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

public class UserProfileDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserProfilePK segUserProfilePK;
    @Basic(optional = false)
    @Column(name = "id_company")
    private long idCompany;
    @Basic(optional = false)
    @Column(name = "upr_status")
    private boolean uprStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUserProfile", fetch = FetchType.LAZY)
    private Collection<UserProfileOptionDto> segUserProfileOptionCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserDto userDto;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfileDto segProfile;

    public UserProfileDto() {
    }

    public UserProfileDto(UserProfilePK segUserProfilePK) {
        this.segUserProfilePK = segUserProfilePK;
    }

    public UserProfileDto(UserProfilePK segUserProfilePK, long idCompany, boolean uprStatus) {
        this.segUserProfilePK = segUserProfilePK;
        this.idCompany = idCompany;
        this.uprStatus = uprStatus;
    }

    public UserProfileDto(int prfId, int usrId) {
        this.segUserProfilePK = new UserProfilePK(prfId, usrId);
    }

    public UserProfilePK getSegUserProfilePK() {
        return segUserProfilePK;
    }

    public void setSegUserProfilePK(UserProfilePK segUserProfilePK) {
        this.segUserProfilePK = segUserProfilePK;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public boolean getUprStatus() {
        return uprStatus;
    }

    public void setUprStatus(boolean uprStatus) {
        this.uprStatus = uprStatus;
    }

    public Collection<UserProfileOptionDto> getSegUserProfileOptionCollection() {
        return segUserProfileOptionCollection;
    }

    public void setSegUserProfileOptionCollection(Collection<UserProfileOptionDto> segUserProfileOptionCollection) {
        this.segUserProfileOptionCollection = segUserProfileOptionCollection;
    }

    public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public ProfileDto getSegProfile() {
        return segProfile;
    }

    public void setSegProfile(ProfileDto segProfile) {
        this.segProfile = segProfile;
    }
}