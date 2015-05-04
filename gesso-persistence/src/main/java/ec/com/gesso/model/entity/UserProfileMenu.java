package ec.com.gesso.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}
