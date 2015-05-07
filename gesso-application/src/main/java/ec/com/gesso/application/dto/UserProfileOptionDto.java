package ec.com.gesso.application.dto;

/**
 * Created by Roberto on 05/05/2015.
 */
public class UserProfileOptionDto {
    private Boolean status;

    private UserProfileDto userProfile;

    public UserProfileOptionDto() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserProfileDto getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDto userProfile) {
        this.userProfile = userProfile;
    }
}
