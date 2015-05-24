package ec.com.gesso.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Roberto on 04/05/2015.
 */

@Embeddable
public class UserProfileMenuPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "men_id")
    private Integer menuId ;

    @Basic(optional = false)
    @Column(name = "prf_id")
    private Integer profileId ;

    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer userId ;

    public UserProfileMenuPK(){

    }

    public UserProfileMenuPK(Integer menuId, Integer profileId, Integer userId) {
        this.menuId = menuId;
        this.profileId = profileId;
        this.userId = userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
