package ec.com.gesso.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Roberto on 04/05/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "seg_usr_prf_men")
public class UserProfileMenu implements Serializable {
    @EmbeddedId
    protected UserProfileMenuPK userProfileMenuPK;

    @JoinColumns({
            @JoinColumn(name = "prf_id", referencedColumnName = "prf_id", insertable = false, updatable = false),
            @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserProfile userProfile;

    @JoinColumn(name = "men_id", referencedColumnName = "men_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Menu menu;

    public UserProfileMenu() {
    }

    public UserProfileMenu(UserProfileMenuPK userProfileMenuPK) {
        this.userProfileMenuPK = userProfileMenuPK;
    }

    public UserProfileMenuPK getUserProfileMenuPK() {
        return userProfileMenuPK;
    }

    public void setUserProfileMenuPK(UserProfileMenuPK userProfileMenuPK) {
        this.userProfileMenuPK = userProfileMenuPK;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
