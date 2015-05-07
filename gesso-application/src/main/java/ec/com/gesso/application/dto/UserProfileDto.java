package ec.com.gesso.application.dto;

import java.util.Collection;

/**
 * Created by Roberto on 05/05/2015.
 */
public class UserProfileDto {

    private Integer idCompany;

    private Collection<UserProfileMenuDto> lstUserProfileMenu;
    //private Collection<UserProfileOptionDto> lstUserProfileOption;

    public UserProfileDto(){}

    public Collection<UserProfileMenuDto> getLstUserProfileMenu() {
        return lstUserProfileMenu;
    }

    public void setLstUserProfileMenu(Collection<UserProfileMenuDto> lstUserProfileMenu) {
        this.lstUserProfileMenu = lstUserProfileMenu;
    }
/*
    public Collection<UserProfileOptionDto> getLstUserProfileOption() {
        return lstUserProfileOption;
    }

    public void setLstUserProfileOption(Collection<UserProfileOptionDto> lstUserProfileOption) {
        this.lstUserProfileOption = lstUserProfileOption;
    }
*/
    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }
}
