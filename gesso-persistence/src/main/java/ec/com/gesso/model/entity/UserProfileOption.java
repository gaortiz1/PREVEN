/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_user_profile_option")

public class UserProfileOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserProfileOptionPK segUserProfileOptionPK;
    @Basic(optional = false)
    @Column(name = "upo_status")
    private boolean upoStatus;
    @JoinColumns({
        @JoinColumn(name = "prf_id", referencedColumnName = "prf_id", insertable = false, updatable = false),
        @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserProfile segUserProfile;
    @JoinColumn(name = "opt_id", referencedColumnName = "opt_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Option segOption;

    public UserProfileOption() {
    }

    public UserProfileOption(UserProfileOptionPK segUserProfileOptionPK) {
        this.segUserProfileOptionPK = segUserProfileOptionPK;
    }

    public UserProfileOption(UserProfileOptionPK segUserProfileOptionPK, boolean upoStatus) {
        this.segUserProfileOptionPK = segUserProfileOptionPK;
        this.upoStatus = upoStatus;
    }

    public UserProfileOption(int optId, int prfId, int usrId) {
        this.segUserProfileOptionPK = new UserProfileOptionPK(optId, prfId, usrId);
    }

    public UserProfileOptionPK getSegUserProfileOptionPK() {
        return segUserProfileOptionPK;
    }

    public void setSegUserProfileOptionPK(UserProfileOptionPK segUserProfileOptionPK) {
        this.segUserProfileOptionPK = segUserProfileOptionPK;
    }

    public boolean getUpoStatus() {
        return upoStatus;
    }

    public void setUpoStatus(boolean upoStatus) {
        this.upoStatus = upoStatus;
    }

    public UserProfile getSegUserProfile() {
        return segUserProfile;
    }

    public void setSegUserProfile(UserProfile segUserProfile) {
        this.segUserProfile = segUserProfile;
    }

    public Option getSegOption() {
        return segOption;
    }

    public void setSegOption(Option segOption) {
        this.segOption = segOption;
    }
    
}
